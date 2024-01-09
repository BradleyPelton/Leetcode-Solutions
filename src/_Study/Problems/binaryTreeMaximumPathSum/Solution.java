package _Study.Problems.binaryTreeMaximumPathSum;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * Slow. 5% runtime, 28% memory
 * Sloppy edge case handling.
 *
 * // TODO - Redo this from scratch. The solution below is overly complicated
 *
 */
class Solution {
    int largestValueSeen;
    Map<TreeNode, Integer> dpDownSum;
    public int maxPathSum(TreeNode root) {
        largestValueSeen = root.val;
        dpDownSum = new HashMap<>();



        int ans = maxPathWhereCurrentNodeIsPinnacle(root);
        ans = Math.max(ans, largestValueSeen);


        System.out.println(ans);

        return ans;
    }


    // There exists some node in the optimal path
    // Where that node is the highest element in the path.
    private int maxPathWhereCurrentNodeIsPinnacle(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        largestValueSeen = Math.max(largestValueSeen, node.val);

        if (node.left == null && node.right == null) { // leaf nodes can't be max
            return Integer.MIN_VALUE;
        }

        int leftDownPath = Math.max(0, maxDownPath(node.left));
        int rightDownPath = Math.max(0, maxDownPath(node.right));

        int currIsTheHighest = node.val + leftDownPath + rightDownPath;

        int leftIsTheHighest = maxPathWhereCurrentNodeIsPinnacle(node.left);
        int rightIsTheHighest = maxPathWhereCurrentNodeIsPinnacle(node.right);

        int ans = Math.max(currIsTheHighest, Math.max(leftIsTheHighest, rightIsTheHighest));
        return ans;
    }

    private int maxDownPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (dpDownSum.containsKey(node)) {
            return dpDownSum.get(node);
        }

        // Given a node, return the max path sum down the tree

        int stopAtCurrentNode = node.val;
        int includeLeft = node.val + maxDownPath(node.left);
        int includeRight = node.val + maxDownPath(node.right);

        int ans = Math.max(stopAtCurrentNode, Math.max(includeLeft, includeRight));
        dpDownSum.put(node, ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.maxPathSum(TreeNode.fromArray(new Integer[]{1,2,3}));
//        sol.largestValueSeen = Integer.MIN_VALUE;
//        sol.maxPathSum(TreeNode.fromArray(new Integer[]{1,-2,-3,1,3,-2,null,-1, 10, 20, 40, -20, -30, null, null, 14, 0, -13}));
//        sol.largestValueSeen = Integer.MIN_VALUE;
//        sol.maxPathSum(TreeNode.fromArray(new Integer[]{-3}));
//        sol.largestValueSeen = Integer.MIN_VALUE;
//        sol.maxPathSum(TreeNode.fromArray(new Integer[]{1,-2,-3,1,3,-2,null,-1}));
//        sol.largestValueSeen = Integer.MIN_VALUE;
//        sol.maxPathSum(TreeNode.fromArray(new Integer[]{2,-1}));
//        sol.largestValueSeen = Integer.MIN_VALUE;
        sol.maxPathSum(TreeNode.fromArray(new Integer[]{1,-2,3}));
        sol.largestValueSeen = Integer.MIN_VALUE;
    }
}