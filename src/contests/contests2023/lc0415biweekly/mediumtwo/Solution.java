package contests.contests2023.lc0415biweekly.mediumtwo;

import util.TreeNode;

import java.util.*;

// Accepted first attempt
// Accepted at 8:45
// I lost 40 minutes trying to debug the fact that I was updating the value of the node and trying to use the old value.

// I got away with a memory brute force here it feels like. I copied the entire datastructure twice over.

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<TreeNode, Integer> originalValueMap = new HashMap<>();
        // child -> parent

        Queue<TreeNode> nodesToSearchQueue = new ArrayDeque<>();
        nodesToSearchQueue.add(root);


        while (!nodesToSearchQueue.isEmpty()) {
            // Update parentMap
            for(TreeNode parentNode : nodesToSearchQueue) {
                if (parentNode.left != null) {
                    parentMap.put(parentNode.left, parentNode);
                }
                if (parentNode.right != null) {
                    parentMap.put(parentNode.right, parentNode);
                }
            }

            int depthSum = 0;
            int nodesToSearchThisLevel = nodesToSearchQueue.size();
            for (TreeNode node : nodesToSearchQueue) {
                depthSum += node.val;
                originalValueMap.put(node, node.val);
            }

            for (int i = 0; i < nodesToSearchThisLevel; i++) {
                // calculate the sum of all depth
                // node.val = total_sum - parent_sum
                TreeNode currNode = nodesToSearchQueue.poll();

                int parentSum = 0;
                TreeNode parentOfCurrNode = parentMap.get(currNode);
                if (parentOfCurrNode == null) {
                    currNode.val = 0;
                } else {
                    parentSum = (parentOfCurrNode.left != null ? originalValueMap.get(parentOfCurrNode.left) : 0)
                            + (parentOfCurrNode.right != null ? originalValueMap.get(parentOfCurrNode.right) : 0);
                    currNode.val = depthSum - parentSum;
                }


                // Update Queue
                if (currNode.left != null) {
                    nodesToSearchQueue.add(currNode.left);
                }
                if (currNode.right != null) {
                    nodesToSearchQueue.add(currNode.right);
                }
            }
        }
        return root;
    }
}