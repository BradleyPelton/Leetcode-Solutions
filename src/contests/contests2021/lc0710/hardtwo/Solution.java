package contests.contests2021.lc0710.hardtwo;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {

//        for (int i = 0; i < trees.size(); i++) {
//            TreeNode aNode = trees.get(i);
//            System.out.println(aNode.val);
//            System.out.println(aNode.left.val);
//            System.out.println(aNode.right.val);
//            System.out.println("=============");
//        }

        HashMap<Integer, TreeNode> rootNodeValToPointer = new HashMap<>();

        for (int i = 0; i < trees.size(); i++) {
            rootNodeValToPointer.put(trees.get(i).val, trees.get(i));
        }

        ArrayList<Integer> leafNodeValues = new ArrayList<>();

        for (int i = 0; i < trees.size(); i++) {
            TreeNode aNode = trees.get(i);
            if (aNode.left != null) {
                leafNodeValues.add(aNode.left.val);
            }
            if (aNode.right != null) {
                leafNodeValues.add(aNode.right.val);
            }
        }

        System.out.println(leafNodeValues);

        TreeNode ansRoot = null;

        for (Integer nodeVal : rootNodeValToPointer.keySet()) {
            if (!leafNodeValues.contains(nodeVal)) {
                ansRoot = rootNodeValToPointer.get(nodeVal);
            }
        }

        for (int i = 0;  i <  10; i++) {

            if (ansRoot.left != null) {
                if (rootNodeValToPointer.containsKey(ansRoot.left)) {
                    ansRoot.left = rootNodeValToPointer.get(ansRoot.left);
                }
            }
        }

        return ansRoot;
//        return new TreeNode();

    }
}