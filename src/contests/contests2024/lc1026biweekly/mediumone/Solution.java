package contests.contests2024.lc1026biweekly.mediumone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted first try
// Accepted at 10:30 (roughly 45 minutes)

// Struggled quiet a bit with the strategy here.
// The level approach took me a 15-20 minutes to create
// Counting the size of the subtree took longer than it should (simple recursion)

class Solution {
    int[] ans;
    int n;
    Map<Integer, List<Integer>> childMapFixed;
    public int[] findSubtreeSizes(int[] parent, String s) {
        this.n = parent.length;

        Map<Integer, List<Integer>> childMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            childMap.computeIfAbsent(parent[i], a -> new ArrayList<>()).add(i);
        }

        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        ArrayDeque<Integer> nodesToSearch = new ArrayDeque<>();
        nodesToSearch.add(0);
        int level = -1;

        while (!nodesToSearch.isEmpty()) {
            level++;
            int prevLevelSize = nodesToSearch.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < prevLevelSize; i++) {
                int node = nodesToSearch.removeFirst();
                currLevel.add(node);

                List<Integer> nodesChildren = childMap.getOrDefault(node, List.of());
                for (int child : nodesChildren) {
                    nodesToSearch.addLast(child);
                }
            }

            levelMap.put(level, currLevel);
        }


        while (level >= 0) {
            List<Integer> currLevel = levelMap.get(level);

            for (int node : currLevel) {
                char currNodeChar = s.charAt(node);
                // Set/Correct/Fix PARENT
                int parentNode = parent[node];

                while (parentNode != -1) {
                    if (s.charAt(parentNode) == currNodeChar) {
                        parent[node] = parentNode;
                        break;
                    } else {
                        parentNode = parent[parentNode];
                    }
                }
            }
            level--;
        }


        childMapFixed = new HashMap<>();
        for (int i = 0; i < n; i++) {
            childMapFixed.computeIfAbsent(parent[i], a -> new ArrayList<>()).add(i);
        }
        // Now, we have our parent array correct. Count the subtrees

        this.ans = new int[n];
        sizeOfSubtree(0);

//        System.out.println(Arrays.toString(ans));

        return ans;
    }

    private int sizeOfSubtree(int currNode) {
        int currSize = 1; // SELF

        List<Integer> children = childMapFixed.getOrDefault(currNode, List.of());
        for (int child : children) {
            currSize += sizeOfSubtree(child);
        }

        ans[currNode] = currSize;
        return currSize;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findSubtreeSizes(
                new int[]{-1,0,0,1,1,1},
                "abaabc"
        );
        sol.findSubtreeSizes(
                new int[]{-1,0,4,0,1},
                "abbba"
        );



    }
}
