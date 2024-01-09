package contests.contests2023.lc0218.mediumone;

import java.util.List;

// Really, really cool problem
// Accepted after second attempt
// Accepted after 30 minutes

class Solution {
    public int minOperations(int n) {

        List<Integer> powersOfTwo = List.of(
                1, 2, 4, 8, 16, 32, 64 ,128, 256, 512, 1024, 2048, 4096, 8192,  16384, 32768, 65536
        );

        // Find nearest power of 2 (up or down)
        // Count number of steps to

        int nearestPowerOfTwo = -42;
        int minDistance = Integer.MAX_VALUE;
        for(int powOfTwo : powersOfTwo) {
            int diff = Math.abs(powOfTwo - n);
            if (minDistance > diff) {
                minDistance = diff;
                nearestPowerOfTwo = powOfTwo;
            }
        }

        int numberOfSteps = 1;
        while (n != nearestPowerOfTwo) {
            numberOfSteps++;
            // n  = 39, nearestPowerOfTwo = 32


            // Find the powerOfTwo that (add||subtract) gets us closest to nearestPowerOfTwo
            int minimumDiff = Integer.MAX_VALUE;
            int addVal = 0;
            for(int powerOfTwo : powersOfTwo) {

                int negativeDiff = Math.abs(nearestPowerOfTwo - (n - powerOfTwo));
                if (negativeDiff < minimumDiff) {
                    minimumDiff = negativeDiff;
                    addVal = -powerOfTwo;
                }

                int positiveDiff = Math.abs(nearestPowerOfTwo - (n + powerOfTwo));
                if (positiveDiff < minimumDiff) {
                    minimumDiff = positiveDiff;
                    addVal = powerOfTwo;
                }
            }

            n += addVal;
        }

        System.out.println("ans = " + numberOfSteps);
        return numberOfSteps;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(39);    // 3
        sol.minOperations(54);    // 3
        sol.minOperations(1754);  // 5
    }
}