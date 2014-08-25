package org.yousharp.designpattern.structural.proxy;

/**
 * @author: lingguo
 * @time: 2014/8/21 21:42
 */
public class Proxy {
}

interface Image {
    public void display(String fileName);
    public void load(String fileName);
}

class RealImage implements Image {

    @Override
    public void display(String fileName) {

    }

    @Override
    public void load(String fileName) {

    }
}