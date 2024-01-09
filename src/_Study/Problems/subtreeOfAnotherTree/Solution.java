package _Study.Problems.subtreeOfAnotherTree;

import util.TreeNode;

/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * <p>
 *     Recursive DFS:
 *     Time Complexity: Big O(m * n) - check every node in parent tree (n) and then check all subtrees (m)
 *     Space Complexity: Big O(m + n)  - At most n recursive calls for isSubTree, and m recursive calls for isSameTree
 * </p>
 *
 * NOTE: There are some cool solutions around tree hashing and tree serialization here. Out of scope.
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

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