package _Study.Problems.constructBinaryTreeFromPreorderAndInorderTraversal;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * Struggled a lot (1.5 hours) with this problem.
 */
class Solution {
    int[] preorder;
    int[] inorder;
    int n;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.n = preorder.length;
        this.preorderIndex = 0;
        return buildSubTree(0, n - 1);
    }

    public TreeNode buildSubTree(int inOrderLeft, int inOrderRight) {
        if (preorderIndex >= n || inOrderLeft > inOrderRight) {
            return null;
        }
        // preOrder[0] is always root
        TreeNode root = new TreeNode(preorder[preorderIndex]); // f, "6"
        preorderIndex++;

        if (inOrderLeft == inOrderRight) {
            // do nothing
        } else {
            int midInOrderIndex = -1; // [0..4] // index=4 we have val = root.val
            for (int i = inOrderLeft; i < n; i++) {
                if (inorder[i] == root.val) {
                    midInOrderIndex = i;
                    break;
                }
            }

            // inOrder for left tree = [values[1..5]] = indexes [0..4]
            root.left = buildSubTree(inOrderLeft, midInOrderIndex - 1);

            // inorder for right tree = [values[7..9] = indexes[6..8]
            root.right = buildSubTree(midInOrderIndex + 1, inOrderRight);
        }

        return root;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.buildTree(
//                new int[]{3,9,20,15,7},
//                new int[]{9,3,15,20,7}
//        );
//        sol.buildTree(
//                new int[]{-1},
//                new int[]{-1}
//        );
    }
}