package _Study.Problems.minimumDepthofBinaryTree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 */
class Solution {
    public int minDepthITERATIVE(TreeNode root) { // BFS 100% runtime, 87% memory
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> currentNodes = new ArrayDeque<>();
        currentNodes.add(root);
        int minDepth = 0;
        while (!currentNodes.isEmpty()) {
            minDepth++;
            int numberOfCurrentDepthNodes = currentNodes.size();
            for (int i = 0; i < numberOfCurrentDepthNodes; i++) {
                TreeNode currNode = currentNodes.poll();
                if (currNode.left == null && currNode.right == null) { // is leaf node
                    return minDepth;
                } else {
                    if (currNode.left != null) currentNodes.add(currNode.left);
                    if (currNode.right != null) currentNodes.add(currNode.right);
                }
            }
        }
        return minDepth;
    }

    public int minDepthRECURSIVE(TreeNode root) { // DFS "top down recursion" - 73% runtime, 10% memory
        // "Top Down recursion" (tracking a new state variable with int currDepth)
        // the "bottom up recursion" approach is much faster
        if (root == null) {
            return 0;
        }
        return minDepthRECURSIVE(root, 1);
    }

    private int minDepthRECURSIVE(TreeNode node, int currDepth) {
        if (node.left == null && node.right == null) { // if leaf node
            return currDepth;
        }

        if (node.left == null) {
            return minDepthRECURSIVE(node.right, currDepth + 1);
        } else if (node.right == null) {
            return minDepthRECURSIVE(node.left, currDepth + 1);
        } else {
            return Math.min(minDepthRECURSIVE(node.left, currDepth + 1), minDepthRECURSIVE(node.right, currDepth + 1));
        }
    }

    public int minDepth(TreeNode root) { // DFS "bottom up" recursion -
        if (root == null) {
            return 0;
        }
        return minDepthFromCurrentNode(root) + 1;
    }

    private int minDepthFromCurrentNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 0;
        } else if (node.left == null) {
            return minDepthFromCurrentNode(node.right) + 1;
        } else if (node.right == null) {
            return minDepthFromCurrentNode(node.left) + 1;
        } else {
            int leftMin = minDepthFromCurrentNode(node.left);
            int rightMin = minDepthFromCurrentNode(node.right);
            return Math.min(leftMin, rightMin) + 1;
        }
    }
}