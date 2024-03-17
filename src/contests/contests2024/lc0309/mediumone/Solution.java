package contests.contests2024.lc0309.mediumone;

import java.util.Arrays;

// First attempt wrong answer (long not int)
// Second attempt accepted
// accepted after 9 minutes

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        Arrays.sort(happiness);
        long sum = 0;
        for (int turn = 0; turn < k && turn < n; turn++) {
            long currVal = happiness[n - 1 - turn] - turn;
            if (currVal <= 0) {
                break;
            }
            sum += currVal;
        }
        System.out.println(sum);
        return sum;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumHappinessSum(
                new int[]{1,2,3},
                2
        );
        sol.maximumHappinessSum(
                new int[]{1,1,1,1},
                2
        );
        sol.maximumHappinessSum(
                new int[]{2,3,4,5},
                1
        );
    }
}
