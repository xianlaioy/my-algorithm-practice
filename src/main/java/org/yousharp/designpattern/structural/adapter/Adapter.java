package org.yousharp.designpattern.structural.adapter;

/**
 * 适配器模式：将一个类的接口转换为客户所希望的另一个类的接口，使原本由于接口不兼容而不能
 *  一起工作的两个类可以一起工作；
 *
 * 适用场景：
 *  - 在软件开发中，系统的数据和行为都正确，但是接口不同时，可以考虑使用适配器模式；
 *  - 一般用于复用一些现存的类，但是接口又与复用环境不一致的情况；
 *  - 一般在软件开发后期或维护期考虑使用，即在原有类与现有接口都不容易修改的时候；
 *  - 在开发过程中，考虑使用一些第三方组件，即使在开发初期，也没有必要为了迎合第三方实现而
 *  修改自己的接口，此时可以使用适配器模式；
 *
 * 注意：
 *  - 在软件开发的早期，公司内部应该尽量统一类和方法的命名，如果此时接口就不相同，不应该考虑
 *  使用适配器模式，而是考虑通过重构统一接口；
 *  - 实现预防接口不同的问题，不匹配问题就不会发生了，在有小的接口不统一时，及时重构，问题
 *  不至于扩大；只有碰到无法改变原有设计和代码的情况时，才考虑重构；事后控制不如事中控制，
 *  事中控制不如事前控制；
 *
 * 适配器模式组件划分：
 *  - 客户期望的目标接口Target；
 *  - 现有的接口Adaptee；
 *  - 适配器类Adapter，实现目标接口Target，内部引用现有接口Adaptee的功能；
 *
 *
 * @author: lingguo
 * @time: 2014/8/25 22:37
 */
public class Adapter {
}

class Coach {
    public String attack() {
        String attack = "attack";
        System.out.println(attack);
        return attack;
    }

    public String defense() {
        String defense = "defense";
        System.out.println(defense);
        return defense;
    }
}

class Translator implements ChnPlayer {
    Coach coach;

    public Translator(Coach coach) {
        this.coach = coach;
    }


    @Override
    public void chnAttack() {
        String attack = coach.attack();
        // translate attack to chn-attack
        System.out.println("chn-" + attack);
    }

    @Override
    public void chnDefense() {
        String defence = coach.defense();
        // translate defense to chn-defense
        System.out.println("chn-" + defence);
    }
}

interface ChnPlayer {
    public void chnAttack();
    public void chnDefense();
}

class AdapterClient {
    public static void main(String[] args) {
        ChnPlayer chnPlayer = new Translator(new Coach());
        chnPlayer.chnAttack();
        chnPlayer.chnDefense();
    }
}