package org.yousharp.designpattern.creational.objectpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Object Pool(资源池)：将创建的资源缓存起来以便重用；
 *
 * 适合的场景：
 *  - 对象的创建非常昂贵；
 *  - 对象创建的频率很高；
 *  - 同一时刻使用的对象的数量比较少；
 *
 * 关键点：
 *  - 客户端需要一个对象，从资源池中获取，而不是直接创建；
 *  - 如果资源池中有空闲的对象，则返回，否则，资源池根据是否达到最大
 *  资源限制，决定是创建一个新对象，还是让客户端等待可用资源；
 *  - 为了使客户端访问的是全局统一的资源池，应该将资源池类实现为单例类，
 *  或者客户端在使用资源池时，将其作为全局单例使用；
 *
 * 参考：
 *  - http://sourcemaking.com/design_patterns/object_pool
 *
 * @author: lingguo
 * @time: 2014/8/18 9:16
 */

/**
 * 泛型资源池
 *
 * @param <T>
 */
public abstract class ObjectPool<T> {
    /**
     * 过期时间；
     * 已用的资源列表；
     * 空闲的资源列表；
     */
    private long expirationTime;
    private ConcurrentHashMap<T, Long> used;
    private ConcurrentHashMap<T, Long> unused;


    public ObjectPool() {
        used = new ConcurrentHashMap<>();
        unused = new ConcurrentHashMap<>();
    }

    /**
     * 从资源池中返回资源
     *
     * @return
     */
    public synchronized T checkout() {
        long now = System.currentTimeMillis();
        T resource;
        if (unused.size() > 0) {
            Iterator<T> iterator = unused.keySet().iterator();
            while (iterator.hasNext()) {
                resource = iterator.next();
                if (now - unused.get(resource) > expirationTime) {
                    unused.remove(resource);
                    expire(resource);
                    resource = null;
                } else {
                    if (validate(resource)) {
                        unused.remove(resource);
                        used.putIfAbsent(resource, now);
                        return resource;
                    } else {
                        unused.remove(resource);
                        expire(resource);
                        resource = null;
                    }
                }
            }
        }

        resource = create();
        used.putIfAbsent(resource, System.currentTimeMillis());
        return resource;
    }

    /**
     * 将资源返回到资源池
     *
     * @param resource
     */
    public synchronized void checkin(T resource) {
        used.remove(resource);
        if (validate(resource)) {
            unused.putIfAbsent(resource, System.currentTimeMillis());
        }
    }

    /**
     * 1. 显然，这里用到了模板方法模式：抽象类中定义算法的基本骨架和算法逻辑，然后将具体的
     *  实现延迟到子类中；
     */

    public abstract void expire(T conn);

    public abstract boolean validate(T conn);

    public abstract T create();

}

/**
 * JDBC资源池的简单实现
 */
class JDBCConnectionPool extends ObjectPool<Connection> {
    private String driver, url, user, pwd;

    public JDBCConnectionPool(String driver, String url, String user, String pwd) {
        super();
        /**
         * 使用反射创建一个新的对象;
         */
        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    public void expire(Connection conn) {
        try {
            ((Connection)conn).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validate(Connection conn) {
        boolean valid = true;
        try {
            if (((Connection)conn).isClosed()) {
                valid = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public Connection create() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

class JDBCClient{
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://10.10.79.202:3306/feedback";
        String user = "pvdm";
        String pwd = "pvdm";

        JDBCConnectionPool connectionPool = new JDBCConnectionPool(driver, url, user, pwd);
        Connection connection = connectionPool.checkout();
        try {
            System.out.println(connection.getClientInfo());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connectionPool.checkin(connection);
    }

}