package contests.contests2023.lc1223biweekly.mediumtwo;


// First attempt TLE
// Second attempt TLE
// Third attempt TLE
// Fourth attempt Memory Limit Exceeded . Progress haha

class Solution {
    Boolean[][] dp;
    int firstBadIndex;
    public long incremovableSubarrayCount(int[] nums) {


        // Why did I get Memory Limit Exceeded:
        // It seems like we needed to the number of dp state variables from 2 to 1.


        int n = nums.length;
        dp = new Boolean[n][n]; // 10**5 x 10**5 is a massive. Even if I convert it to a byte array. that's still a lot of memory
        // let dp[i][j] = true if nums[i..j] is strictly increasing
        // then nums[a..b] = true if nums[i..j] + {} + nums [u..v]  and nums[j] < nums[u]
        firstBadIndex = n;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                firstBadIndex = i;
                break;
            }
        }

        long numOfSubArrays = 0;
        if (firstBadIndex != n) {
            for (int start = firstBadIndex; start >= 0; start--) {
                for (int end = start; end < n; end++) {
                    if (isIncremovable(nums, start, end)) { // if nums is Incremovable after removing [start..end]
                        numOfSubArrays += (n - end);
                        break;
                    }
                }
            }
        } else {
            numOfSubArrays = (((long)n) * (n + 1)) / 2;
        }
        System.out.println(numOfSubArrays);
        return numOfSubArrays;
    }

    private boolean isIncremovable(int[] nums, int start, int end) {
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        boolean ans = true;
        int previousVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i >= start && i <= end) {
                continue;
            }

            int currVal = nums[i];
            if (previousVal < currVal) {
                previousVal = currVal;
            } else {
                ans = false;
                break;
            }
        }

        if (ans) {
//            for (int endPlus = end; endPlus < nums.length; endPlus++) {
//                dp[start][endPlus] = true;
//            }

            // START BACKWARDS
            for (int i = start - 1; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    dp[i][end] = true;
                } else {
                    break;
                }
            }
        }
        dp[start][end] = ans;
        return ans;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.incremovableSubarrayCount(new int[]{1,2,3,4});
        sol.incremovableSubarrayCount(new int[]{6,5,7,8});
        sol.incremovableSubarrayCount(new int[]{8,7,6,6});





    }
}
