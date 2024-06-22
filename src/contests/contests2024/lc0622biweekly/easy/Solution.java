package contests.contests2024.lc0622biweekly.easy;

// Accepted after 1 minute
// Trivial

class Solution {
    public int minimumOperations(int[] nums) {

        int ans = 0;
        for (int num : nums) {
            if (num % 3 == 0) {
                continue;
            } else {
                ans++;
            }
        }
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumOperations(
                new int[]{1,2,3,4}
        );
        sol.minimumOperations(
                new int[]{3,6,9}
        );



    }
}
