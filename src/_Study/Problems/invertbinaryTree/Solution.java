package _Study.Problems.invertbinaryTree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * <p>
 *     Recursive Approach:
 *     n = number of nodes in the tree
 *     Time Complexity: Big O(n) (every node is visited once)
 *     Space Complexity: Big O(n) (number of recursive calls on the stack) (straight-line tree)
 *</p>
 *
 * <p>
 *     Iterative Approach: BFS
 *     Time Complexity: Big O(n) (every node is visited once)
 *     Space Complexity: Big O(n) (worst case half the nodes are in the Queue at any given time)
 * </p>
 *
 */
class Solution {
    public TreeNode invertTreeRECURSIVE(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Temporarily hold left and right before swapping (Fibonacci problem)
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTreeRECURSIVE(right);
        root.right = invertTreeRECURSIVE(left);

        return root;
    }

    public TreeNode invertTreeITERATIVE(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> currentNodes = new ArrayDeque<>();  // BFS
        currentNodes.add(root);

        while (!currentNodes.isEmpty()) {
            TreeNode nextNode = currentNodes.poll();
            TreeNode temp = nextNode.left;
            nextNode.left = nextNode.right;
            nextNode.right = temp;
            if (nextNode.left != null) currentNodes.add(nextNode.left);
            if (nextNode.right != null) currentNodes.add(nextNode.right);
        }
        return root;
    }
}