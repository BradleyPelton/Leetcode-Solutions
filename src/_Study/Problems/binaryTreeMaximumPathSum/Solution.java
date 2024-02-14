package _Study.Problems.binaryTreeMaximumPathSum;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 */
class Solution {
    Integer ans;
    public int maxPathSum(TreeNode root) { // DFS Post Order - 23% runtime (1ms), 35% memory
        ans = Integer.MIN_VALUE;
        getMaxPathSum(root);
        System.out.println(ans);
        return ans;
    }

    private int getMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Either Node is the apex or is not the apex

        int left = getMaxPathSum(node.left);
        int right = getMaxPathSum(node.right);

        int useNodeAsApex = Math.max(left, 0) + node.val + Math.max(right, 0);
        ans = Math.max(ans, useNodeAsApex);

        int localAns = node.val
                + Math.max(
                Math.max(left, 0), // left or nothing
                Math.max(right, 0) // right or nothing
        );
        return localAns;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{1,2,3})); // 6
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{-10,9,20,null,null,15,7})); // 42
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{-3})); // -3
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{1,-2,-3,1,3,-2,null,-1})); // 3
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{2,-1})); // 2
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{1,-2,3})); // 4
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6})); // 16
    }
}