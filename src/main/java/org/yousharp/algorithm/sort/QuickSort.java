package org.yousharp.algorithm.sort;

/**
 * 快速排序：
 *  思路：先将序列根据哨兵分成两部分，左部分的元素都小于哨兵，右部分的元素都大于哨兵；
 *  然后，分别对左半部分和后半部分递归排序即可。
 *  复杂度：时间O(n^2)
 *
 * 参考：
 *  - http://www.algolist.net/Algorithms/Sorting/Quicksort
 *
 * User: lingguo
 * Date: 14-7-25 下午10:59
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param data
     * @param left
     * @param right
     */
    public static void sort(int[] data, int left, int right) {
        int index = partition(data, left, right);
        if (left < index - 1) {
            sort(data, left, index - 1);
        }
        if (right > index) {
            sort(data, index, right);
        }
    }

    /**
     * 分区，根据哨兵将数组元素分为两部分，左部分的元素都小于哨兵，右部分的元素都大于哨兵；
     * 返回值为边界索引值，即该索引左边的所有元素的值(不包括该索引的值)都小于哨兵的值，该索引
     * 右边的所有元素的值(包括该索引的值)都大于哨兵的值；
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] data, int left, int right) {
        int pivot = data[(left + right) / 2];
        int i = left;
        int j = right;
        int tmp;

        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}
