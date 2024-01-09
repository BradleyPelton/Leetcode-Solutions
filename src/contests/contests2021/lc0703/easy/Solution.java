package contests.contests2021.lc0703.easy;

// Accepted after 4 minutes
// Accepted first try

// trivial

class Solution {
    public int[] buildArray(int[] nums) {


        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
//            int val = nums[i];
//            ans[val] = i;
            ans[i] = nums[nums[i]];
        }

//        System.out.println(Arrays.toString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.buildArray(new int[]{0,2,1,5,3,4});
        sol.buildArray(new int[]{5,0,1,2,3,4});
    }
}