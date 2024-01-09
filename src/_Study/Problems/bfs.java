package _Study.Problems;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static boolean breadthFirstSearch(TreeNode rootNode, final int target) {
        boolean isValueFound = false;

        Queue<TreeNode> nodesToSearchQueue = new ArrayDeque<>();
        nodesToSearchQueue.add(rootNode);

        while (!nodesToSearchQueue.isEmpty()) {
            int queueSizeBeforeAddingNextLevel = nodesToSearchQueue.size();
            for (int i = 0; i < queueSizeBeforeAddingNextLevel; i++) {
                TreeNode currentNodeBeingSearched = nodesToSearchQueue.poll();
                if (currentNodeBeingSearched.val == target) {
                    isValueFound = true;
                    break;
                }

                // Add next level
                if (currentNodeBeingSearched.left != null) {
                    nodesToSearchQueue.add(currentNodeBeingSearched.left);
                }
                if (currentNodeBeingSearched.right != null) {
                    nodesToSearchQueue.add(currentNodeBeingSearched.right);
                }
            }
        }
        return isValueFound;
    }
}
