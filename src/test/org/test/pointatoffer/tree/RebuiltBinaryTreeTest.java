package org.test.pointatoffer.tree;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.ds.TreeNode;
import org.yousharp.pointatoffer.tree.RebuiltBinaryTree;

/**
 * User: lingguo
 * Date: 14-7-24 下午11:48
 */
public class RebuiltBinaryTreeTest extends BaseTest {

    @Test
    public void testBuilt() {
        int[] preOrder = new int[] {2, 3, 7, 9, 5, 10};
        int[] inOrder = new int[] {7, 3, 9, 2, 10, 5};
        TreeNode root = RebuiltBinaryTree.rebuilt(preOrder, 0, 5, inOrder, 0, 5);
        RebuiltBinaryTree.postOrderTraverse(root);
    }
}
