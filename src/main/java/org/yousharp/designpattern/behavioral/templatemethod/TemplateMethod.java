package org.yousharp.designpattern.behavioral.templatemethod;

/**
 * 模板方法：定义一个算法框架，将一些实现步骤延迟到子类中；模板方法使得子类可以不改变
 *  一个算法的结构即可重定义该算法的某些特定步骤；
 *
 * 要点：
 *  - 将子类的不变行为/公共行为移到超类，子类仅重写不同的行为；
 *
 * 适用场景：
 *  - 要完成在某一个细节层次上一致的一个过程或一系列步骤，但在更详细的层次上的实现可能不同
 *  时，可以考虑使用模板方法；
 *
 * 具体实现：
 *  - 超类的抽象方法为子类要重写的部分；
 *  - 超类的模板方法(非抽象方法)定义算法/过程的骨架/步骤；
 *
 *
 * @author: lingguo
 * @time: 2014/8/27 22:29
 */
public class TemplateMethod {
}

/**
 * 抽象超类：定义子类重写的抽象方法以及模板方法；
 */
abstract class PlayGame {
    public abstract void initialize();
    public abstract void startPlay();
    public abstract void endPlay();

    public void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

/**
 * 实现类一
 */
class PlayBasketball extends PlayGame {

    @Override
    public void initialize() {
        System.out.println("basketball: initialized.");
    }

    @Override
    public void startPlay() {
        System.out.println("basketball: start playing.");
    }

    @Override
    public void endPlay() {
        System.out.println("basketball: end playing.");
    }
}

/**
 * 实现类二
 */
class PlayFootball extends PlayGame {

    @Override
    public void initialize() {
        System.out.println("football: initialized.");
    }

    @Override
    public void startPlay() {
        System.out.println("football: start playing.");
    }

    @Override
    public void endPlay() {
        System.out.println("football: end playing.");
    }
}

/**
 * 客户端
 */
class SportFan {
    public static void main(String[] args) {
        PlayGame playGame = new PlayFootball();
        playGame.play();

        playGame = new PlayBasketball();
        playGame.play();
    }
}