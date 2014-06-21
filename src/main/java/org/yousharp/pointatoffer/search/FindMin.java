package org.yousharp.pointatoffer.search;


/**
 * 1. 问题描述：
 *  一个递增序列，将其前n个元素，移到序列的最后，求新序列的最小值；比如移动前的序列1，2，3，4，5，6，移动后的序列为3，4，5，6, 1，2，3，
 *   则新序列的最小值为1；
 *
 * 2. 思路
 *  思路1：如果直接遍历数组，复杂度为O(n);
 *  思路2: 到数组的前部分和后部分分别有序，可以使用二分查找的思路：first指向第一个元素，last指向最后一个元素，取中间元素mid：
 *      2.1 如果mid > first, 说明最小值在mid右侧，更新first = mid;
 *      2.2 如果mid < first，说明最小值在mid左侧，更新last = mid；
 *      2.3 如果first = mid，因为first >= last,则mid >= last；
 *          2.3.1 如果mid > last，则最小值仍在mid右侧，更新first = mid，此时与2.1合并；
 *          2.3.2 如果mid = last，则first = mid = last，无法确定最小值在mid的左侧还是右侧，只能顺序查找；
 *      3. 当first和last相隔一个元素，即first为前部分有序序列的最后一个元素，而last为后部分有序序列的第一个元素，终止
 *      二分查找，last即为所求。
 *
 * * User: Daniel
 * Date: 13-12-16
 * Time: 上午8:17
 */
public class FindMin {

	/**
	 *  类二分查找的思路
     *
     * @param data   数组
	 * @param length 数组的长度
	 * @return
	 */
	public int find(int[] data, int length) {
		int first = 0;
		int last = length;
		int mid = (first + last) / 2;

		//   考虑特殊情况：移动的元素个数为0
        if (data[first] < data[last]) {
			return data[first];
		}

		//   结束条件：first和last相差1时，last即为所求
		while (first < last - 1) {
            //  只能顺序查找
			if (data[first] == data[last] && data[first] == data[mid]) {
				return searchByTraverse(data, first, last);     // can be recursive
			}

			if (data[mid] >= data[first]) {
				first = mid;
			} else {        // the smallest element is int left part
				last = mid;
			}
			mid = (first + last) / 2;
		}
		return data[last];
	}

	/**
	 *  在一个序列中顺序查找最小元素
	 *
	 * @param data
	 * @param first
	 * @param last
	 * @return
	 */
	private int searchByTraverse(int[] data, int first, int last) {
		int min = data[first];
		for (int i = first; i <= last; i++) {
			if (data[i] < min) {
				min = data[i];
			}
		}
		return min;
	}
}
