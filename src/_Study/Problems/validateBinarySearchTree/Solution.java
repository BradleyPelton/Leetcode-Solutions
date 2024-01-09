package _Study.Problems.validateBinarySearchTree;

import util.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree
 * // TODO
 *
 *
 */
class Solution {
    public boolean isValidBST(TreeNode root) { // 100% runtime, 99% memory
        boolean ans = isValidSubtree(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }

    private boolean isValidSubtree(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }

        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        } else {
//            return isValidSubtree(node.left, minVal, Math.min(maxVal, node.val))
//                        && isValidSubtree(node.right, Math.max(minVal, node.val), maxVal);
            return isValidSubtree(node.left, minVal, node.val) // NOTE: Math.min(maxVal, node.val) always = node.val
                    && isValidSubtree(node.right, node.val, maxVal);
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();



    }
}