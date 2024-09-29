package contests.contests2024.lc0928biweekly.easy;

// Accepted after 2 minutes
// Accepted first try

// trivial. I still need to memorize digit sum optimized.

class Solution {
    public int minElement(int[] nums) {

        int ans = Integer.MAX_VALUE;
        for (int val : nums) {
            int localSum = digitSum(val);
            ans = Math.min(ans, localSum);
        }

        System.out.println(ans);
        return ans;
    }

    private int digitSum(int val) {
        int sum = 0;
        while (val > 0) { // more efficient digit sum
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minElement(
                new int[]{10,12,13,14}
        );
        sol.minElement(
                new int[]{1,2,3,4}
        );
        sol.minElement(
                new int[]{999,19,199}
        );



    }
}
