package contests.contests2021.lc1030.easy;

// Accepted after 3 minutes, trivial

class Solution {
    public int smallestEqual(int[] nums) {

        int ans  = -1;

        for (int i = 0; i < nums.length; i++) {
            int indexMod = i % 10;

            if (indexMod == nums[i]) {
                System.out.println("found a sol, i = " + i);
                return i;
            }
        }
        System.out.println("no ans");
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.smallestEqual(new int[]{0,1,2});
        sol.smallestEqual(new int[]{4,3,2,1});
        sol.smallestEqual(new int[]{1,2,3,4,5,6,7,8,9,0});
        sol.smallestEqual(new int[]{2,1,3,5,2});







    }
}