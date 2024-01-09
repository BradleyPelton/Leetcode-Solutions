package _Study.Problems.deleteNodeInBST;

import util.TreeNode;

/**
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 *
 * // TODO - There is a solution that leaves the tree more balanced. (swapping node with the predecessor)
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) { // 100% runtime, 8% memory
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) { // covers both left,right = null cases
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.right.left == null) {
                    root.right.left = root.left;
                    return root.right;
                } else {
                    TreeNode newRoot = root.right;
                    // newRoot.right is already in it's correct location
                    // we need to move newRoot.left to the bottom right corner of the root.left

                    TreeNode greatestSmallest = root.left; // find the leaf node in the bottom right corner of the root.left subtree
                    while (greatestSmallest.right != null) {
                        greatestSmallest = greatestSmallest.right;
                    }

                    greatestSmallest.right = newRoot.left;
                    newRoot.left = root.left;
                    return newRoot;
                }
            }
        } else { // center the keyNode to root
            if (key < root.val) {
                if (root.left != null) {
                    root.left = deleteNode(root.left, key);
                }
            } else { // key > root.val
                if (root.right != null) {
                    root.right = deleteNode(root.right, key);
                }
            }
            return root;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.deleteNode(TreeNode.fromArray(new Integer[]{5,3,6,2,4,null,7}), 3);
        sol.deleteNode(TreeNode.fromArray(new Integer[]{2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6}),
                33
        );
    }
}
