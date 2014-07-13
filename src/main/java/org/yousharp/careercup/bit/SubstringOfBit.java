package org.yousharp.careercup.bit;

/**
 * 问题描述：
 *  有两个32位的整数M和N，并给定两个整数i和j，设计一个方法，使得整数N中从i到j上的二进制表示与M的二进制表示
 *  相同，即M的二进制表示是N的二进制表示的子串。如N为10000000000， M为10101，i=2，j=6，则调用方法后，N变成
 *  了10001010100。
 *
 * 思路：
 *  1. 将N的第i到j位设置为0，其它位保持不变，然后将M左移i位，然后M与N进行或操作，即可；
 *  2. 如何将N的第i位到第j为置为0呢？可以另取一个整数P，将P的第i到j为置为0，其它位置为1，与N进行与操作即可。
 *
 * User: lingguo
 * Date: 14-7-13
 */
public class SubstringOfBit {

    /**
     * 第一种思路：首先将0到j位置1，然后将0到i位置1，两部分相减，则i到j位为1，
     *  其余位为0，取反，则i到j位为0，其余位为1，即为我们需要的mask；
     *
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    public static int updateBits1(int m, int n, int i, int j) {
        int first = (1 << (j + 1)) - 1;     // 0到j位置1
        int second = (1 << (i + 1)) - 1;    // 0到i位置1

        int mask = ~(first - second);       // i到j位置1，取反
        return (n & mask) | (m << i);       // 求结果
    }


    /**
     * 第二种思路：将j+1位到32位置1，将0到i位置1，或操作后，i到j位为0，其余位为1，则mask即为
     * 所求；
     *
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    public static int updateBits2(int m, int n, int i, int j) {
        int max = ~0;   // 所有位均为1，max值为-1，因为所有位均为1，是个复数，减1取反，得到其正数表示
        int left = max - ((1 << (j + 1)) - 1);      // 将j+1位到最高位(32)置1
        int right = (1 << (i + 1)) - 1;             // 将0到i位置1

        int mask = left | right;            // 或操作得到mask
        return (n & mask) | (m << i);
    }
}
