package contests.contests2024.lc0810.hardtwo;

// First attempt TLE (tried reusing hardone solution)



class Solution {
    int[] nums;
    int n;
    final long rem = 1_000_000_007L;
    Integer[][][] dp;
    public int countOfPairs(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dp = new Integer[n][51][51];

        int ans = topDown(0, 0, Integer.MAX_VALUE);
        System.out.println(ans);
        return ans;
    }

    public int topDown(int index, int previousNonDecreasing, int previousNonIncreasing) {
        if (index >= n) {
            return 1;
        }

        if (index != 0 && dp[index][previousNonDecreasing][previousNonDecreasing] != null) {
            return dp[index][previousNonDecreasing][previousNonDecreasing];
        }

        int val = nums[index];

        int ans = 0;
        boolean seenAValue = false;
        for (int i = previousNonDecreasing; i <= val; i++) {
            int complement = val - i;
            if (seenAValue && complement > previousNonIncreasing) {
//                continue;
                 break;
            }
            seenAValue = true;

            int localAns = topDown(index + 1, i, complement);
            ans = (int)((ans + localAns) % rem);
        }

        dp[index][previousNonDecreasing][previousNonDecreasing] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countOfPairs(
                new int[]{2,3,2}
        ); // 4
        sol.countOfPairs(
                new int[]{5,5,5,5}
        ); // 126
//        sol.countOfPairs(
//                new int[]{9,5,34,2,30,49,44,45,46,8}
//        ); // unknown




    }
}
