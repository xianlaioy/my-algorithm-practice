package org.yousharp.designpattern.principles;

import org.junit.Test;

/**
 * 开闭原则(OCP)：软件实体(如模块、类及函数)，应该对扩展开放，对修改封闭；
 * 面对新的需求，应该进行扩展，对现有代码的修改应该尽可能少，因为现有的代码已经经过
 * 单元测试且运行稳定，如果修改，则需要重新进行单元测试，并且可能引入意想不到的bug。
 *
 * 设计和应对变化：
 *  - 无论如何设计，都无法做到完全封闭，设计者对于模块应该对哪些变化封闭做出
 *  选择，猜测最可能发生变化的种类，然后构造抽象隔离这些变化；
 *  - 在最初设计时，假设变化不会发生，当变化发生时，构造抽象以隔离以后可能发生的同类
 *  变化；
 *  - 仅仅对程序中频繁变化的部分构造抽象，拒绝不成熟的抽象；
 *
 * 参考；
 *  - http://www.oodesign.com/open-close-principle.html
 *
 * @author: lingguo
 * @time: 2014/8/11 20:17
 */
public class OpenClosedPrinciple {

    @Test
    public void demo() {
        GraphEditor editor = new GraphEditor();
        Shape shape = new Triangle();
        editor.drawShape(shape);
    }

    /**
     * 对外提供的类，无论是增加/删除Shape，不会影响GrapeEditor
     */
    class GraphEditor {

        public void drawShape(Shape shape) {
            shape.draw();
        }
    }

    /**
     * 抽象父类，增加新的Shape，只需继承父类，重写draw()即可
     */
    abstract class Shape {
        public abstract void draw();
    }

    /**
     * 具体的实现类
     */
    class Triangle extends Shape {

        @Override
        public void draw() {
            System.out.println("draw a triangle...");
        }
    }

    /**
     * 具体的实现类
     */
    class Rectangle extends Shape {

        @Override
        public void draw() {
            System.out.println("draw a rectangle...");
        }
    }

}



