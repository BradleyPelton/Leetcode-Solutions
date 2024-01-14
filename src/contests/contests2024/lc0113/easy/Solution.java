package contests.contests2024.lc0113.easy;

import java.util.HashMap;
import java.util.Map;


// Accepted after 4 minutes
// Trivial

class Solution {
    public int maxFrequencyElements(int[] nums) {

        Map<Integer, Integer> occMap = new HashMap<>();
        for (int val : nums) {
            occMap.put(val, occMap.getOrDefault(val, 0) + 1);
        }

        int maxFreq = 0;
        for (int val : occMap.values()) {
            maxFreq = Math.max(maxFreq, val);
        }

        int sum = 0;
        for (int key : occMap.keySet()) {
            if (occMap.get(key) == maxFreq) {
                sum += maxFreq;
            }
        }
        System.out.println(sum);
        return sum;
    }
}







class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxFrequencyElements(new int[]{1,2,2,3,1,4});
        sol.maxFrequencyElements(new int[]{1,2,3,4,5});







    }
}