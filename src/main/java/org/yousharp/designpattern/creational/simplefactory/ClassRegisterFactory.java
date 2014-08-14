package org.yousharp.designpattern.creational.simplefactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 使用类反射改进简单工厂模式：
 *  - 在factory里，将具体product的创建条件和类注册到一个HashMap里，每次有一个新的具体产品，都先注册；
 *  然后在创建实例时，通过类的反射创建新的对象；
 *  - 在具体product中，先将创建条件和类注册到factory的HashMap上；
 *
 * @author: lingguo
 * @time: 2014/8/14 7:48
 */
public class ClassRegisterFactory {
    /**
     * factory采用单例
     */
    private static ClassRegisterFactory instance = new ClassRegisterFactory();
    /**
     * HashMap用于注册具体product的信息
     */
    private ConcurrentMap<Integer, Class> registerClassMap = new ConcurrentHashMap<>();
    private ClassRegisterFactory() {}

    /**
     * 获取factory的单例
     * @return
     */
    public static ClassRegisterFactory getInstance() {
        return instance;
    }

    /**
     * 将product实例的创建条件和类注册
     *
     * @param sportId
     * @param sportClass
     */
    public void registerClass(int sportId, Class sportClass) {
        registerClassMap.putIfAbsent(sportId, sportClass);
    }

    /**
     * 通过反射创建具体的对象
     *
     * @param sportId
     * @return
     */
    public Sport createProduct(int sportId) {
        Class sportClass = registerClassMap.get(sportId);
        Constructor<Sport> sportConstructor = null;
        Sport sport = null;
        try {
            sportConstructor = sportClass.getDeclaredConstructor();
            sport = sportConstructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return sport;
    }
}

/**
 * 抽象product
 */
interface Sport {
    public void printInfo();
}

/**
 * 具体product 1，加载后立即注册
 */
class BasketBall implements Sport {
    static {
        ClassRegisterFactory.getInstance().registerClass(1, BasketBall.class);
    }

    @Override
    public void printInfo() {
        System.out.println("I'm basketball.");
    }
}

/**
 * 具体product 2，加载后立即注册
 */
class Football implements Sport {
    static {
        ClassRegisterFactory.getInstance().registerClass(2, Football.class);
    }

    @Override
    public void printInfo() {
        System.out.println("I'm football.");
    }
}

/**
 * 具体的product只有加载后才能注册到HashMap中，才能通过factory创建实例，如果没有注册，则返回的实例为null；
 * 因此，可以在类的static块中，调用Class.forName()方法(因此static块是在类加载后立即调用的)，该方法返回该类
 * 的变量，如果该类还没有加载，则该方法被调用时先加载(参数名必须为全限定类名)。
 */
class SportClient {
    static {
        try {
            Class.forName("org.yousharp.designpattern.creational.simplefactory.BasketBall");
            Class.forName("org.yousharp.designpattern.creational.simplefactory.Football");
        } catch (ClassNotFoundException e) {
            System.err.println("Class.forName error." + e.getMessage());
        }
    }


    public static void main(String[] args) {
        Sport sport = ClassRegisterFactory.getInstance().createProduct(1);
        sport.printInfo();
        sport = ClassRegisterFactory.getInstance().createProduct(2);
        sport.printInfo();
    }
}