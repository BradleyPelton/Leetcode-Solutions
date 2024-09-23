package contests.contests2024.lc0907.mediumone;

import java.util.Arrays;

class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);

        int[] originalValues = Arrays.copyOfRange(start, 0, start.length);

        // closest two intervals?
        int n = start.length;
        int ans = Integer.MAX_VALUE;

        start[0] = Math.max(start[0], 0);
        start[n - 1] = start[n - 1] + d;
        if (start.length == 2) {
            ans = start[1] - start[0];
            System.out.println(ans);
            return ans;
        }


        // 0, 6, 13, 18
        for (int i = 1; i < n - 1 ; i++) {
            int prev = start[i - 1];
            int curr = start[i];
            int next = start[i + 1];

            int idealCurr = (next + prev) / 2;

            idealCurr = Math.max(idealCurr,originalValues[i]);
            idealCurr = Math.min(idealCurr,originalValues[i] + d);

            start[i] = idealCurr;
        }

        for (int i = 1; i < n; i++) {
            int localAns = Math.abs(start[i] - start[i -1]);
            ans = Math.min(ans, localAns);
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxPossibleScore(
                new int[]{6,0,3},
                2
        );
        sol.maxPossibleScore(
                new int[]{2,6,13,13},
                5
        );
        sol.maxPossibleScore(
                new int[]{1000000000,1000000000},
                1000000000
        );




    }
}
