package org.yousharp.julycoding.string;

/**
 * 问题描述：
 *  判断一个字符串是否为回文串，即字符串顺着读和反着读是一样的，如：madam是一个回文串。
 *
 * 思路：
 *  思路一：使用两个指针，从两端向中间遍历，直到相遇，判断是否相等；时间复杂度O(n)，空间复杂度O(1)；
 *  思路二：使用两个指针，从中间向两端遍历，直到遇到字符边界，判断是否相等；时间复杂度O(n)，空间复杂度O(1)；
 *
 * User: lingguo
 * Date: 14-7-27 下午11:38
 */
public class Palindrome {

    /**
     * 思路一：使用两个指针，从两端向中间遍历；
     *
     * @param str
     * @return
     */
    public static boolean check(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        /* 确定指针的初始位置 */
        int first = 0;
        int last = str.length - 1;
        while (first < last) {
            if (str[first] != str[last]) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }


    /**
     * 思路二：使用两个指针，从中间向两端遍历；
     *
     * @param str
     * @return
     */
    public static boolean check2(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        if (str.length == 1) {
            return true;
        }
        /* 确定指针的首尾位置 */
        int midLeft = (str.length >> 1) - 1;
        int midRight = str.length - 1 - midLeft;
        while (midLeft >= 0) {
            if (str[midLeft] != str[midRight]) {
                return false;
            }
            midLeft--;
            midRight++;
        }
        return true;
    }
}
