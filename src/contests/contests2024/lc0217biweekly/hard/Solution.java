package contests.contests2024.lc0217biweekly.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int maxSelectedElements(int[] nums) {
        int n = nums.length;
        // 10**5, can't sort

        Map<Integer, Integer> occMap = new TreeMap<>();
        for (int val : nums) {
            occMap.put(val, occMap.getOrDefault(val, 0) + 1);
        }

        int globalMax = 0;
        for (int key : occMap.keySet()) {
            if (occMap.containsKey(key - 1)) { // only start at lower bounds
                continue;
            }
            int intervalLeft = key;
            int intervalRight = key;
            int numberOfOperations = 1;

            while (true) {
                while (occMap.containsKey(intervalRight + 1)) {
                    intervalRight++;
                    numberOfOperations++;
                }

            }
        }


        System.out.println(globalMax);
        return globalMax;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxSelectedElements(
                new int[]{2,1,5,1,1}
        );
        sol.maxSelectedElements(
                new int[]{1,4,7,10}
        );
    }
}