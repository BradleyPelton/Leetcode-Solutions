package contests.contests2024.lc0824.mediumtwo;

import java.util.Arrays;

class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int originalNum = nums[i];
            for (int j = i + 1; j < n; j++) {
                int secondNum = nums[j];
                if (isAlmostEqual(originalNum, secondNum)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    private boolean isAlmostEqual(int valOne, int valTwo) {
        if (valOne == valTwo) {
            return true;
        }

        String valOneAsString = String.valueOf(valOne);
        String valTwoAsString = String.valueOf(valTwo);

        if (valOneAsString.length() < valTwoAsString.length()) {

        }

        return false;



    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();




    }
}