package contests.contests2023.lc1230.easy;

// Accepted after 5 minutes
// Trivial
// Brute forced even though a nice binary solution exists
// First attempt rejected. Missed an index (j = i + 1). sloppy

// POST CONTEST: Cleaned up. One pass, O(n) runtime, O(1) space


class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        boolean firstEvenFound = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (!firstEvenFound) {
                    firstEvenFound = true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.hasTrailingZeros(new int[]{1,2,3,4,5});
        sol.hasTrailingZeros(new int[]{2,4,8,16});
        sol.hasTrailingZeros(new int[]{1,3,5,7,9});
        sol.hasTrailingZeros(new int[]{1,2});





    }
}
