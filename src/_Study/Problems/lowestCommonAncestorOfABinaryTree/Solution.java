package _Study.Problems.lowestCommonAncestorOfABinaryTree;

import util.TreeNode;


/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * // TODO - Optimize DFS
 * // TODO - BFS
 */
class Solution {
    int pVal;
    int qVal;
    TreeNode ans;
    int ansDepth = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        pVal = p.val;
        qVal = q.val;

        search(root);
        return ans;
    }

    private boolean[] search(TreeNode node) {
        if (node == null) {
            return new boolean[]{false, false};
        }

        // {pValSeen, qValSeen}

        boolean[] leftTree = search(node.left);
        boolean[] rightTree = search(node.right);


        boolean[] searchResults = new boolean[2];
        if (node.val == pVal) {
            searchResults[0] = true;
            if (leftTree[1]) {
                ans = node;
            } else if (rightTree[1]) {
                ans = node;
            } else {  // qVal not below
//                return new boolean[]{true, false};
            }
        } else if (node.val == qVal) {
            searchResults[1] = true;
            if (leftTree[0]) {
                ans = node;
            } else if (rightTree[0]) {
                ans = node;
            } else {  // pVal not below
//                return new boolean[]{false, true};
            }
        } else {
            if (leftTree[0] && rightTree[1]) {
                ans = node;
            } else if (leftTree[1] && rightTree[0]) {
                ans = node;
//            } else if (leftTree[0] && rightTree[0]) {
//            } else if (leftTree[1] && rightTree[1]) {
            }
        }
        searchResults[0] = searchResults[0] || leftTree[0] || rightTree[0];
        searchResults[1] = searchResults[1] || leftTree[1] || rightTree[1];
        return searchResults;
    }
}
