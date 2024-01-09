package contests.contests2023.lc0325.easy;


// Accepted first attempt
// Server went down.

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        int maxSum = 0;
        if ( k >= numOnes) {
            maxSum += numOnes;
            k -= numOnes;
        } else {
            maxSum = k;
            k = 0;
        }

        if ( k >= numZeros) {
            k -= numZeros;
        } else {
            k = 0;
        }

        if (k > 0) {
            maxSum -= k;
            k = 0;
        }

        System.out.println("ans = " + maxSum);
        return maxSum;

    }
}


class tests {
    public static void main(String... arg) {
        Solution sol = new Solution();
        sol.kItemsWithMaximumSum(3,2,0,2);
        sol.kItemsWithMaximumSum(3,2,0,4);


    }
}
