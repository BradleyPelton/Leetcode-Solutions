package _Study.Problems.symmetricTree;

import util.TreeNode;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 *
 * // TODO Iterative
 */
class Solution {
    public boolean isSymmetric(TreeNode root) { // Recursive , 100% runtime, 5% memory
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null) {
            return rightNode == null;
        } else if (rightNode == null) {
            return false;
        }

        boolean baseRecurse = leftNode.val == rightNode.val;
        boolean nextLevel = isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
        return baseRecurse && nextLevel;
    }
}