package contests.contests2024.lc0210.hard;

import java.util.ArrayDeque;

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;

        int[] patternValue = new int[n];
        patternValue[0] = Integer.MIN_VALUE;
        int previousValue = nums[0];
        for (int i = 1; i < n; i++) {
            int currValue = nums[i];
            if (previousValue == currValue) {
                patternValue[i] = 0;
            } else if (previousValue < currValue) {
                patternValue[i] = 1;
            } else {
                patternValue[i] = -1;
            }
            previousValue = currValue;
        }

        int numberOfGoodSubarrays = 0;
        int[] dp = new int[n]; // longest pattern string that ends
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] == 0) { // first element
                if (patternValue[i] == pattern[0]) {
                    dp[i] = 1;
                }
            } else {
                int currIndex = dp[i - 1];
                if (currIndex < pattern.length) {
                    if (patternValue[i] == pattern[currIndex + 1]) {
                        dp[i] = dp[i - 1] + 1;
                    } else {
                        for (int j = 0; i + j < n && j < pattern.length; j++) {
                            if (patternValue[i + j] == pattern[j]) {
                                dp[i]++;
                            } else {
                                break;
                            }
                        }
                    }
                } else {
                    for (int j = 0; i + j < n && j < pattern.length; j++) {
                        if (patternValue[i + j] == pattern[j]) {
                            dp[i]++;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (dp[i] == pattern.length) {
                numberOfGoodSubarrays++;
            }
        }

        System.out.println(numberOfGoodSubarrays);
        return numberOfGoodSubarrays;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.countMatchingSubarrays(
//                new int[]{1,2,3,4,5,6},
//                new int[]{1,1}
//        );
        sol.countMatchingSubarrays(
                new int[]{1,4,4,1,3,5,5,3},
                new int[]{1,0,-1}
        );
    }
}