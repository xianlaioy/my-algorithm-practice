package org.yousharp.designpattern.creational.builder;

/**
 * 建造者模式：将复杂对象的创建与它的表示相分离，同样的创建过程可以创建不同的表示；
 *
 *  一个产品，它的创建由多个步骤完成，比如可以分为5个子过程，这5个过程是稳定的，但组合可以不同，
 *  不同的组合可以构建不同的产品；于是可将这5个稳定的构建过程抽象成builder接口，不同的组合(即表
 *  示)作为builder接口的具体实现；在director的控制下，使用builder一步一步地构建产品，由客户端告
 *  诉director应该使用什么类型的builder构建什么类型的产品；
 *
 *  - builder：创建一个产品的各个部件的抽象接口(创建每一个子过程的方法集合)；
 *  - builder具体实现：实现builder接口，构建一个具体产品的各个部件；
 *  - directory：使用builder一步步构建具体表示的产品；
 *  - product：产品
 *
 * 备注：
 *  - 同类的输入，产生不同的输出(表示形式)，使用builder模式的关键；
 *  - 创造型模式通常是互补的，抽象工厂、建造者以及原型模式可以使用单例
 *  来创建实例；
 *  - builder模式的重点是逐步地构建一个复杂的过程，而抽象工厂的关注点
 *  是构建一系列的对象，这一系列的对象很容易从一种实现切换到另一种实现；
 *  builder模式时逐步构建对象，最后返回，而抽象工厂是直接返回创建的对象。
 *  - 一般情况下，设计时先使用工厂方法模式，然后逐步改造、优化，最终使用
 *  抽象工厂、原型或者builder模式；
 *
 * 参考：
 *  - http://sourcemaking.com/design_patterns/builder
 *
 * @author: lingguo
 * @time: 2014/8/16 9:21
 */
public class Builder {
}

/**
 * 最终的产品，由若干个稳定的子过程组成；
 */
class ChildMeal {
    String hamburger = "";
    String fries = "";
    String coke = "";

    public void setHamburger(String hamburger) {
        this.hamburger = hamburger;
    }

    public void setFries(String fries) {
        this.fries = fries;
    }

    public void setCoke(String coke) {
        this.coke = coke;
    }

    @Override
    public String toString() {
        return "meal: hamburger: " + hamburger +
                ", fries: " + fries +
                ", coke: " + coke;

    }
}

/**
 * builder接口，定义了创建产品各个组件的方法；
 */
abstract class MealBuilder {
    ChildMeal childMeal;
    public void createMeal() {
        this.childMeal = new ChildMeal();
    }

    public abstract void createHamburger();
    public abstract void createFries();
    public abstract void createCoke();
    public abstract ChildMeal getMeal();
}

/**
 * 具体builder：实现builder定义的子过程，构建产品的一种具体表示
 * 的各个组件；
 */
class HawaiiMealBuilder extends MealBuilder {
    @Override
    public void createHamburger() {
        childMeal.setHamburger("Hawaii Hamburger");
    }

    @Override
    public void createFries() {
        childMeal.setFries("Hawaii Meal");
    }

    @Override
    public void createCoke() {
        childMeal.setCoke("CocoCola");
    }

    @Override
    public ChildMeal getMeal() {
        return childMeal;
    }
}

/**
 * 另一种具体builder，构建产品的另一个具体表示；
 */
class CaliforniaMeal extends MealBuilder {
    @Override
    public void createHamburger() {
        childMeal.setHamburger("California Hamburger");
    }

    @Override
    public void createFries() {
        childMeal.setFries("California Fries");
    }

    @Override
    public void createCoke() {
        childMeal.setCoke("Pepsi Coca");
    }

    @Override
    public ChildMeal getMeal() {
        return childMeal;
    }
}

/**
 * director，使用builder，一步步构建具体的产品；
 */
class Waiter {
    MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public ChildMeal serveMeal() {
        mealBuilder.createMeal();
        mealBuilder.createHamburger();
        mealBuilder.createFries();
        mealBuilder.createCoke();
        return mealBuilder.getMeal();
    }
}

/**
 * client：指定所需要的产品的最终类型，通知builder去创建这么一个具体的产品
 */
class Child {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        MealBuilder mealBuilder = new HawaiiMealBuilder();
        waiter.setMealBuilder(mealBuilder);
        ChildMeal meal = waiter.serveMeal();
        System.out.println("child one: " + meal);

        mealBuilder = new CaliforniaMeal();
        waiter.setMealBuilder(mealBuilder);
        meal = waiter.serveMeal();
        System.out.println("child two: " + meal);

    }
}
