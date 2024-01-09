package contests.contests2023.lc0603.mediumone;

// Accepted after 8 minutes
// Trivial easy problem. Two easy problems this week.

class Solution {
    public int semiOrderedPermutation(int[] nums) {


        int n = nums.length;
        int indexOfOne = 0;
        int indexOfN  = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                indexOfOne = i;
            } else if (nums[i] == n) {
                indexOfN = i;
            }
        }

        int numberOfOneMoves = indexOfOne;
        int numberOfNMoves = n - 1 - indexOfN;

        int ans = numberOfOneMoves + numberOfNMoves;

        if (indexOfN < indexOfOne) {
            ans--;
        }

        System.out.println("ans = " + ans);
        return ans;


    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.semiOrderedPermutation(new int[]{2,1,4,3});
        sol.semiOrderedPermutation(new int[]{2,4,1,3});
        sol.semiOrderedPermutation(new int[]{1,3,4,2,5});
    }
}