package contests.contests2024.lc0224.easy;

import java.util.HashMap;
import java.util.Map;

// Accepted after 4 minutes
// Trivial

class Solution {
    public boolean isPossibleToSplit(int[] nums) {

        Map<Integer, Integer> occMap = new HashMap<>();
        for (int val : nums) {
            occMap.put(val, occMap.getOrDefault(val, 0) + 1);
        }


        int num1Length = 0;
        int num2Length = 0;
        for (int key : occMap.keySet()) {
            int occ = occMap.get(key);
            if (occ > 2) {
                System.out.println(false);
                return false;
            } else if (occ == 2) {
                num2Length++;
                num1Length++;
            } else {
                if (num1Length > num2Length) {
                    num2Length++;
                } else {
                    num1Length++;
                }
            }
        }

        boolean ans = num1Length == num2Length;
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isPossibleToSplit(
                new int[]{1,1,2,2,3,4}
        );
        sol.isPossibleToSplit(
                new int[]{1,1,1,1}
        );



    }
}
