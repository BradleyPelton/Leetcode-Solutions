package contests.contests2021.lc0925.easy;

// Accepted after 3 minutes
// Trivial

class Solution {
    public int maximumDifference(int[] nums) {


        int maxDiff = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {

                if (nums[i] < nums[j]) {
                    int diff = nums[j] - nums[i];

                    if (diff > maxDiff) {
                        maxDiff = diff;
                    }
                }
            }
        }

//        System.out.println("final ans  = " + maxDiff);
        return maxDiff;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumDifference(new int[]{7,1,5,4});
        sol.maximumDifference(new int[]{9,4,3,2});
        sol.maximumDifference(new int[]{1,5,2,10});
    }
}
