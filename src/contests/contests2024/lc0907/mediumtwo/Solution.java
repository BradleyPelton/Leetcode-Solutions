package contests.contests2024.lc0907.mediumtwo;

import java.util.List;

// First Attempt : TLE
// Second Attempt : TLE

// Third attempt accepted: Rare moment of insight:
//


// GREEDY: Always jump to the next largest number. DP was probably not needed.
// There are only two choices : Jump to the end or jump to the next largest value.


class Solution {
    Long[] dp;
    List<Integer> nums;
    int n;
    public long findMaximumScore(List<Integer> nums) {
        this.nums = nums;
        n = nums.size();
        dp = new Long[n];

        long ans = topDown(0);
        System.out.println(ans);
        return ans;
    }

    private long topDown(int index) {
        if (dp[index] != null) {
            return dp[index];
        }

        long maxScore = nums.get(index) * (n - 1L - index);
        for (int i = index + 1; i < n; i++) {
            if (nums.get(i) > nums.get(index)) {
                long localScore = topDown(i) + ((i - index + 0L) * nums.get(index));
                maxScore = Math.max(maxScore, localScore);
                break;
            }
        }


        dp[index] = maxScore;
        return maxScore;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findMaximumScore(
                List.of(1,3,1,5)
        );
        sol.findMaximumScore(
                List.of(4,3,1,3,2)
        );




    }
}
