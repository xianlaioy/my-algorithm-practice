package org.yousharp.designpattern.prototype;

/**
 * 原型模式：用原型的实例指定要创建的对象的种类，然后通过拷贝这些原型来创建新的实例；即从一个
 *  已有的对象创建新的可定制的对象，而不需知道任何创建的细节；
 *
 *  应用场景：如果需要频繁创建对象，使用new的开销是很大的，使用原型模式，通过clone创建新的对象，
 *  可以减小对象创建的开销。
 *
 * 一个产品，在其中定义一个clone()方法，该方法可以拷贝当前对象(即拷贝所有属性)并返回一个新的对象，
 *  这个新的对象可以修改自己的属性和状态，形成一个新的定制对象；
 *
 * - 浅复制：按字段进行拷贝(field-by-field)，如果属性是基本类型，直接拷贝一个副本，如果成员是引用类型
 * (引用另一个对象)，则仅复制引用，不复制引用的对象，即新实例和旧实例中的引用都指向同一个对象；
 * - 深复制：所有的内容都复制，如果成员是基本类型，则直接拷贝，如果是引用类型，则复制引用和引用的对象，
 * 即新实例和旧实例中的引用指向的是两个不同的对象；
 *
 * Java有一个Cloneable接口，实现该接口的类则意味着可以通过Object中的clone()方法创建一个该类的对象；
 *  显然，该clone()方法是浅复制；那么如何实现深复制呢？如果引用的对象也实现了Cloneable接口，则在原型类
 *  的clone()方法中通过clone()浅复制创建了一个对象后，调用引用的对象的clone()方法(见示例)；如果引用的
 *  对象没有实现Cloneable接口，则直接创建它的一个新对象，作为原型类的成员；
 *
 * @author: lingguo
 * @time: 2014/8/16 22:09
 */
public class Prototype {
}

/**
 * 原型类引用的外部类，实现Cloneable接口
 */
class Company implements Cloneable {
    String name;

    public Company(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 重写clone方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Company clone() throws CloneNotSupportedException {
        return (Company) super.clone();
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}

/**
 * 原型类，实现Cloneable接口
 */
class Resume implements Cloneable {
    String name;
    Company company;

    public Resume(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }

    /**
     * 这里是关键，首先调用Object的clone()方法浅复制一个对象，然后调用
     * 引用类的clone()方法创建一个新的引用对象，并将新的引用对象覆盖旧的
     * 引用对象；
     * 如果引用的外部类没有实现Cloneable接口，则直接通过new创建一个对象，并
     * 将该对象覆盖旧的引用对象；
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Resume clone() throws CloneNotSupportedException {
        Resume clonedResume = (Resume) super.clone();
        clonedResume.setCompany(clonedResume.getCompany().clone());
        return clonedResume;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", company: " + company;
    }
}

/**
 * 客户端，通过已有实例的clone()方法创建新的实例，新的实例可以修改自己的属性，形成
 * 定制化的新实例；
 */
class CopyResume {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume1 = new Resume("lingguo", new Company("sohu"));

        Resume resume2 = resume1.clone();
        resume2.setName("guoling");
        resume2.getCompany().setName("zhifubao");

        Resume resume3 = resume1.clone();
        resume3.setName("daniel");
        resume3.getCompany().setName("google");

        System.out.println(resume1);
        System.out.println(resume2);
        System.out.println(resume3);
    }
}