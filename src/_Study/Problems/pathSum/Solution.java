package _Study.Problems.pathSum;

import util.TreeNode;


/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/description/
 *
 * // TODO - Recursive approach
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) { // 100% runtime, 91% memory
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode node, int targetSum, int currentSum) {
        if (node.left == null) {
            if (node.right == null) {
                return currentSum + node.val == targetSum;
            } else {
                return hasPathSum(node.right, targetSum, currentSum + node.val);
            }
        } else {
            if (node.right == null) {
                return hasPathSum(node.left, targetSum, currentSum + node.val);
            } else {
                return hasPathSum(node.left, targetSum, currentSum + node.val)
                        || hasPathSum(node.right, targetSum, currentSum + node.val);
            }
        }
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) { // 100% runtime, 97% memory
        if (root == null) {
            return false;
        }

        // if leaf root
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else { // else not leaf
            return hasPathSum2(root.left, targetSum - root.val)
                    || hasPathSum2(root.right, targetSum - root.val);
        }
    }
}