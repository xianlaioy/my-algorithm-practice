package org.yousharp.algorithm.sort;

import org.yousharp.algorithm.Tool;

/**
 * 归并排序：
 *  思路：归并排序与快速排序刚好相反，快速排序是将整体分为有序的两部分，继续分割直到最小单元，
 *  此时整个序列排序完毕；而归并排序是先将整体分为无序两个部分，继续分割直到有序的最小单元，将有
 *  序的最小单元两两有序归并，所有归并动作完成后，整个序列排序完毕。
 *  复杂度：时间O(nlogn)，空间O(n)；
 *
 * 参考：
 *  http://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 *  http://algs4.cs.princeton.edu/22mergesort/
 *
 * User: lingguo
 * Date: 14-7-26 上午12:00
 */
public class MergeSort {

    /**
     * 归并排序，需要一个辅助数组用于归并过程
     *
     * @param data
     */
    public static void sort(int[] data) {
        int[] aux = new int[data.length];
        sort(data, aux, 0, data.length - 1);
        Tool.show(data);
    }

    /**
     * 排序过程，先递归分隔直到最小单元(只有一个元素)，然后归并
     *
     * @param data      数组
     * @param aux       辅助数组
     * @param lo        首元素索引
     * @param hi        尾元素索引
     */
    private static void sort(int[] data, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 取中点
        int mid = lo + ((hi - lo) >> 1);
        sort(data, aux, lo, mid);
        sort(data, aux, mid + 1, hi);
        merge(data, aux, lo, mid, hi);
    }

    /**
     * 归并过程：需要注意的是，将两个有序序列归并的时候，注意边界条件。
     *
     * @param data
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] data, int[] aux, int lo, int mid, int hi) {
        // 将需要归并的元素保存到辅助数组
        for (int i = lo; i <= hi; i++) {
            aux[i] = data[i];
        }

        int i = lo;
        int j = mid + 1;
        // 对辅助数组中的元素依次处理后，将有序序列保存到原数组
        for (int k = lo; k <= hi; k++) {
            // 前两个条件用于判断边界，如果j > hi，表示mid+1到hi部分的序列
            // 已经遍历完毕，只需将lo到mid中剩余的元素保存到data即可；
            if ( i > mid) {
                data[k] = aux[j++];         // 不是必须的
            } else if (j > hi) {
                data[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                data[k] = aux[i++];
            } else {
                data[k] = aux[j++];
            }
        }
    }
}
