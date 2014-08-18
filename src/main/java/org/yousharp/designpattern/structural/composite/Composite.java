package org.yousharp.designpattern.structural.composite;

import java.util.ArrayList;

/**
 * 组合模式：将对象组合成树形结构以表示“部分-整体”的关系；组合模式使得用户
 *  对于单个对象和组合对象的使用具有一致性；
 *
 * 应用场景：
 *  - 如果需求中体现的是部分与整体的递归层级关系，且希望用户可以忽略单个对象与
 *  组合对象的不同，统一地使用时；
 *
 * 解决的问题：一般来说，单个对象和组合对象的行为不同，用户的处理方式不同，因此
 *  在使用时需要先判断对象的类型，然后再使用；使用组合模式，单个单向与组合对象
 *  具有一致的接口，对用户来说是透明的；
 *
 * 案例：
 *  -
 *
 * @author: lingguo
 * @time: 2014/8/18 21:43
 */
public class Composite {
}

interface AbstractFile {

    public void add(AbstractFile file);
    public void remove(AbstractFile file);
    public void list();
}

class MyFile implements AbstractFile {
    private String name;

    public MyFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("file does not support add.");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("file does not support remove.");
    }

    @Override
    public void list() {
        System.out.println("I'm a file, name: " + this.name);
    }

}

class MyDirectory implements AbstractFile {
    private String name;
    private ArrayList<AbstractFile> container;

    public MyDirectory(String name) {
        this.name = name;
        container = new ArrayList<>();
    }

    @Override
    public void add(AbstractFile file) {
        container.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        container.remove(file);
    }

    @Override
    public void list() {
        System.out.println("I'm a directory: " + this.name);
        for (AbstractFile file: container) {
            file.list();
        }
    }
}

class FileClient {

    public static void main(String[] args) {
        MyDirectory dir1 = new MyDirectory("dir1");
        MyFile file1 = new MyFile("file1");
        MyFile file2 = new MyFile("file2");
        dir1.add(file1);
        dir1.add(file2);

        MyDirectory dir2 = new MyDirectory("dir2");
        MyFile file3 = new MyFile("file3");
        MyFile file4 = new MyFile("file4");
        dir2.add(file3);
        dir2.add(file4);

        dir1.add(dir2);

        dir1.list();
    }
}
