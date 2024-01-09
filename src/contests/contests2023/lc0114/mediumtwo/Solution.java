package contests.contests2023.lc0114.mediumtwo;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {

        Map<Integer, Integer> occMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int currentNumberOfGoodArrays = 0;
        while (true) {
            if (currentNumberOfGoodArrays < k) {
                if (right > nums.length - 1) {
                    break;
                } else {
                    right++;
                }
            }

        }
        return -42L;
    }

    private long getNumberOfGoodArraysFromOccMap(Map<Integer, Integer> occMap) {

        long numberOfGoodArrays = 0;
        for (int key : occMap.keySet()) {
            long occ = occMap.get(key);
            numberOfGoodArrays += (occ) * (occ+1) / 2;
        }

        return -42L;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countGood(new int[]{1,1,1,1,1},
                10
        );
        sol.countGood(new int[]{3,1,4,3,2,2,4},
                2
        );
    }
}