package _Study.Problems.kthSmallestElementInABST;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
//    PriorityQueue<Integer> maxHeap;
//    int k;
//    public int kthSmallest(TreeNode root, int k) { // heap - 6% runtime, 39% memory
//        this.k = k;
//        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        dfs(root);
//
//        int ans = maxHeap.remove();
//        System.out.println(ans);
//        return ans;
//    }
//
//    private void dfs(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        maxHeap.add(node.val);
//        if (maxHeap.size() > k) {
//            maxHeap.remove();
//        }
//
//        dfs(node.left);
//        dfs(node.right);
//    }
//    int k;
//    List<Integer> nodesInOrder;
//    public int kthSmallest(TreeNode root, int k) { // In Order Traversal - Space suboptimal - 13% runtime, 39% memory
//        // In order traversal of BST will return elements in sorted order
//        this.k = k;
//        nodesInOrder = new ArrayList<>();
//        inOrderTraversal(root);
//        int ans = nodesInOrder.get(k - 1);
//        System.out.println(ans);
//        return ans;
//    }
//
//    private void inOrderTraversal(TreeNode node) {
//        if (node == null || nodesInOrder.size() > k) {
//            return;
//        }
//
//        inOrderTraversal(node.left);
//        nodesInOrder.add(node.val);
//        inOrderTraversal(node.right);
//    }

    int k;
    int nodesSeenSoFar = 1; // 1-indexed
    Integer ans;
    public int kthSmallest(TreeNode root, int k) { // In Order Traversal - Space Optimized w/ short circuit - 100% runtime, 85% memory
        // In order traversal of BST will return elements in sorted order
        this.k = k;
        inOrderTraversal(root);
        return ans;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null || nodesSeenSoFar > k) {
            return;
        }

        inOrderTraversal(node.left);
        if (ans == null && nodesSeenSoFar == k) {
            ans = node.val;
        }
        nodesSeenSoFar++;
        inOrderTraversal(node.right);
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.kthSmallest(
//                TreeNode.fromArray(new Integer[]{3,1,4,null,2}),
//                1
//        );
        sol.kthSmallest(
                TreeNode.fromArray(new Integer[]{5,3,6,2,4,null,null,1}),
                3
        );
    }
}
