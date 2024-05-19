package contests.contests2024.lc0518.easy;

// Accepted after 3 minutes
// trivial

class Solution {
    public boolean isArraySpecial(int[] nums) {

        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev % 2 == nums[i] % 2) {
                System.out.println("false");
                return false;
            }
            prev = nums[i];
        }
        System.out.println(true);
        return true;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isArraySpecial(
                new int[]{1}
        );
        sol.isArraySpecial(
                new int[]{2,1,4}
        );
        sol.isArraySpecial(
                new int[]{4,3,1,6}
        );




    }
}