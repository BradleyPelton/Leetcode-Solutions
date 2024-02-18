package contests.contests2024.lc0217biweekly.mediumtwo;

// Accepted first attempt
// Clean DP solution implemented in 13 minutes. Progress.
// Accepted after 13 minutes

class Solution {
    Integer[][] dp;
    int n;
    int[] nums;
    public int maxOperations(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new Integer[n][n];

        int ansLeft = maxOperations(2, n - 1, nums[0] + nums[1]) + 1;
        dp = new Integer[n][n];
        int ansRight = maxOperations(0, n - 3, nums[n - 1] + nums[n - 2]) + 1;
        dp = new Integer[n][n];
        int ansMiddle = maxOperations(1, n - 2, nums[0] + nums[n - 1]) + 1;

        int ans = Math.max(ansMiddle, Math.max(ansLeft, ansRight));
        System.out.println(ans);
        return ans;
    }

    private int maxOperations(int left, int right, int target) {
        if (left >= right) {
            return 0;
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        int currMax = 0;
        if (left + 2 < n && nums[left] + nums[left + 1] == target) {
            int localMax = maxOperations(left + 2, right, target) + 1;
            currMax = Math.max(currMax, localMax);
        }

        if (right - 2 >= left && nums[right] + nums[right - 1] == target) {
            int localMax = maxOperations(left, right - 2, target) + 1;
            currMax = Math.max(currMax, localMax);
        }

        if (nums[left] + nums[right] == target) {
            int localMax = maxOperations(left + 1, right - 1, target) + 1;
            currMax = Math.max(currMax, localMax);
        }

        dp[left][right] = currMax;
        return currMax;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxOperations(new int[]{3,2,1,2,3,4});
        sol.maxOperations(new int[]{3,2,6,1,4});




    }
}
