package contests.contests2024.lc0720biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First attempt wrong answer
// Second attempt wrong answer

class Solution {
    public int minChanges(int[] nums, int k) {

        Map<Integer, Integer> diffFrequency = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int left = nums[i];
            int right = nums[n - i - 1];
            int diff = Math.abs(right - left);
            int currDiffFreq = diffFrequency.getOrDefault(diff, 0);
            currDiffFreq++;
            diffFrequency.put(diff, currDiffFreq);
        }

        int ans = n - 1;
        for (int targetDiff : diffFrequency.keySet()) {
            int localAns = 0;
            for (int i = 0; i < n / 2; i++) {
                int left = nums[i];
                int right = nums[n - i - 1];
                int currDiff = Math.abs(right - left);
                if (currDiff == targetDiff) {
                    continue;
                }

                // Set left
                int leftUnder = right - targetDiff;
                int leftOver = right + targetDiff;

                int rightUnder = left - targetDiff;
                int rightOver = left + targetDiff;

                if (leftUnder >= 0 && leftUnder <= k) {
                    localAns++;
                } else if (leftOver >= 0 && leftOver <= k) {
                    localAns++;
                } else if (rightUnder >= 0 && rightUnder <= k) {
                    localAns++;
                } else if (rightOver >= 0 && rightOver <= k) {
                    localAns++;
                } else {
                    localAns += 2; // we have to set both
                }
            }

            ans = Math.min(ans, localAns);
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minChanges(
                new int[]{1,0,1,2,4,3},
                4
        ); // 2
        sol.minChanges(
                new int[]{0,1,2,3,3,6,5,4},
                6
        ); // 2

        sol.minChanges(
                new int[]{1,10,5,1,4,6,4,2,4,9,7,9,0,11},
                12
        ); // 5

        sol.minChanges(
                new int[]{1,1,1,1,0,0,0,5,4,3,19,17,16,15,15,15,19,19,19,19},
                20
        ); // 7







    }
}