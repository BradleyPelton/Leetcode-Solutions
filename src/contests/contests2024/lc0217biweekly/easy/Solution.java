package contests.contests2024.lc0217biweekly.easy;


import java.util.Arrays;

// Accepted after 3 minutes
// Trivial

class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            System.out.println("0, trivial length");
            return 0;
        }

        int fixedScore = nums[0] + nums[1];
        int left = 2;
        int numOfOperations = 1;
        while (left <= n - 2) {
            if (nums[left] + nums[left + 1] == fixedScore) {
                numOfOperations++;
                left += 2;
            } else {
                break;
            }
        }
        return numOfOperations;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxOperations(
                new int[]{3,2,1,4,5}
        );
        sol.maxOperations(
                new int[]{3,2,6,1,4}
        );



    }
}
