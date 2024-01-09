package contests.contests2023.lc1028.mediumtwo;

class Solution {
    int[][] dp;
    public long minIncrementOperations(int[] nums, int k) {

        // Theory: it suffices to just make the condition true for all subarrays of length 3
        // Proof: Any subarray of length 4 or greater necessary contains a subarray of length 3, thus satisfying condition.

        // min for nums
        // dp[i..j] = Math.min(d[i+1,] , dp[i+2,] , d[[i+3,])
        // Give a man a hammer, Everything is a nail...
        // It almost seems like there is overlapping subproblems here. Fixing one subarray could fix another


        dp = new int[nums.length][nums.length];
        // let dp[i][j] represent the minimum cost it takes to fix the array nums[i..j]
        // base case: if len() < 3, then trivial fix the highest one
        // recurrence relation: dp[i][j]
        //                      = Math.min(

//        dp[i][j] = Math.min(
//                dp[i + 2][j] + (k - nums[i]),
//        )

//        dp = new int[nums.length];
        minFix(nums, 0, nums.length - 1, k);

        int ans = dp[0][dp.length-1];
        return ans;
    }

    private int minFix(int[] nums, int leftIndex, int rightIndex, int k) {
        // base case:
        if (leftIndex > nums.length - 1) {
            return 0;
        } else if (leftIndex == nums.length - 2) { // length 2
            int leftVal = Math.max(0, k - nums[leftIndex]);
            int rightVal = Math.max(0, k - nums[leftIndex + 1]);
            return Math.min(leftVal, rightVal);
        } else if (leftIndex == nums.length - 1) { // length 1
            int val = Math.max(0, k - nums[leftIndex]);
            return val;
        }



        // dp[i] = min number of fixes to fix to the right?

        int self = minFix(nums, leftIndex + 3, rightIndex, k)        + (Math.max(0, k - nums[leftIndex]));     // fix index
        int selfPlusOne, selfPlusTwo;
        try {
            selfPlusOne = minFix(nums, leftIndex + 4, rightIndex, k) + (Math.max(0, k - nums[leftIndex + 1])); // fix index + 1
        } catch (ArrayIndexOutOfBoundsException e) {
            selfPlusOne = Integer.MAX_VALUE;
        }
        try {
            selfPlusTwo = minFix(nums, leftIndex + 5, rightIndex, k) + (Math.max(0, k - nums[leftIndex + 2])); // fix index + 2
        } catch (ArrayIndexOutOfBoundsException e) {
            selfPlusTwo = Integer.MAX_VALUE;
        }

        dp[leftIndex][rightIndex] = Math.min(Math.min(self, selfPlusOne),selfPlusTwo);
        return dp[leftIndex][rightIndex];


    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minIncrementOperations(new int[]{2,3,0,0,2}, 4));
        System.out.println(sol.minIncrementOperations(new int[]{0,1,3,3}, 5));
        System.out.println(sol.minIncrementOperations(new int[]{1,1,2}, 1));
        System.out.println(sol.minIncrementOperations(new int[]{0,5,5}, 8));
    }
}