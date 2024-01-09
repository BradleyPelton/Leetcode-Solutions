package _Study.Problems.maximumDepthOfBinaryTree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description
 *
 * <p>
 *     Iterative Approach: BFS
 *     Time Complexity: O(n) - Each node is visited exactly once
 *     Space Complexity: O(n) -
 * </p>
 *
 * <p>
 *     Recursive Approach: DFS
 *     Time Complexity: O(n) - Each node is visited exactly once
 *     Space Complexity: O(n) - Worst case the tree is a straight line and there are n recursive calls (height of the tree)
 * </p>
 */
class Solution {
    public int maxDepth = 0;
    public int maxDepthITERATIVE(TreeNode root) { // BFS - 11% runtime, 54% memory
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;

        Queue<TreeNode> currentNodes = new ArrayDeque<>();
        currentNodes.add(root);

        while(!currentNodes.isEmpty()) {
            maxDepth++;
            int numberOfCurrentNodes = currentNodes.size();

            for (int i = 0; i < numberOfCurrentNodes; i++) {
                TreeNode nextNode = currentNodes.poll();
                if (nextNode.left != null) currentNodes.add(nextNode.left);
                if (nextNode.right != null) currentNodes.add(nextNode.right);
            }
        }
        return maxDepth;
    }

    public int maxDepthRECURSIVE(TreeNode root) { // DFS "Top Down recursion" - 100% runtime, 5% memory
        int ans = maxDepthRECURSIVE(root, 0);
        return ans;
    }

    public int maxDepthRECURSIVE(TreeNode node, int parentDepth) {
        if (node == null) {
            return parentDepth;
        }
        int leftDepth = maxDepthRECURSIVE(node.left, parentDepth + 1);
        int rightDepth = maxDepthRECURSIVE(node.right, parentDepth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public int maxDepthRECURSIVE2(TreeNode root) { // DFS "bottom up recursion" - 100% runtime, 20% memory
        return maxDepthFromCurrentNode(root);
    }

    private int maxDepthFromCurrentNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepthFromCurrentNode(node.left), maxDepthFromCurrentNode(node.right)) + 1;
    }
}
