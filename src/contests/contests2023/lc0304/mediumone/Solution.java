package contests.contests2023.lc0304.mediumone;


import util.TreeNode;

import java.util.*;

// Accepted first try
// Accepted after 16 minutes
// Basic BFS (breadth-first search)

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();

        Queue<TreeNode> currentNodes = new ArrayDeque<>();
        currentNodes.add(root);

        while (!currentNodes.isEmpty()) {
            long currentLevelSum = 0L;
            int numberOfCurrentNodes = currentNodes.size();
            for (int i = 0; i < numberOfCurrentNodes; i++) {
                TreeNode node = currentNodes.remove();
                currentLevelSum += node.val;
                if (node.left != null) {
                    currentNodes.add(node.left);
                }
                if (node.right != null) {
                    currentNodes.add(node.right);
                }
            }
            levelSums.add(currentLevelSum);
        }

        Collections.sort(levelSums);
        long ans;
        if (levelSums.size() >= k) {
            ans = levelSums.get(levelSums.size() - k);
        } else {
            ans = -1L;
        }

        System.out.println("ans = " + ans);
        return ans;
    }
}