package contests.contests2024.lc1012biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// Accepted first attempt
// Accepted after 30 minutes (stared at problem 2 for a few minutes)

// Cool DP problem. I could optimize this one much further. Index map was never used.

class Solution {
    String source;
    String pattern;
    int[] targetIndices;
    int sourceLength;
    int patternLength;
    Map<Character, List<Integer>> indexMap;
    boolean[] isTarget;
    Integer[][] dp;
    int[] remainingTargets;
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        this.source = source;
        this.pattern = pattern;
        this.targetIndices = targetIndices;
        sourceLength = source.length();
        patternLength = pattern.length();
        indexMap = new HashMap<>();
        dp = new Integer[sourceLength][patternLength];

        for (char c = 'a'; c <= 'z'; c++) {
            indexMap.put(c, new ArrayList<>());
        }

        isTarget = new boolean[sourceLength];
        for (int val : targetIndices) {
            isTarget[val] = true;
        }

        remainingTargets = new int[sourceLength];
        int numberOfRemainingTargets = targetIndices.length;
        for (int i = 0; i < sourceLength; i++) {
            indexMap.get(source.charAt(i)).add(i);
            remainingTargets[i] = numberOfRemainingTargets;
            if (isTarget[i]) {
                numberOfRemainingTargets--;
            }
        }

        int ans = topDown(0, 0);
        System.out.println(ans);
        return ans;
    }

    private int topDown(int sourceIndex, int patternIndex) {
        if (patternIndex >= patternLength) { // WE ARE DONE
            if (sourceIndex >= sourceLength) {
                return 0;
            }
            return remainingTargets[sourceIndex]; // COUNT THE REMAINING target indices
        }
        if (sourceIndex >= sourceLength) { // IMPOSSIBLE
            return Integer.MIN_VALUE;
        }

        if (dp[sourceIndex][patternIndex] != null) {
            return dp[sourceIndex][patternIndex];
        }

        int removeSolution = Integer.MIN_VALUE;
        if (isTarget[sourceIndex]) {
            int localSolution = topDown(sourceIndex + 1, patternIndex);
            if (localSolution != Integer.MIN_VALUE) {
                localSolution += 1;
            }
            removeSolution = localSolution;
        }

        int doNotRemoveSolution;
        if (source.charAt(sourceIndex) == pattern.charAt(patternIndex)) {
            doNotRemoveSolution = topDown(sourceIndex + 1, patternIndex + 1);
        } else {
            doNotRemoveSolution = topDown(sourceIndex + 1, patternIndex);
        }

        int ans = Math.max(removeSolution, doNotRemoveSolution);
        dp[sourceIndex][patternIndex] = ans;
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxRemovals(
                "abbaa",
                "aba",
                new int[]{0,1,2}
        ); // 1
        sol.maxRemovals(
                "bcda",
                "d",
                new int[]{0,3}
        ); // 2
        sol.maxRemovals(
                "dda",
                "dda",
                new int[]{0,1,2}
        ); // 0
        sol.maxRemovals(
                "yeyeykyded",
                "yeyyd",
                new int[]{0,2,3,4}
        ); // 2




    }
}
