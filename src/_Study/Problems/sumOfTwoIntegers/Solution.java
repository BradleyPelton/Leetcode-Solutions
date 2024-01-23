package _Study.Problems.sumOfTwoIntegers;


/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/description
 *
 */
class Solution {
    public int getSum(int a, int b) { // Bit Manipulation - 100% runtime, 24% memory

        // NOTE: Java uses two's complement for negative numbers.
        // The basic rule is to take the positive, invert all bits then add one.
        if (a < 0 && b < 0) {
            int trueNegationOfA = getSum(~a, 1); // ~-7 is 6. We need to add the 1 back in
            int trueNegativeOfB = getSum(~b, 1);
            return getSum(~getSum(trueNegationOfA, trueNegativeOfB), 1);
        }

        boolean remainder = false;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            boolean aBit = (a & (1 << i)) != 0;
            boolean bBit = (b & (1 << i)) != 0;

            if (remainder) {
                if (aBit && bBit) { // all 3
                    ans = (ans | (1 << i));
                    // remainder stays true
                } else if (aBit || bBit) { // 2
                    // remainder stays true
                } else {
                    ans = (ans | (1 << i));
                    remainder = false;
                }
            } else {
                if (aBit && bBit) { // 2
                    remainder = true;
                } else if (aBit || bBit) { // 1
                    ans = (ans | (1 << i));
                    // remainder stays false
                } else {
                    // remainder stays false
                }
            }
        }
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.getSum(1,2);
//        sol.getSum(2,3);
        sol.getSum(-12,-8);
//        sol.getSum(-9,14);
//        sol.getSum(-7,0);
    }
}