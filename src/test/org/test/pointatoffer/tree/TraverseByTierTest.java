package org.test.pointatoffer.tree;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.common.TreeNode;
import org.yousharp.pointatoffer.tree.TraverseByTier;

/**
 * User: lingguo
 * Date: 14-7-24 下午10:06
 */
public class TraverseByTierTest extends BaseTest {

    @Test
    public void testTraverse() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TraverseByTier.traverse(root);
    }
}
