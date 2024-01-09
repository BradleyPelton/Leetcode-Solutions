package contests.contests2023.lc0401biweekly.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 16 minutes
// Kadane's Algorthim

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {

        Map<Character, Integer> valueMap = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            valueMap.put((char)(96 + i), i);
        }

        for (int i = 0; i < chars.length(); i++) {
            valueMap.put(chars.charAt(i), vals[i]);
        }

        int[] valArr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            valArr[i] = valueMap.get(s.charAt(i));
        }

        // Now the problem is just max subarray
        // Famous Algorith: Kadane's Algorithm
        int ans = maxSubArray(valArr);
        if (ans < 0) {
            ans = 0;
        }
        System.out.println("ans = " + ans);
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;

        int max = Integer.MIN_VALUE;
        for(int i=0 ; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumCostSubstring("adaa", "d", new int[]{-1000});
        sol.maximumCostSubstring("abc", "abc", new int[]{-1,-1,-1});
    }
}