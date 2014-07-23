package org.test.pointatoffer.tree;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.common.TreeNode;
import org.yousharp.pointatoffer.tree.MirrorOfBinaryTree;

/**
 * User: lingguo
 * Date: 14-7-23 下午10:57
 */
public class MirrorOfTreeTest extends BaseTest {

    @Test
    public void testMirror() {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;

        MirrorOfBinaryTree.mirrorByPreOrder(root);
        MirrorOfBinaryTree.mirrorByLayer(root);

        printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        logger.info("{}", root.value);
        printTree(root.left);
        printTree(root.right);
    }
}
