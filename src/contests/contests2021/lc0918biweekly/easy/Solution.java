package contests.contests2021.lc0918biweekly.easy;

// Accepted first try
// Accepted after 3 minutes
// trivial

class Solution {
    public int countKDifference(int[] nums, int k) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int val = Math.abs(nums[i] - nums[j]);
                if (val == k) {
                    ans++;
                }
            }
        }


        System.out.println("final ans is " + ans);
        return ans;



    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countKDifference(new int[]{1,2,2,1}, 1);
        sol.countKDifference(new int[]{1,3}, 3);
        sol.countKDifference(new int[]{3,2,1,5,4}, 2);


    }
}
