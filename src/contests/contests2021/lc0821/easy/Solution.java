package contests.contests2021.lc0821.easy;

import java.util.Arrays;

// Accepted after second attempt
// Accepted after 9 minutes

// COnfused GCD and LCM. You would be shocked to know I was a math major

class Solution {
    public int findGCD(int[] nums) {

        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int gcd = 1;
        for (int i = minVal; i > 0; i--) {
            if (minVal % i == 0 && maxVal % i == 0) {
                gcd = i;
                break;
            }
        }

        int ans = gcd;
        System.out.println("final ans " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.findGCD(new int[]{2,5,6,9,10});
        sol.findGCD(new int[]{7,5,6,8,3});
        sol.findGCD(new int[]{3,3});
        sol.findGCD(new int[]{6,10,5,5});  // expected 5
    }
}
