package contests.contests2022.lc0430.mediumtwo;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {

        // sliding window
//        StringBuilder sb = new StringBuilder();

        HashSet<String> uniqueAnswers = new HashSet<>();


        for (int startingIndex = 0; startingIndex < nums.length; startingIndex++) {
            ArrayList<Integer> currArr = new ArrayList<>();
            int currDivisibleCount = 0;

            // Add all arrays that start at startingIndex
            for (int i = startingIndex; i < nums.length; i++) {
                int nextVal = nums[i];
                currArr.add(nextVal);
                if (nextVal % p == 0) {
                    currDivisibleCount++;
                }

                if (currDivisibleCount > k) {
                    break;
                }

                String arrayAsString = currArr.toString();
//                System.out.println(arrayAsString);
                uniqueAnswers.add(arrayAsString);
            }
        }

        int ans = uniqueAnswers.size();
        System.out.println("final ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countDistinct(new int[]{2,3,3,2,2}, 2, 2);
        sol.countDistinct(new int[]{1,2,3,4}, 4, 1);
    }
}