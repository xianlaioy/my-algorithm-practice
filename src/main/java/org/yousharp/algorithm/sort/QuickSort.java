package org.yousharp.algorithm.sort;

import org.yousharp.algorithm.Tool;

/**
 * 快速排序：
 *  思路：先将序列根据哨兵分成两部分，左部分的元素都小于哨兵，右部分的元素都大于哨兵；
 *  然后，分别对左半部分和后半部分递归排序即可。
 *  复杂度：时间O(n^2)
 *
 * 参考：
 *  http://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 *  http://algs4.cs.princeton.edu/23quicksort/
 *
 * User: lingguo
 * Date: 14-7-25 下午10:59
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param data
     * @param lo
     * @param hi
     */
    public static void sort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int k = partition(data, lo, hi);
        sort(data, lo, k - 1);
        sort(data, k + 1, hi);
    }

    /**
     * 分区，根据哨兵将数组元素分为两部分，一部分的元素都小于哨兵，另一部分的元素都大于哨兵；
     * 返回哨兵的索引；
     *
     * @param data      数组
     * @param lo        首元素索引
     * @param hi        尾元素索引
     * @return          哨兵的索引
     */
    public static int partition(int[] data, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        // 数组首元素作为哨兵
        int sentinel = data[lo];
        while (i < j) {
            // 寻找第一个大于哨兵的元素
            while (data[++i] < sentinel);

            // 寻找第一个小于哨兵的元素
            while (data[--j] > sentinel);

            // 如果交叉，直接退出，切记
            if (i >= j) {
                break;
            }
            Tool.exch(data, i, j);
        }
        // 将哨兵放到合适的位置
        Tool.exch(data, lo, j);
        return j;
    }


}
