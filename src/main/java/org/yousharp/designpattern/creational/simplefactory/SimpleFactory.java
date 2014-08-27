package org.yousharp.designpattern.creational.simplefactory;

/**
 * 简单工厂模式：使用工厂来决定创建哪一个具体的实现；
 *  - 一个product有多个实现，有一个factory类负责创建具体实现的对象；
 *  - client需要一个product时，不是直接通过new来创建，而是告诉factory需要的product的类型；
 *  - factory就是创建所有具体product的工厂，根据类型返回一个具体的对象(多态)；
 *
 * 两个要点：
 *  - product有一个抽象product，和一些具体product，当需要新加一个product时，只需继承抽象product即可；
 *  - factory中有各种具体product的构造方式，根据不同的条件创建不同的具体product对象，因此factory中存在
 *  分支条件判断；
 *
 * 缺点：
 *  - 因为factory中存在分支条件判断，因此当新增一个具体product时，需要修改factory类，这就违背了OCP原则；
 *  因此，简单工厂模式在实际中用处很少，只是为了说明原理；
 *  - 简单工厂模式的改进：参考反射实现；
 *
 * @author: lingguo
 * @time: 2014/8/14 7:25
 */
public class SimpleFactory {

    /**
     * 简单工厂：根据条件创建具体的product对象，并以抽象product返回；
     *
     * @param id
     * @return
     */
    public static Product createProduct(int id) {
        if (id == 1) {
            return new ProductOne();
        } else if (id == 2){
            return new ProductTwo();
        }
        return null;
    }
}

/**
 * 抽象product接口
 */
interface Product {
    public void printInfo();
}

/**
 * 具体product1
 */
class ProductOne implements Product {
    @Override
    public void printInfo() {
        System.out.println("I'm product one.");
    }
}

/**
 * 具体product2
 */
class ProductTwo implements Product {
    @Override
    public void printInfo() {
        System.out.println("I'm product two.");
    }
}

/**
 * 客户端：需要对象时，向factory传入条件，返回的是一个具体product对象，但客户端
 * 无需知道具体类型；
 */
class SimpleClient {
    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct(1);
        product.printInfo();
        product = SimpleFactory.createProduct(2);
        product.printInfo();
    }
}
