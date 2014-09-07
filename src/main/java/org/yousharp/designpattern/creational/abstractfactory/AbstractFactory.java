package org.yousharp.designpattern.creational.abstractfactory;

/**
 * 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类；
 *  我们有多种product，每一种product都有多种实现，但是这些product中对应实现属于同一类型，
 *  即product1的实现1与product2的实现1、与product3的实现1是一个类型，则称为一系列具体产品，
 *  此时我们可以创建一个具体factory，用于创建这一系列产品的对象，每一系列产品对应一个具体
 *  factory；在每一种产品上抽象出一个product接口，在具体的factory上抽象出一个factory接口，
 *  则形成了抽象工厂模式。产品的一种具体实现，对应一个具体的factory，所以具体factory的数量
 *  与产品的具体实现的数量是一样的。
 *  - product1接口，两种实现，product1实现1，product1实现2；
 *  - product2接口，两种实现，product2实现1，product2实现2；
 *  - 抽象factory：定义创建每一种产品的抽象方法，创建product1，创建product2
 *  - 具体factory1：使用第一种实现创建每一种产品，product1和product2；
 *  - 具体factory2：使用第二种实现创建每一种产品，product1和product2；
 *  - client：要创建某一种实现的一系列product时，只需初始化时指定具体的factory即可；
 *
 *  抽象工厂与工厂方法的区别于联系：
 *  - 如果只有一种product，显然就是工厂方法模式，每一种实现对应一种具体的factory；
 *  - 如果有多种product，每一种product均有多种实现，则将不同product中同类实现交给一个
 *  具体的factory，此时就是抽象工厂模式；
 *  - 两者都是由客户端决定具体的创建逻辑判断，因此都可以通过反射等手段进行优化；
 *
 *
 * @author: lingguo
 * @time: 2014/8/15 21:57
 */
public class AbstractFactory {
}

/**
 * 第一种product1
 */
interface Computer {
    public void printBrand();
}

/**
 * product1第一种实现，Apple制造
 */
class MacBook implements Computer {
    @Override
    public void printBrand() {
        System.out.println("this is MacBook.");
    }
}

/**
 * product1第二种实现：Google制造
 */
class ChromeBook implements Computer {
    @Override
    public void printBrand() {
        System.out.println("this is ChromeBook.");
    }
}

/**
 * 第二种产品product2
 */
interface MobileSystem {
    public void printInfo();
}

/**
 * product2第一种实现：Apple制造
 */
class IOS implements MobileSystem {
    @Override
    public void printInfo() {
        System.out.println("I'm IOS.");
    }
}

/**
 * product2第二种实现：Google制造
 */
class Android implements MobileSystem {
    @Override
    public void printInfo() {
        System.out.println("I'm Android.");
    }
}

/**
 * 抽象factory，提供每一种产品的抽象创建方法
 */
interface TechFactory {
    public Computer createComputer();
    public MobileSystem createSystem();
}

/**
 * 具体factory1，第一种类型的实现，创建由第一种实现创建的所有对象
 */
class AppleFactory implements TechFactory {
    @Override
    public Computer createComputer() {
        return new MacBook();
    }

    @Override
    public MobileSystem createSystem() {
        return new IOS();
    }
}

/**
 * 具体factory2:，第二种类型的实现，创建由第二种实现创建的所有对象
 */
class GoogleFactory implements TechFactory {
    @Override
    public Computer createComputer() {
        return new ChromeBook();
    }

    @Override
    public MobileSystem createSystem() {
        return new Android();
    }
}

/**
 * 客户端：决定采用哪一种factory创建这种系列的所有产品，如果实现发生变化，
 * 只需在具体的factory即可；
 */
class AbstractFactoryClient {
    public static void main(String[] args) {
        TechFactory techFactory = new AppleFactory();
        Computer computer = techFactory.createComputer();
        MobileSystem mobileSystem = techFactory.createSystem();
        computer.printBrand();
        mobileSystem.printInfo();

        techFactory = new GoogleFactory();
        computer = techFactory.createComputer();
        mobileSystem = techFactory.createSystem();
        computer.printBrand();
        mobileSystem.printInfo();

    }
}