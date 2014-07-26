package org.yousharp.algorithm.sort;

import org.yousharp.algorithm.Tool;

/**
 * 希尔排序：
 *  思路：以一种不同的方式将元素分组，对组内的元素采用某种排序方法进行排序，不断减小分组间隔，
 *  直到最后每个分组只有一个元素，再进行排序，排序结束。
 *  比如数组为：[10, 8, 12, 9, 25, 28, 17, 50, 40, 100]，len=10, 则gap=4，即每隔4个元素为一组，
 *  则a[0], a[4], a[8]为一组，a[1], a[5], a[9]为一组，a[2], a[6]为一组，a[3], a[7]为一组，组内
 *  采用插入排序；然后gap减小为1，则此时每个元素自成一组，插入排序后排序结束。
 *  复杂度：时间O(n^2)，空间O(1)；
 *
 *  参考：http://algs4.cs.princeton.edu/21elementary/Shell.java.html
 *
 * User: lingguo
 * Date: 14-7-26 上午10:14
 */
public class ShellSort {

    public static void sort(int[] data) {
        int len = data.length;
        // 用于将元素分组的间隔，找到小于数组长度的最大gap
        int gap = 1;
        while (gap < len / 3) {
            gap = 3 * gap + 1;
        }

        while (gap >= 1) {
            // 对分组内的数据进行排序
            for (int i = gap; i < len; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (data[j] < data[j-gap]) {
                        Tool.exch(data, j, j-gap);
                    }
                }
            }
            // 减小间隔
            gap /= 3;
        }

        Tool.show(data);
    }
}
