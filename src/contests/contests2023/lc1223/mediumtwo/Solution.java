package contests.contests2023.lc1223.mediumtwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        Map<Character, Map<Character, Integer>> changeCostMap = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            char previousChar = original[i];
            char nextChar = changed[i];
            int changeCost = cost[i];

            if (!changeCostMap.containsKey(previousChar)) {
                changeCostMap.put(previousChar, new HashMap<>());
            }
            changeCostMap.get(previousChar).put(nextChar, changeCost);
        }

        // a -> {b -> 1, d -> 5};
        // b -> {c -> 2};

        // This is a typical walk.

        // Minimum distance from characters.
        // Characters are nodes.
        // I effectively created an adjanceny list. My problem is creating a "pathList" (all costs for all paths)
        // Maybe this is typical Dijkstra's? We need all path costs though. Dijkstra's is min path cost for one node.


        while (true) {
            boolean changeWasMade = false;
            for (char originalChar : changeCostMap.keySet()) {
                Map<Character, Integer> originalMaps = changeCostMap.get(originalChar); // {b -> 1, d -> 5};
                Set<Character> originalMapsKeys = originalMaps.keySet();

                for (char downStreamKey : originalMapsKeys) { // for b,d
                    Map<Character, Integer> downStreamMap = changeCostMap.get(downStreamKey); // {c -> 2};
                    Set<Character> bMapKeys = downStreamMap.keySet();
                    for (char cMap : bMapKeys) {
                        if (originalMaps.containsKey(cMap)) {
                            int originalCost = originalMaps.get(cMap);
                            int newCost = originalMaps.get(downStreamKey) + downStreamMap.get(cMap);
                            if (newCost < originalCost) {
                                changeWasMade = true;
                                originalMaps.put(cMap, newCost);
                            }
                        } else {
                            changeWasMade = true;
                            int newCost = originalMaps.get(downStreamKey) + downStreamMap.get(cMap);
                            originalMaps.put(cMap, newCost);
                        }
                    }
                }
            }
            if (!changeWasMade) {
                break;
            }
        }

        long minCost = 0;
        for (int i = 0; i < source.length(); i++) {
            char sourceChar = source.charAt(i);
            char targetChar = target.charAt(i);
            if (sourceChar == targetChar) {
                continue;
            } else {
                if (changeCostMap.get(sourceChar).containsKey(targetChar)) {
                    minCost += changeCostMap.get(sourceChar).get(targetChar);
                } else {
                    System.out.println("-1 , missing char = " + targetChar);
                    return -1;
                }
            }
        }

        System.out.println(minCost);
        return minCost;

    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumCost(
                "abcd",
                "acbe",
                new char[]{'a','b','c','c','e','d'},
                new char[]{'b','c','b','e','b','e'},
                new int[]{2,5,5,1,2,20}
        );
//        sol.minimumCost(
//                "aaaa",
//                "bbbb",
//                new char[]{'a','c'},
//                new char[]{'c','b'},
//                new int[]{1,2}
//        );
//        sol.minimumCost(
//                "abcd",
//                "abce",
//                new char[]{'a'},
//                new char[]{'e'},
//                new int[]{10000}
//        );






    }
}