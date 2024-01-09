package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class TreeNode {
    // SEE https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-
    // Binary Tree Serialization

    public int val;
    public TreeNode left;
    public TreeNode right;

    // No args constructor
    TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public static TreeNode fromArray(Integer[] arr) {
        if (arr.length == 0) return null;

        List<Optional<TreeNode>> level = new ArrayList<>();
        List<Optional<TreeNode>> newLevel = new ArrayList<>();
        int arrPos = 0;
        TreeNode root = fromInteger(arr[0]);

        level.add(Optional.ofNullable(root));

        while (!level.isEmpty()) {
            int levelStartPos = arrPos;
            for (Optional<TreeNode> n : level) {
                if (n.isPresent()) {
                    int leftChildPos = levelStartPos + level.size() + newLevel.size();
                    int rightChildPos = leftChildPos + 1;
                    if (rightChildPos >= arr.length) break;
                    n.get().left = fromInteger(arr[leftChildPos]);
                    newLevel.add(Optional.ofNullable(n.get().left));
                    n.get().right = fromInteger(arr[rightChildPos]);
                    newLevel.add(Optional.ofNullable(n.get().right));
                }
                arrPos++;
            }
            level = newLevel;
            newLevel = new ArrayList<>();
        }

        return root;
    }

    public String serialize() {
        // SEE https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
        // SEE /_Study/Problems/serializeAndDeserializeBinaryTree/Codec.java
        TreeNode root = this;
        List<Integer> serializedTree = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> nodesToSerialize = new LinkedList<>();
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

//    public String toString() { // TODO - Buggy when there are null values.
//        return serialize();
//    }

    private static TreeNode fromInteger(Integer i) {
        return i == null ? null : new TreeNode(i);
    }
}