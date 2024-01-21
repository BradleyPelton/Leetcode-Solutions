package contests.contests2024.lc0120biweekly.easy;


// Accepted after 3 minutes
// COol easy problem. Had to debug one issue.

class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int currSum = nums[i] + nums[j] + nums[k];
                    minSum = Math.min(minSum, currSum);
                }
            }
            break;
        }
        System.out.println(minSum);
        return minSum;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumCost(
                new int[]{1,2,3,12}
        );
        sol.minimumCost(
                new int[]{5,4,3}
        );
        sol.minimumCost(
                new int[]{10,3,1,1}
        );






    }
}
