package org.yousharp.designpattern.creational.factorymethod;

/**
 * 工厂方法模式：定义一个创建对象的接口，让该接口的子类决定实例化哪一个对象；即将
 * 对象的实例化延迟到子类；
 * 简单地说，就是定义一个创建product的factory，然后对每一个具体的product，创建一个
 * 具体的子类factory，用于创建该具体product的实例；四个部分：
 *  - 抽象factory：定义一个创建抽象product的方法；
 *  - 具体factory：实现父接口的创建，创建具体product的实例；
 *  - 抽象product：product的抽象接口；
 *  - 具体product：描述具体的product；
 *
 * 工厂方法与简单工厂的区别与联系：
 *  - 简单工厂里，只有一个factory，创建具体product的分支判断在factory里完成，客户端不做判断；
 *  - 工厂方法：抽象工厂不创建具体的实例，而是由其子类来创建实例，创建具体product的分支判断
 *  由客户端完成；
 *  - 简单地说，工厂方法将创建对象的条件判断由工厂移到了客户端，这样，当增加新的具体product时，
 *  只需要增加一个对应的子factory即可，不用修改factory类，克服了简单工厂违背OCP原则的缺点；
 *
 * @author: lingguo
 * @time: 2014/8/14 21:39
 */
public class FactoryMethod {

}

/**
 * 抽象的product接口
 */
interface Phone {
    public void takePhoto();
}

/**
 * 具体的product 1
 */
class HammerPhone implements Phone {
    @Override
    public void takePhoto() {
        System.out.println("Hammer phone is taking photos...");
    }
}

/**
 * 具体的product 2
 */
class XiaoMiPhone implements Phone {
    @Override
    public void takePhoto() {
        System.out.println("XiaoMi phone is taking photos...");
    }
}

/**
 * 抽象的factory，定义一个创建抽象product的方法；该factory既可以是一个接口，
 * 也可以是一个抽象类，可以有完成其它任务的普通方法；
 */
interface PhoneFactory {
    public Phone createPhone();
}

/**
 * 具体的factory，创建具体product的实例
 */
class HammerPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new HammerPhone();
    }
}

/**
 * 具体的factory 2，创建具体的实例
 */
class XiaoMiPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new XiaoMiPhone();
    }
}

/**
 * 客户端：先根据条件创建具体的factory，然后创建具体的实例
 */
class PhoneClient {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new HammerPhoneFactory();
        Phone phone = phoneFactory.createPhone();
        phone.takePhoto();

        phoneFactory = new XiaoMiPhoneFactory();
        phone = phoneFactory.createPhone();
        phone.takePhoto();


    }
}
