package _Study.Problems.lowestCommonAncestorOfABinarySearchTree;

import util.TreeNode;


/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 *
 * <p>
 * Great Follow up : LCA of Binary Tree (not BST)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * </p>
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // Recursion - 100% runtime, 86% memory
        if (p.val < q.val) {
            return lowestCommonAncestor(root, p.val, q.val);
        } else {
            return lowestCommonAncestor(root, q.val, p.val); // WLOG - p < q
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode node, int pVal, int qVal) {
//        if (node == null) {return null;} // Unreachable due to input constraint ::: p,q guaranteed to exist in tree.
        if (node.val > qVal) { // both left
            return lowestCommonAncestor(node.left, pVal, qVal);
        } else if (node.val < pVal) { // both right
            return lowestCommonAncestor(node.right, pVal, qVal);
        } else { // else pVal is to the left and qVal is to the right. No descendant of currNode can be a parent of both.
            return node;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.lowestCommonAncestor(
                TreeNode.fromArray(new Integer[]{6,2,8,0,4,7,9,null,null,3,5}),
                2,
                8
        );
        sol.lowestCommonAncestor(
                TreeNode.fromArray(new Integer[]{6,2,8,0,4,7,9,null,null,3,5}),
                2,
                4
        );
    }
}
