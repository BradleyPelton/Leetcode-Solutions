package _Study.Problems.insertIntoABinarySearchTree;

import util.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 *
 * // TODO - Recursive
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) { // ITERATIVE
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode node = root;
        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else  {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }
}
