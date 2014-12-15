package org.test.pointatoffer.tree;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.ds.TreeNode;
import org.yousharp.pointatoffer.tree.SumOfPath;

import java.util.LinkedList;

/**
 * User: lingguo
 * Date: 14-7-24 下午10:28
 */
public class SumOfPathTest extends BaseTest {

    @Test
    public void testFind() {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node9 = new TreeNode(9);
        root.left = node5;
        root.right = node7;
        node5.left = node6;
        node5.right = node4;
        node7.left = node2;
        node7.right = node9;

        LinkedList<TreeNode> path = Lists.newLinkedList();
        SumOfPath.find(root, 0, 12, path);

    }
}
