package org.yousharp.designpattern.structural.proxy;

import java.util.concurrent.TimeUnit;

/**
 * 代理模式：为其它对象提供一种代理以控制对这个对象的访问；其实，代理类就是讲客户的请求
 *  转发给被代理的类；
 *
 * 要点：
 *  - 由于代理类要将请求转发给被代理的类，所以二者的主要接口是相同的，所以它们实现同一个接口；
 *  - 代理类中有被代理类的引用，客户直接与代理类交互，间接与被代理的类交互；
 *
 * 适用场景：
 *  - 安全代理：使用代理类控制外部对真实对象的访问权限；
 *  - 虚拟代理：；
 *  - 远程代理：
 *
 * 参考：
 *  - http://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
 *
 * @author: lingguo
 * @time: 2014/8/21 21:42
 */
public class Proxy {
}

/**
 * 接口：代理类和真实类的公共接口
 */
interface Image {
    public void display();
}

/**
 * 真实类，实现自己的操作；同步性是我测试时自己添加的；
 */
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public synchronized void display() {
        System.out.println("display image: " + fileName);
    }

    public void loadFromDisk(String fileName) {
        System.out.println("loading image from disk: " + fileName);
    }
}

/**
 * 代理类：将请求转发给真实类；同步性是我测试时自己添加的；
 */
class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public synchronized void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

/**
 * 客户端请求
 */
class WebClient {
    public static void main(String[] args) {
        final Image image = new ProxyImage("proxy-pattern.img");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            image.display();
                        }
                    }).start();
                }
            }
        });
        t.start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}