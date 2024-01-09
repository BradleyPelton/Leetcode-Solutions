package contests.contests2021.lc0710.easy;

// Accepted first try
// Accepted after 4 minutes

// Trivial

class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] ans = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }


//        System.out.println(Arrays.toString(ans));

        return ans;



    }

}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.getConcatenation(new int[]{1,2,1});
        sol.getConcatenation(new int[]{1,3,2,1});
    }
}