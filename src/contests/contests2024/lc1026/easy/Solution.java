package contests.contests2024.lc1026.easy;

// Accepted after 12 minutes
// First attempt: wrong answer (misread question)

// NOTE: NO easy question, just two mediums.
// Cool math problem, both GCD and LCM. Find the optimization


class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;

        if (nums.length == 1) {
            System.out.println(nums[0] * nums[0]);
            return nums[0] * nums[0];
        }

        long maxFactorScore = Long.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            long gcd;
            long lcm;
            if (i == 0) {
                gcd = nums[1];
                lcm = nums[1];
                for (int j = 2; j < n; j++) {
                    if (j != i) {
                        gcd = gcdByEuclidsAlgorithm(gcd, nums[j]);
                        lcm = getLCM(lcm, nums[j]);
                    }
                }
            } else {
                gcd = nums[0];
                lcm = nums[0];
                for (int j = 1; j < n; j++) {
                    if (j != i) {
                        gcd = gcdByEuclidsAlgorithm(gcd, nums[j]);
                        lcm = getLCM(lcm, nums[j]);
                    }
                }
            }


            long localFactorScore = gcd * lcm;
            maxFactorScore = Math.max(maxFactorScore, localFactorScore);
        }

        System.out.println(maxFactorScore);
        return maxFactorScore;
    }


    public long getLCM(long a, long b) {
        if (a == 0 || b == 0)
            return 0;
        else {
            long gcdVal = gcdByEuclidsAlgorithm(a, b);
            return Math.abs(a * b) / gcdVal;
        }
    }

    public static long gcdByEuclidsAlgorithm(long n1, long n2) {
        // the complexity of Euclid’s algorithm is O(Log min(n1, n2))
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxScore(new int[]{2,4,8,16});
        sol.maxScore(new int[]{1,2,3,4,5});
        sol.maxScore(new int[]{3});
        sol.maxScore(new int[]{6,14,20}); // 840



    }
}
