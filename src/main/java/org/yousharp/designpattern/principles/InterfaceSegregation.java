package org.yousharp.designpattern.principles;

import org.junit.Test;

/**
 * 接口隔离原则：定义一个接口，里面有很多方法，对于该接口的一个实现类，需要实现该接口所定义的所有方法，
 * 即使有些方法不会用到。这种强迫子类实现不需要的方法的接口称为肥胖接口(fat-interface)或者
 * 污染接口(polluted-interface)。
 *
 * 这不是一种灵活的设计，应该使用接口隔离，将肥胖接口根据具体的业务逻辑拆分成多个接口。
 *
 * 过度的接口隔离可能会产生很多零碎的单方法的接口，这也是不可取的，应该根据经验和业务场景，将扩展性强
 * 的接口隔离出来。
 *
 * 参考：
 * - http://www.oodesign.com/interface-segregation-principle.html
 *
 * @author: lingguo
 * @time: 2014/8/12 21:21
 */
public class InterfaceSegregation {

    @Test
    public void demo() {
        Worker2 worker2 = new SuperWorker2();
        Manager manager = new Manager();
        manager.setWorker2(worker2);
        manager.manage();

        worker2 = new Robot();
        manager.setWorker2(worker2);
        manager.manage();
    }
}

/**
 * 最开始只有GeneralWorker和SuperWorker，在Worker2接口中定义work()和eat()是合理的；
 * 如果需求发生变化，来了Robot类，如果它也继承Worker2接口，eat()方法是不必要的，因此
 * Worker2就成了污染接口，需要隔离。
 */
interface Worker2 {
    public void work();
}

interface Feedable2 {
    public void eat();
}

class GeneralWorker2 implements Worker2, Feedable2 {

    @Override
    public void eat() {
        System.out.println("general-worker is eating...");
    }

    @Override
    public void work() {
        System.out.println("general-worker is working...");
    }
}

class SuperWorker2 implements Worker2, Feedable2 {

    @Override
    public void eat() {
        System.out.println("super-worker is eating...");
    }

    @Override
    public void work() {
        System.out.println("super-worker is working...");
    }

}

class Robot implements Worker2 {

    @Override
    public void work() {
        System.out.println("robot is working...");
    }
}

class Manager {
    Worker2 worker2;

    public void setWorker2(Worker2 worker2) {
        this.worker2 = worker2;
    }

    public void manage() {
        worker2.work();
    }
}
