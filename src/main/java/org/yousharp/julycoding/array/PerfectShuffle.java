package org.yousharp.julycoding.array;

/**
 * 题目描述（完美洗牌）：
 *  有一个长度为2n的数组{a1a2...anb1b2..bn}, 希望排序后变为：{a1b1a2b2...anbn}，
 *  请考虑有无时间复杂度为O(n)，空间复杂度为O(1)的解法；
 *
 * 思路：（取n=4为例，即{a1a2a3a4b1b2b3b4} -> {a1b1a2b2a3b3a4b4})
 *  【思路一】：蛮力替换，通过元素的移动依次将b1、b2、b3、b4放到正确的位置：
 *      1.1 将b1放到正确的位置，则a2、a3、a4后移，b2放在a2的位置，即：
 *          a1a2a3a4b1b2b3b4 -> a1b1a2a3a4b2b3b4
 *      1.2 将b2放到正确的位置，则a3、a4后移，b2放在a3的位置，即：
 *          a1b1a2a3a4b2b3b4 -> a1b1a2b2a3a4b3b4
 *      1.3 将b3放到正确的位置，则a4后移，b3放在a4的位置，变换结束，即：
 *          a1b1a2b2a3a4b3b4 -> a1b1a2b2a3b3a4b4
 *      时间复杂度为O(n^2)，空间复杂度为O(1)；
 *
 *  【思路二】：中心替换，每次将对称的两个元素替换：
 *      2.1 将中线对称的一组元素互换，即an和b1互换，即：
 *          a1a2a3a4b1b2b3b4 -> a1a2a3b1a4b2b3b4
 *      2.2 将中线对称的两组元素前后互换，即a3与b1、a4与b2互换，则：
 *          a1a2a3b1a4b2b3b4 -> a1a2b1a3b2a4b3b4
 *      2.4 将中线对称的三组元素前后互换，即a2与b1、a3与b2、a4与b3互换，则：
 *          a1a2b1a3b2a4b3b4 -> a1b1a2b2a3b3a4b4
 *      时间复杂度为O(n^2)，空间复杂度为O(1)；
 *
 *  【思路三】：位置置换：根据元素的初始及终止位置寻找通用规律：
 *      为了讨论的方便，数组的下标从1开始，即初始为12345678：
 *      3.1 变换前后，a2的位置变化：2 -> 3；
 *      3.2 变换前后，a3的位置变化：3 -> 5;
 *      3.3 变换前后，a4的位置变化：4 -> 7；
 *      3.4 变换前后，b1的位置变化：5 -> 2；
 *      3.5 变换前后，b2的位置变化：6 -> 4；
 *      3.6 变换前后，b3的位置变化：7 -> 6；
 *      对于前三种情况，即1<i<=n时(总长度为2n)，i -> (2*i - 1)；因为i<n，所以有：
 *          i -> (2*i-1) -> (2*i-1) % (2*n-1)
 *      对于后三种情况，即n<i<2n时，i -> 2*(i-n) = (2*i-1)-(2*n-1);因为i<2n，即
 *      i的最大值为2n-1，所以(2*i-1)最多是(2*n-1)的一倍，所以有：
 *          i -> (2*i-1) - (2*n-1) -> (2*i-1) % (2*n-1)
 *      所以综合起来就有：i -> (2*i-1) % (2*n-1)；
 *      在具体实现时可能需要额外的辅助数据进行变化，所以时间复杂度为O(n)，空间复杂度为O(n)。
 *
 *  【思路四】：时间复杂度为O(n)，空间复杂度为O(1)的解法参考：
 *      - https://github.com/nkcoder/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.09.md
 *
 *
 *
 *
 *
 *
 *
 * @author: lingguo
 * @time: 2014/8/31 8:54
 */
public class PerfectShuffle {
}