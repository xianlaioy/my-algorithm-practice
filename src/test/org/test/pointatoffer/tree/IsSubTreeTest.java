package org.test.pointatoffer.tree;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.common.TreeNode;
import org.yousharp.pointatoffer.tree.IsSubTree;

/**
 * User: lingguo
 * Date: 14-7-22 下午9:14
 */
public class IsSubTreeTest extends BaseTest {

    @Test
    public void testCheck() {
        TreeNode bigTree = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        bigTree.left = node1;
        bigTree.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode smallTree = new TreeNode(1);
        smallTree.left = new TreeNode(3);
        smallTree.right = new TreeNode(4);

        logger.info("subTree: {}", IsSubTree.check(bigTree, smallTree));

    }
}
