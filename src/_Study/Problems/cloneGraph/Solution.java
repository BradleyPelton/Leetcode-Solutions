package _Study.Problems.cloneGraph;

import java.util.ArrayList;
import java.util.List;


/**
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/description/
 *
 * // TODO - BFS approach
 */
class Solution {
    Node[] clonedNodes;
    public Node cloneGraph(Node node) { // DFS - 7% runtime/ 6% memory
        clonedNodes = new Node[101];
        return dfsClone(node);
    }

    private Node dfsClone(Node node) {
        if (node == null) {
            return null;
        }
        if (clonedNodes[node.val] != null) { // both a dp cache and a visited array :surprisedPikachuFace:
            return clonedNodes[node.val];
        }

        clonedNodes[node.val] = new Node(node.val);

        List<Node> children = node.neighbors;
        ArrayList<Node> clonedChildren = new ArrayList<>();
        for (Node child : children) {
            Node clonedChild = dfsClone(child);
            clonedChildren.add(clonedChild);
        }

        clonedNodes[node.val].neighbors = clonedChildren;
        return clonedNodes[node.val];
    }
}



class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
         neighbors = _neighbors;
    }
}