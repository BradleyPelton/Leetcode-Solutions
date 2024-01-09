package contests.contests2023.lc0715.easy;

// Accepted after 3 minutes
// Trivial

class Solution {
    public int sumOfSquares(int[] nums) {

        int n = nums.length;
        int squareSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (n % (i + 1) == 0) {
                squareSum += (int) Math.pow(nums[i], 2);
            }
        }

        System.out.println("ans = " + squareSum);
        return squareSum;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sumOfSquares(new int[]{1,2,3,4});
        sol.sumOfSquares(new int[]{2,7,1,19,18,3});







    }
}
