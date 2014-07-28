package org.yousharp.julycoding.string;

/**
 * 问题描述：
 *  给定一个字符串，求最长回文子串；
 *
 * 思路：
 *  思路一；遍历每一个字符，以该字符为中心，向两端扩展形成回文串，遍历完毕，取最大值即可；
 *  这里就是需要分两种情况：回文串为偶数和奇数。
 *
 *  思路二：Manacher算法：
 *
 *
 * 链接：https://github.com/nkcoder/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.05.md
 *
 * User: lingguo
 * Date: 14-7-28 下午10:19
 */
public class LongestPalindrome {

    public static char[] center(char[] str) {
        if (str == null || str.length == 0) {
            return null;
        }

        int start = 0;
        int end = 0;
        int max = 1;

        for (int i = 0; i < str.length; i++) {
            int j = 0;

            /* 回文串为奇数，str[i]为中心，左右字符比对 */
            for (j = 0; i - j >= 0 && i + j <= str.length - 1; j++) {
                if (str[i - j] != str[i + j]) {
                    break;
                }
            }
            /* 注意：j-1才是回文一半的数量，因为j时已经退出 */
            if (2 * (j-1) + 1 > max) {
                max = 2 * (j-1) + 1;
                start = i - j + 1;
                end = i + j - 1;
            }

            /* 回文串为偶数，str[i]作为左字符，与右字符str[i+1]比对 */
            for (j = 0; i - j >= 0 && i + j + 1 <= str.length - 1; j++) {
                if (str[i-j] != str[i+j+1]) {
                    break;
                }
            }
            if (2 * (j-1) + 2 > max) {
                max = 2*(j-1) + 2;
                start = i - j + 1;
                end = i + j;
            }
        }

        /* 保存回文串 */
        char[] longestPal = new char[max];
        for (int i = start, j = 0; i <= end; i++) {
            longestPal[j++] = str[i];
        }

        return longestPal;
    }
}
