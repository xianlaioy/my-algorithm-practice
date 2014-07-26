package org.yousharp.algorithm.sort;

import org.yousharp.algorithm.Tool;

/**
 * 冒泡排序：(升序)
 *  思路：可以将大元素沉到最后，也可以将小元素浮到最前面；一趟遍历，两两比较交换，则最大的元素
 *  沉到最后，重复直到n趟遍历结束，排序完毕。
 *
 *  **注意**：如果某一趟遍历中，没有发生元素交换，则
 *  表示已排好序，提前结束。
 *
 * **优化**：第k趟遍历，表明前k-1个元素都已被放到合适的位置，此时遍历前n-k个元素；该过程还可以优化，
 * 在遍历过程中，将最后一次交换的位置记录下来，该位置即为下一次遍历的边界，因为该位置之后没有发生
 * 交换，表明其后的元素都已有序，该优化可以减少比较的次数。
 *
 * User: lingguo
 * Date: 14-7-26 下午2:38
 */
public class BubbleSort {

    /**
     * 普通冒泡排序，第k趟遍历，比较n-k个元素并交换，将最大元素放到合适的位置；
     * 并做标记，如果某一趟排序没有发生交换，则排序提前结束；
     *
     * @param data
     */
    public static void sort(int[] data) {
        int n = data.length - 1;
        boolean swapped = true;
        // i表示本趟遍历结束，data[i]为当前最大值
        for (int i = n; i > 0 && swapped; i--) {
            swapped = false;
            // 两两比较，最小值“沉”到最后
            for (int j = 1; j <= i; j++) {
                if (data[j-1] > data[j]) {
                    Tool.exch(data, j-1, j);
                    swapped = true;
                }
            }
        }
        Tool.show(data);
    }

    /**
     * 优化：在每一趟排序中，记录最后发生交换的位置，该位置作为下一次排序的终点；
     *
     * @param data
     */
    public static void sortX(int[] data) {
        int n = data.length - 1;
        while (n != 0) {
            int lastSwap = 0;
            for (int i = 1; i <= n; i++) {
                if (data[i-1] > data[i]) {
                    Tool.exch(data, i-1, i);
                    lastSwap = i;              // 记录最后发生交换的位置
                }
            }
            n = lastSwap;
        }
        Tool.show(data);
    }
}
