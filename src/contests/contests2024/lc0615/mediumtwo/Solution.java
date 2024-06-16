package contests.contests2024.lc0615.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// First attempt TLE
// Second attempt accepted

// Accepted after 27 minutes
// had to apply an optimization to my original DP solution.

class Solution {
    int n;
    int[] power;
    Long[] dp;
    Map<Integer, Integer> lastOcc;
    public long maximumTotalDamage(int[] power) {
        this.power = power;
        this.n = power.length;
        Arrays.sort(this.power);
        dp = new Long[n];
        lastOcc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastOcc.put(power[i], i);
        }

        long ans = topDown(0);
        System.out.println(ans);
        return ans;
    }

    private long topDown(int index) {
        if (index >= n) {
            return 0L;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        // DO NOTHING
        long ans = topDown(index + 1);

        // Accept current
        int originalPower = power[index];
        int lastOccOfOriginal = lastOcc.get(originalPower);

        int nextIndex = -5;
        if (lastOcc.containsKey(originalPower + 2)) {
            nextIndex = lastOcc.get(originalPower + 2) + 1;
        } else if (lastOcc.containsKey(originalPower + 1)) {
            nextIndex = lastOcc.get(originalPower + 1) + 1;
        } else {
            nextIndex = lastOccOfOriginal + 1;
        }

        long addition = (lastOccOfOriginal - index + 1L) * originalPower
                + topDown(nextIndex);

        ans = Math.max(ans, addition);
        dp[index] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumTotalDamage(
                new int[]{1,1,3,4}
        ); // 6
        sol.maximumTotalDamage(
                new int[]{7,1,6,6}
        ); // 13





    }
}
