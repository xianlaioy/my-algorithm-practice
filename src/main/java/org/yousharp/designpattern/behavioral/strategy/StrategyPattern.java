package org.yousharp.designpattern.behavioral.strategy;

/**
 * 策略模式：定义了算法家族，分别封装起来，让它们之间可以相互替换，此模式
 *  让算法和使用算法的客户独立地变化；
 *
 * 重点：
 *  - 算法本身只是一种策略，重要的是这些算法是随时都可能互相替换的，这就是变
 *  化点，而封装变化是面向对象的思维方式；
 *  - Strategy就是抽象的算法，具体的策略就是算法的具体实现；
 *  - Context有一个抽象策略的引用，根据传入的具体策略，执行对应的操作；
 *  - 基本的策略模式，判断逻辑在客户端，可以在Context中使用简单工厂，将判断逻辑由
 *  客户端移到Context中，这样大大减轻了客户端的职责，因为客户端只需要知道Context即可；
 *  - 策略模式与简单工厂结合后与简单工厂模式的区别：二者的判断逻辑都在模式类中，而不在
 *  客户端，简单工厂是用于创建产品对象的，因此客户使用创建的对象执行对应的业务逻辑；而
 *  策略模式不仅封装了对象的构造，同时还调用了对象的业务逻辑；
 *
 * 应用场景：
 *  - 策略模式是用来封装算法的，但在实践中发现可以用它来封装几乎任何类型的规则，只要
 *  在分析过程中听到需要在不同时间应用不同的业务规则，就可以考虑使用策略模式；
 *
 * 参考：
 *  - http://sourcemaking.com/design_patterns/strategy/java/1
 *
 * @author: lingguo
 * @time: 2014/9/7 16:44
 */
public class StrategyPattern {

}

/**
 * 策略接口
 */
interface MyStrategy {
    public void solve();
}

/**
 * 策略的实现一，模板方法
 */
abstract class TemplateMethod1 implements MyStrategy {
    public void solve() {
        start();
        while (nextTry() && !isSolution()) {
            // loop forever
        }
        stop();
    }
    protected abstract void start();
    protected abstract boolean nextTry();
    protected abstract boolean isSolution();
    protected abstract void stop();
}

/**
 * 策略一的具体实现
 */
class StrategyImpl1 extends TemplateMethod1 {
    private int state = 1;
    protected void start() {
        System.out.println("start...");
    }
    protected boolean nextTry() {
        System.out.println("nextTry-" + state++ + "...");
        return true;
    }
    protected boolean isSolution() {
        System.out.println("isSolution-" + (state == 3) + "...");
        return (state == 3);
    }
    protected void  stop() {
        System.out.println("stop...");
    }
}

/**
 * 策略的实现二，模板方法
 */
abstract class TemplateMethod2 implements MyStrategy {
    public void solve() {
        preProcess();
        while (true) {
            if (search()) {
                break;
            }
        }
        postProcess();
    }
    protected abstract void preProcess();
    protected abstract boolean search();
    protected abstract void postProcess();
}

/**
 * 策略二的具体实现
 */
class StrategyImpl2 extends TemplateMethod2 {
    private int state = 1;

    @Override
    protected void preProcess() {
        System.out.println("preProcess...");
    }

    @Override
    protected boolean search() {
        System.out.println("search-" + state++ + "...");
        return (state ==3);
    }

    @Override
    protected void postProcess() {
        System.out.println("postProcess...");
    }
}

/**
 * Context类，其中有Strategy接口的引用，调用Strategy的处理逻辑；
 */
class StrategyContext {
    private MyStrategy myStrategy;

    public StrategyContext(MyStrategy myStrategy) {
        this.myStrategy = myStrategy;
    }

    public void contextInterface() {
        myStrategy.solve();
    }
}

/**
 * Strategy的客户
 */
class StrategyClient {
    public static void main(String[] args) {
        MyStrategy[] strategies = {new StrategyImpl1(), new StrategyImpl2()};
        StrategyContext context = null;

        for (int i = 0; i < strategies.length; i++) {
            context = new StrategyContext(strategies[i]);
            context.contextInterface();
        }
    }
}

/**
 * 策略模式与简单工厂相结合，使得判断逻辑由客户端移到策略的Context
 * 中，减轻了客户端的压力，因为客户只需要知道Context即可；
 */
class ContextWithSF {
    private MyStrategy myStrategy;

    public ContextWithSF(int id) {
        switch (id) {
            case 1:
                myStrategy = new StrategyImpl1();
                break;
            case 2:
                myStrategy = new StrategyImpl2();
                break;
        }
    }

    public void ContextInterface() {
        myStrategy.solve();
    }
}

/**
 * 客户端只需要知道Context即可，算法家族对客户是透明的；
 */
class ClientWithSF {
    public static void main(String[] args) {
        ContextWithSF contextWithSF = null;
        int[] id = {1, 2};

        for (int i: id) {
            contextWithSF = new ContextWithSF(i);
            contextWithSF.ContextInterface();
        }
    }
}