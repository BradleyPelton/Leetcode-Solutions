package _Study.Problems;

import util.TreeNode;

public class dfs {
    public static boolean depthFirstSearch(TreeNode node, final int target) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        } else {
            return depthFirstSearch(node.left, target) || depthFirstSearch(node.right, target);
        }
    }
}
