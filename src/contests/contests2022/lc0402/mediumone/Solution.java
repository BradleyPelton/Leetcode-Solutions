package contests.contests2022.lc0402.mediumone;

import java.util.ArrayList;
import java.util.List;

// Accepted after 12 minutes
// Cool problem. I kind of brute forced it. I thought they were looking for the math solution.

class Solution {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) {
            System.out.println("1 edge case");
            return nums[0];
        }

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }

        while (numList.size() > 1) {
            for (int i = 0; i < numList.size() - 1; i++) {
                int sum = (numList.get(i) + numList.get(i+1)) % 10;
                numList.set(i, sum);
            }
            numList.remove(numList.size() - 1);
//            System.out.println(numList);
        }


        System.out.println("final ans = " + numList.get(0));
        return numList.get(0);
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.triangularSum(new int[]{1,2,3,4,5});
        sol.triangularSum(new int[]{5});
    }
}