package contests.contests2024.lc0622.mediumtwo;

// First Attempt TLE
// Second attempt Accepted.
// Very cool DP problem. I had to think of a clever optimization.
// Instead of looping through all indices to the right, you only need to consider index + 1 or index + 2

class Solution {
    int[] nums;
    int n;

    Long[] dp;
    public long maximumTotalCost(int[] nums) {
        this.nums = nums;
        n = nums.length;

        dp = new Long[n];

        long ans = recurse(0);
        System.out.println(ans);
        return ans;


        // There's no difference between
        // [0..1] + [2..3] and [0..3]

        // 1,-2,3,4
    }

    private long recurse(int index) {
        if (index >= n) {
            return 0L;
        }

        if (index == n - 1) {
            return nums[n - 1];
        }

        if (dp[index] != null) {
            return dp[index];
        }

        // EITHER ACCEPT NEXT OR REJECT

        long accept = nums[index] - nums[index + 1] + recurse(index + 2);
        long deny = nums[index] + recurse(index + 1);
        long ans = Math.max(accept, deny);
//        long currSum = 0L;
//        boolean isPositive = true;
//        for (int i = index; i < n; i++) {
//            if (isPositive) {
//                currSum += nums[i];
//            } else {
//                currSum -= nums[i];
//            }
//            isPositive = !isPositive;
//
//            long localAns = currSum + recurse(i + 1);
//            ans = Math.max(ans, localAns);
//        }

        dp[index] = ans;
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumTotalCost(
                new int[]{1,-2,3,4}
        );
        sol.maximumTotalCost(
                new int[]{1,-1,1,-1}
        );
        sol.maximumTotalCost(
                new int[]{0}
        );
        sol.maximumTotalCost(
                new int[]{1,-1}
        );




    }
}
