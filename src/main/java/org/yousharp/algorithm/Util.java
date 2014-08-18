package org.yousharp.algorithm;

/**
 * 一些工具方法集合
 *
 * User: lingguo
 * Date: 14-7-25 下午11:01
 */
public class Util {

    /**
     * 交换整数数组中两个元素的值
     *
     * @param data
     * @param i
     * @param j
     */
    public static void exch(int[] data, int i, int j) {
        int swap = data[i];
        data[i] = data[j];
        data[j] = swap;
    }

    /**
     * 交换字符数组中两个元素的值
     *
     * @param data
     * @param i
     * @param j
     */
    public static void exch(char[] data, int i, int j) {
        char swap = data[i];
        data[i] = data[j];
        data[j] = swap;
    }


    /**
     * 打印整数数组
     *
     * @param data
     */
    public static void show(int[] data) {
        for (int element: data) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * 打印字符数组
     *
     * @param data
     */
    public static void show(char[] data) {
        for (char element: data) {
            System.out.println(element + " ");
        }
        System.out.println();
    }

    /**
     * 反转字符串
     *
     * @param data
     */
    public static void reverse(char[] data, int begin, int end) {
        int first = begin;
        int last = end;
        while (first < last) {
            exch(data, first, last);
            first++;
            last--;
        }
    }

    /**
     * 判断value是否为奇数
     *
     * @param value
     * @return
     */
    public static boolean isOdd(int value) {
        if ((value & 0x01) == 0) {
            return false;
        }
        return true;
    }








    /**
     * 注意：Java总是值传递，对象是引用的，但对象本身是值传递。
     * 所以本交换函数无法交换原数组中的两个元素。
     *
     * @param a
     * @param b
     */
    private static void exch2(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
