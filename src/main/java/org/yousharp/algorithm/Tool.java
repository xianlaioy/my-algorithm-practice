package org.yousharp.algorithm;

/**
 * User: lingguo
 * Date: 14-7-25 下午11:01
 */
public class Tool {

    /**
     * 交换数组中两个元素的值
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
     * 打印数组
     *
     * @param data
     */
    public static void show(int[] data) {
        for (int element: data) {
            System.out.print(element + " ");
        }
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
