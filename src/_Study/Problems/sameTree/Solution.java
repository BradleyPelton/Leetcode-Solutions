package _Study.Problems.sameTree;

import util.TreeNode;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/description/
 *
 * <p>
 *     Iterative Approach:
 *     Time Complexity: Big(n)
 *     Space Complexity: Big(n) -
 * </p>
 *
 * <p>
 *     Recursive Approach:
 *     Time Complexity: Big O(n) - each node is visited exactly once
 *     Space Complexity: Big O(n) - worst case completely unbalanced tree(straight line), the stack will have n methods
 * </p>
 *
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null  && q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}