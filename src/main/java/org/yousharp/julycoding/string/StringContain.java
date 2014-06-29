package org.yousharp.julycoding.string;

/**
 * 问题描述：
 *  给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B
 *  中所有字母是否都在字符串A里？为了简单起见，我们规定输入的字符串只包含大写英文字母。比如String A：ABCD，String B：BAD，
 *  返回true；string A：ABCD，string B：BCE，返回false；String A：ABCD，String B：AA，返回true。
 *
 * User: lingguo
 * Date: 14-6-29
 */
public class StringContain {

    /**
     * 思路一：
     *  遍历字符串B，判断其字符是否在字符串A中。时间复杂度：O(n*m)，空间复杂度O(1)。
     *
     * @param sa
     * @param sb
     * @return
     */
    public boolean doubleCheck(String sa, String sb) {
        return false;
    }

    /**
     * 思路二：
     *  先对两个字符串进行排序，然后同时遍历两个字符串，对字符串B中的每一个字符，判断其是否在
     *  字符串A中。时间复杂度：O(nlogn)，空间复杂度O(1)。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean sortAndCheck(String s1, String s2) {
        return false;
    }

    /**
     * 思路三：
     *  将每一个字符映射到一个素数上，对字符串A中的每一个字符表示的素数，求累积；然后遍历字符串B，
     *  用每一个字符表示的素数去除字符串A的累积，判断余数是否为0。时间复杂度：O(n)，空间复杂度O(1)。
     *  可能存在的问题：乘积时可能会溢出。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean primeCheck(String s1, String s2) {
        return false;
    }

    /**
     * 思路四：
     *  将字符串A中的所有字符作为hash表的key，然后遍历字符串B，判断每一个字符是否在该hash表中。
     *  java中，可以将字符串A的所有字符放入一个集合中，判断字符串B中的字符是否属于该集合。
     *  进一步，可以使用位运算对字符串A计算一个“签名”，然后用字符串B中的字符去该“签名”
     *  中查找。更详细一些，将字符串A的每一个字符翻译为一个整数（1到27），然后将一个32位的整数的对应为置位；
     *  遍历字符串B，判断字符表示的整数位是否被置位；
     *  时间复杂度O(n)，空间复杂度O(1)。目前最好的方法。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean hashCheck(String s1, String s2) {
        return false;
    }
}
