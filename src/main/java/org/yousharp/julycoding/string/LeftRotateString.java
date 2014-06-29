package org.yousharp.julycoding.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.ListNode;

/**
 * 1.1 旋转字符串
 *
 * Created by lingguo on 14-6-26.
 */
public class LeftRotateString {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 问题描述：
     *  给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串
     *  的尾部，使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间
     *  复杂度为 O(1)。
     *
     * 思路：
     *  三步旋转法：(X^TY^T)^T=YX
     *
     * @param str
     * @param n
     * @return
     */
     public String leftRotateString(char[] str, int n) {

         return null;
     }

    /**
     * 问题描述：
     *  链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，若k=3，翻转后
     *  3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
     *
     * 思路：
     *  使用反转链表的思路，将链表的前部分反转，然后将链表的后部分反转，最后将前部分链表的尾节点指向后部分链表的头节点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode rotateLinkedList(ListNode head, int n) {

        return null;
    }

    /**
     * 问题描述：
     *  编写程序，在原字符串中把字符串尾部的m个字符移动到字符串的头部，要求：长度为n的字符串操作时间复杂度为O(n)，空间复杂度
     *  为O(1)。 例如，原字符串为”Ilovebaofeng”，m=7，输出结果为：”baofengIlove”。
     *
     * 思路：
     *  与左旋转字符串的思路是一样的；
     *
     * @param str
     * @param n
     * @return
     */
    public String rotateString(char[] str, int n) {
        return null;
    }

    /**
     * 问题描述：
     *  单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。为简单起见，标点符
     *  号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
     *
     * 思路：
     *  先将每个单词反转，然后将整个句子反转；
     *
     * @param sentence
     * @return
     */
    public String rotateSentence(char[] sentence) {
        return null;
    }

}
