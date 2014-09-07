package org.yousharp.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：定义了一种一对多的依赖关系，让多个观察者对象同时监听一个主题对象，
 *  当主题对象的状态发生变化时，通知所有的观察者对象更新；
 *
 * 要点：
 *  - 观察者对象有很多，如果它们之间联系紧密，则可以将公共的部分提取到抽象类，如果
 *  它们关系不大，则可以提取到接口，保留一个公共的update()方法即可；
 *  - 观察者和主题之间不要相互依赖，应该依赖于抽象，即依赖于它们各自的接口；
 *  - 主题并不知道自己有多个少个观察者，观察者之间也是独立的；
 *
 * 适用场景：
 *  - 当一个对象的改变需要同时改变其它一些对象，而且它并不知道要改变多少个对象时，可以
 *  考虑使用观察者模式；
 *
 * @author: lingguo
 * @time: 2014/8/28 20:34
 */

/**
 * 观察者接口
 */
public interface Observer {
    public void update(Subject subject);
}

/**
 * 主题接口，包括：增加/删除观察者，通知所有观察者；
 */
interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyAllObservers();
}

/**
 * 具体的主题：定义了与观察者之间的一对多的关系；
 * jobs是主题自己的业务逻辑。
 */
class HeadHunter implements Subject {
    private List<Observer> jobSeekers;
    private List<String> jobs;

    public HeadHunter() {
        this.jobSeekers = new ArrayList<>();
        this.jobs = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        jobSeekers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        jobSeekers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o: jobSeekers) {
            o.update(this);
        }
    }

    public void addJob(String jobName) {
        jobs.add(jobName);
    }

    public void removeJob(String jobName) {
        jobs.remove(jobName);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (String s: jobs) {
            buffer.append(s).append("\n");
        }
        return buffer.toString();
    }
}

/**
 * 具体的观察者一：主要是update()，更新自己的状态；
 */
class GuanYu implements Observer {
    private String name;
    private Subject subject;

    public GuanYu(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update(Subject subject) {
        System.out.println(name + " got notified.");
        System.out.println(subject);
    }
}

/**
 * 具体的观察者二
 */
class ZhangFei implements Observer {
    private String name;
    private Subject subject;

    public ZhangFei(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update(Subject subject) {
        System.out.println(name + " got notified.");
        System.out.println(subject);
    }
}

/**
 * 客户端使用
 */
class ObserverClient {
    public static void main(String[] args) {
        HeadHunter subject = new HeadHunter();
        Observer guanyu = new GuanYu("guanyu", subject);
        Observer zhangfei = new ZhangFei("zhangfei", subject);
        subject.registerObserver(guanyu);
        subject.registerObserver(zhangfei);

        subject.addJob("alibaba");
        subject.notifyAllObservers();

        subject.addJob("tencent");
        subject.addJob("baidu");
        subject.notifyAllObservers();

        subject.addJob("360");
        subject.notifyAllObservers();

        subject.removeJob("360");
        subject.notifyAllObservers();


    }
}