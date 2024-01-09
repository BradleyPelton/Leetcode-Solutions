package _Study.Problems.maximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1235. Maximum Profit in Job Scheduling
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/description
 *
 *
 *
 */
class Solution {
    int n;
    int[][] jobs;
    int[] startTime;
    Integer[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        dp = new Integer[n];
        jobs = new int[startTime.length][3];
        this.startTime = startTime;
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(startTime);

        int ans = jobScheduling(0);
        System.out.println(ans);
        return ans;
    }

    private int jobScheduling(int jobIndex) {
        if (jobIndex >= n) {
            return 0;
        }

        if (dp[jobIndex] != null) {
            return dp[jobIndex];
        }

        int doNothing = jobScheduling(jobIndex + 1);

        int pos = Arrays.binarySearch(startTime, jobs[jobIndex][1]);
        if (pos < 0) {
            pos = -pos - 1;
        }
        while (pos > 0 && pos < n && startTime[pos] == startTime[pos - 1]) { // shift left if same start time
            pos--;
        }
        int acceptCurrentJobMax = jobScheduling(pos) + jobs[jobIndex][2];

        int ans = Math.max(doNothing, acceptCurrentJobMax);
        dp[jobIndex] = ans;
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.jobScheduling(
                new int[]{1,2,3,3},
                new int[]{3,4,5,6},
                new int[]{50,10,40,70}
        );
        sol.jobScheduling(
                new int[]{1,2,3,4,6},
                new int[]{3,5,10,6,9},
                new int[]{20,20,100,70,60}
        );
        sol.jobScheduling(
                new int[]{1,1,1},
                new int[]{2,3,4},
                new int[]{5,6,4}
        );
        sol.jobScheduling(
                new int[]{4,2,4,8,2},
                new int[]{5,5,5,10,8},
                new int[]{1,2,8,10,4}
        ); // 18
    }
}
