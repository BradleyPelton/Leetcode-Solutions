package _Study.Problems.serializeAndDeserializeBinaryTree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 *
 *
 *
 *
 * See also: https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-
 *
 *
 * // TODO - DFS Solution
 */
public class Codec {
    // BFS solution
    // Level by level, append the nodes



    public String serialize(TreeNode root) { // 19% runtime, 13% memory
        List<Integer> serializedTree = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> nodesToSerialize = new ArrayDeque<>();
            nodesToSerialize.add(root);
            while (!nodesToSerialize.isEmpty()) {
                boolean nextLevelIsAllNullValues = true;
                int size = nodesToSerialize.size();
                for (int i = 0; i < size; i++) {
                    TreeNode nextNode = nodesToSerialize.remove();
                    if (nextNode == null) {
                        serializedTree.add(null);
                    } else {
                        serializedTree.add(nextNode.val);
                        if (nextNode.left != null || nextNode.right != null) {
                            nextLevelIsAllNullValues = false;
                        }
                        nodesToSerialize.add(nextNode.left);
                        nodesToSerialize.add(nextNode.right);
                    }
                }
                if (nextLevelIsAllNullValues) {
                    break;
                }
            }
        }

        String ansString = serializedTree.toString();
        return ansString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String cleanedData  = data.substring(1, data.length() - 1); // Strip brackets
        String[] nodeVals = cleanedData.split(", ");
        if (nodeVals.length == 0 || "null".equals(nodeVals[0]) || "".equals(nodeVals[0])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(nodeVals[0]));
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        for (int i = 1; i < nodeVals.length; i++) {
            TreeNode nextNode = nodes.remove();
            String nextVal = nodeVals[i];
            if ("null".equals(nextVal)) {
                nextNode.left = null;
            } else {
                nextNode.left = new TreeNode(Integer.parseInt(nextVal));
                nodes.add(nextNode.left);
            }
            if (i < nodeVals.length - 1) {
                String secondNextVal = nodeVals[i + 1];
                if ("null".equals(secondNextVal) || "".equals(secondNextVal)) {
                    nextNode.right = null;
                } else {
                    nextNode.right = new TreeNode(Integer.parseInt(secondNextVal));
                    nodes.add(nextNode.right);
                }
                i++;
            }
        }
        return root;
    }
}

class Tests {
    public static void main(String[] args) {
        Codec cod = new Codec();
//        TreeNode firstExample = TreeNode.fromArray(new Integer[]{1,2,3,null,null,4,5});
//        TreeNode secondExample = TreeNode.fromArray(new Integer[]{});
//        TreeNode thirdExample = TreeNode.fromArray(new Integer[]{1,2});
//
//        cod.deserialize(cod.serialize(firstExample));
//        cod.deserialize(cod.serialize(secondExample));
//        cod.deserialize(cod.serialize(thirdExample));

        System.out.println(TreeNode.fromArray(new Integer[]{1,2,3,null,null,4,5}).toString());
    }
}
