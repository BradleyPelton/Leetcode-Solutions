package _Study.Problems.lengthOfLongestFibonacciSubSequence;

import java.util.HashMap;
import java.util.Map;


/**
 * 873. Length of Longest Fibonacci Subsequence
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 *
 * Good problem. Just like the longest Arithmetic series question, it seems like a straight forward DP problem.
 * The problem is when the number subsequences start to overlap. We can't just use the cached dp[j] value.
 * We need to cache the Sequence members in a Map.
 *
 */
class Solution {
    // Reminds me of longest arithmetic series question. https://leetcode.com/problems/longest-arithmetic-subsequence/
    public int lenLongestFibSubseq(int[] arr) {
        Map<String, Integer> dp = new HashMap<>();
        Map<Integer, Integer> seenMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            seenMap.put(arr[i], i);
            int primaryNum = arr[i];
            for (int j = 0; j < i; j++) {
                int secondaryNum = arr[j];
                int thirdNum = primaryNum - secondaryNum;
                if (seenMap.containsKey(thirdNum) && seenMap.get(thirdNum) < j) {
                    String dpKey = secondaryNum + "," + thirdNum;
                    String newDpKey = primaryNum + "," + secondaryNum;
                    if (dp.containsKey(dpKey)) {
                        int prevLength = dp.get(dpKey);
                        dp.put(newDpKey, prevLength + 1);
                    } else {
                        dp.put(newDpKey, 3);
                    }
                }
            }
        }

        int maxVal;
        if (dp.values().isEmpty()) {
            maxVal = 0;
        } else {
            maxVal = dp.values().stream().mapToInt(i -> i).max().getAsInt();
            if (maxVal <= 2) {
                maxVal = 0;
            }
        }
        System.out.println(maxVal);
        return maxVal;
    }
}
