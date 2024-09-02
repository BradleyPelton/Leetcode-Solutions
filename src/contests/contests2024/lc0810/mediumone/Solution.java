package contests.contests2024.lc0810.mediumone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First attempt wrong answer
// Second attempt accepted after 31 minutes.

// Nasty bug to debug. Sum of subtree was wrong.

class Solution {
    Map<Integer, List<Integer>> adjacencyList;
    int numberOfGoodNodes;
    public int countGoodNodes(int[][] edges) {
        numberOfGoodNodes = 0;
        adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
        }

        countSubtree(0, Integer.MAX_VALUE);
        System.out.println(numberOfGoodNodes);
        return numberOfGoodNodes;
    }

    private int countSubtree(int currNode, int parentNode) {
        List<Integer> childNodes = adjacencyList.getOrDefault(currNode, List.of());

        int childNodeSum = Integer.MIN_VALUE;
        int totalSum = 0;
        boolean isGoodTree = true;
        for (int childNode : childNodes) {
            if (childNode != parentNode) {
                int localSum = countSubtree(childNode, currNode); // excluding the node itself
                if (childNodeSum == Integer.MIN_VALUE) {
                    childNodeSum = localSum;
                    totalSum = localSum;
                } else {
                    totalSum += localSum;
                    if (childNodeSum == localSum) {
                    } else {
                        isGoodTree = false;
                    }
                }
            }
        }

        if (isGoodTree) {
            numberOfGoodNodes++;
        }

        return totalSum + 1; // sum of children plus itself
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countGoodNodes(
                new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}}
        ); // 7
        sol.countGoodNodes(
                new int[][]{{0,1},{1,2},{2,3},{3,4},{0,5},{1,6},{2,7},{3,8}}
        ); // 6
        sol.countGoodNodes(
                new int[][]{{0,1},{1,2},{1,3},{1,4},{0,5},{5,6},{6,7},{7,8},{0,9},{9,10},{9,12},{10,11}}
        ); // 12

//
        sol.countGoodNodes(
                new int[][]{{6,0},{1,0},{5,1},{2,5},{3,1},{4,3}}
        ); // 6

    }
}