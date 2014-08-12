package org.yousharp.designpattern.principles;

import org.junit.Test;

/**
 * 依赖倒转原则(DIP)：高层模块不应该依赖低层模块，它们都应该依赖抽象；抽象不应该依赖细节，细节应该依赖抽象；
 * 即针对接口编程，不要针对实现编程。
 *
 * 如果高层模块直接依赖于低层模块，则当低层模块发生变化时，高层模块也会发生变化，这些变化一方面可能会对已有
 * 的功能造成影响，另一方面，高层模块需要重新进行单元测试。
 * 如果高层模块和低层模块都依赖于抽象(即接口或抽象类)，则只要接口是稳定的，任何一个的修改都是独立的，这使得
 * 高层模块和低层模块都很容易复用。
 *
 * 里氏代换原则(LSP)：一个实体如果使用的是一个父类，那么一定适用于其子类，而且察觉不出父类与子类之间的差别。
 * 即在软件中，把父类都替换成它的子类，程序的行为没有变化；简单地说，子类必须可以完全替换掉它们的父类。
 * 只有当子类可以替换掉父类，软件单位的功能不受影响，父类才能真正地被复用，子类才能增加自己的行为。
 *
 *
 * @author: lingguo
 * @time: 2014/8/11 20:58
 */
public class DependencyInversion {

    @Test
    public void demo() {
        Corporation corporation = new Corporation();
        Worker worker = new GeneralWorker();
        corporation.setWorker(worker);
        corporation.operate();

        worker = new SuperWorker();
        corporation.setWorker(worker);
        corporation.operate();
    }
}

/**
 * 并不依赖于具体的worker，而是依赖于接口Worker；当低层的具体Worker变化时，
 * 不会影响到高层模块，只需要修改实例化部分即可。
 */
class Corporation {
    Worker worker;

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void operate() {
        worker.work();
    }
}

/**
 * 抽象接口
 */
interface Worker {
    public void work();
}

/**
 * 低层实现类
 */
class GeneralWorker implements Worker {
    @Override
    public void work() {
        System.out.println("[general-work] is working...");
    }
}

/**
 * 另一个低层实现类
 */
class SuperWorker implements Worker {

    @Override
    public void work() {
        System.out.println("[super-worker] is working...");
    }
}
