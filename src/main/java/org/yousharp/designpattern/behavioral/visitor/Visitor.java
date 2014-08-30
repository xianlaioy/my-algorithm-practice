package org.yousharp.designpattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式：定义了作用于一个对象结构中各元素上的操作；使你在不改变对象结构
 *  元素的类的前提下，定义新的操作；
 *
 * 要点：
 *  - 对象结构的元素分类是稳定的，而作用于这些元素上的操作是不稳定的；即对数据结构
 *  封闭，对操作是开放的；
 *  - 访问者模式将数据结构和结构上的操作解耦，使得操作集合可以自由地演化；
 *  - 增加新的操作很容易，只需要在访问者中增加一个方法即可，即访问者模式将有关的行为
 *  集中到了一个访问者对象中；
 *
 * 适用场景：
 *  - 适用于数据结构相对稳定的系统；
 *  - 如果数据结构不稳定，增加一种数据结构，则需要所有的访问者及其子类，即违背了OCP原则；
 *  - 由于我们很难找到数据结构不变化的情况，因此：大多数时候你并不需要访问者模式，但一旦
 *  你需要访问者模式，那就是你真的需要它了；
 *
 * 参考：《大话设计模式》
 *
 * @author: lingguo
 * @time: 2014/8/30 9:38
 */
public class Visitor {
}

/**
 * visitor接口：其中的行为定义了对数据结构元素的访问；
 */
abstract class StatusVisitor {
    public abstract void visitMan(Man man);
    public abstract void visitWoman(Woman woman);
}

/**
 * 具体visitor：
 */
class SuccessStatusVisitor extends StatusVisitor {

    @Override
    public void visitMan(Man man) {
        System.out.println("man in success.");
    }

    @Override
    public void visitWoman(Woman woman) {
        System.out.println("woman in success.");
    }
}

/**
 * 具体visitor
 */
class FailureStatusVisitor extends StatusVisitor {

    @Override
    public void visitMan(Man man) {
        System.out.println("man in failure.");
    }

    @Override
    public void visitWoman(Woman woman) {
        System.out.println("woman in failure.");
    }
}

/**
 * 对象结构接口：其下的元素是比较稳定的，因为只有man和woman之分；
 */
abstract class Human {
    public abstract void accept(StatusVisitor statusVisitor);
}

/**
 * 对象结构的元素一
 */
class Man extends Human {
    public void accept(StatusVisitor statusVisitor) {
        statusVisitor.visitMan(this);
    }
}

/**
 * 对象结构的元素二
 */
class Woman extends Human {
    public void accept(StatusVisitor statusVisitor) {
        statusVisitor.visitWoman(this);
    }
}

class Operator {
    private List<Human> humanList;
    public Operator() {
        this.humanList = new ArrayList<>();
    }

    public void attach(Human human) {
        humanList.add(human);
    }

    public void detach(Human human) {
        humanList.remove(human);
    }

    public void display(StatusVisitor statusVisitor) {
        for (Human human: humanList) {
            human.accept(statusVisitor);
        }
    }
}

class VisitorClient {
    public static void main(String[] args) {
        Operator os = new Operator();
        os.attach(new Man());
        os.attach(new Woman());
        os.display(new SuccessStatusVisitor());
        os.display(new FailureStatusVisitor());
    }
}