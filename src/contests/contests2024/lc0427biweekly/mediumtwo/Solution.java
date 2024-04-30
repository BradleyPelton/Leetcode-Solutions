package contests.contests2024.lc0427biweekly.mediumtwo;


// First Attempt TLE


class Solution {
    final long rem = 1_000_000_007L;
    Integer[][] dp;
    public int numberOfStableArrays(int zero, int one, int limit) {
        if (zero > one) {
            return numberOfStableArrays(one, zero, limit);
        }
        // Distribute the zeroes amongst the ones

        dp = new Integer[zero + 1][one + 1];

        int ans = 0;
        for (int numberOfZeroes = 0; numberOfZeroes < Math.max(zero, limit); numberOfZeroes++) {
            int localAns = distribute(zero - numberOfZeroes, one - 1, limit);
            ans = (int) ((ans + localAns) % rem);

        }
        System.out.println(ans);
        return ans;
    }

    private int distribute(int zero, int one, int limit) {
        if (zero == 0) {
            if (one <= limit) {
                return 1;
            } else {
                return Integer.MIN_VALUE;
            }
        }


        if (dp[zero][one] != null) {
            return dp[zero][one];
        }

        int ans = 0;
        for (int numberOfOnesToSkip = 0; numberOfOnesToSkip <= Math.min(one, limit); numberOfOnesToSkip++) {
            int localAns = distribute(zero - 1, one - numberOfOnesToSkip, limit);
            if (localAns != Integer.MIN_VALUE) {
                ans = (int) ((ans + localAns) % rem);
            }
        }

        dp[zero][one] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfStableArrays(1, 1, 2); // 2
        sol.numberOfStableArrays(1, 2, 1); // 1
        sol.numberOfStableArrays(3, 3, 2); // 14




    }
}
