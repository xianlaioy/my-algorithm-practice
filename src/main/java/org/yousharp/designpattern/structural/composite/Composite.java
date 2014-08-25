package org.yousharp.designpattern.structural.composite;

import java.util.ArrayList;

/**
 * 组合模式：将对象组合成树形结构以表示“部分-整体”的关系；组合模式使得用户
 *  对于单个对象和组合对象的使用具有一致性；
 *
 * 安全性与透明性：
 *  - 因为单个对象和组合对象的行为是有差异的，比如组合对象中应该有方法可以增加
 *  或删除子对象，而单个对象则没有，那这些仅仅是组合对象中才有的方法是应该提升
 *  到父接口(或抽象类)中呢，还是仅保留在组合对象里呢？
 *  - 如果父接口中包含所有的抽象方法，则为透明方式，即单个对象和组合对象对外提
 *  供的接口是一直的，对用户来说是透明的；
 *  - 如果父接口中仅包含单个对象和父对象的共有抽象方法，则为安全方式，但此时对
 *  用户来说就不是透明的了，用户需要判断组件的类型。
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
 *  - 菜单中包含菜单项，而每一个菜单项又可能是子菜单；
 *  - 目录中包含文件，文件也可能是子目录；
 *  - 容器中包含元素，元素也可能是容器；
 *
 * 参考：
 *  - http://sourcemaking.com/design_patterns/composite
 *
 * @author: lingguo
 * @time: 2014/8/18 21:43
 */
public class Composite {
}

/**
 * 父类接口，透明方式
 */
interface AbstractFile {

    public void add(AbstractFile file);
    public void remove(AbstractFile file);
    public void list();
}

/**
 * 单个对象
 */
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

/**
 * 组合对象
 */
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

/**
 * 用户
 */
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
        dir1.remove(file2);

        dir1.list();
    }
}
