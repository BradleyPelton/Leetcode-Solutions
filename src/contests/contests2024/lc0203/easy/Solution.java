package contests.contests2024.lc0203.easy;


// Accepted after 2 minutes
// Trivial.

class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int currPos = 0;
        int ans = 0;
        for(int val : nums) {
            currPos += val;

            if (currPos == 0) {
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
        sol.returnToBoundaryCount(
                new int[]{2,3,-5}
        );
        sol.returnToBoundaryCount(
                new int[]{3,2,-3,-4}
        );
    }
}