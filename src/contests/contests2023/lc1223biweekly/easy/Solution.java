package contests.contests2023.lc1223biweekly.easy;

// Accepted after 13 miuntes
// Accepted first try
// Tricky easy question/

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;

        int numOfSubArrays = 0;
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n ; end++) {
                if (isIncremovable(nums, start, end)) { // if nums is Incremovable after removing [start..end]
                    numOfSubArrays++;
                }
            }
        }
        System.out.println(numOfSubArrays);
        return numOfSubArrays;
    }

    private boolean isIncremovable(int[] nums, int start, int end) {
        int numberOfIntervalsOfDecreasing = 0;
        int previousVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i >= start && i <= end) {
                continue;
            }

            int currVal = nums[i];
            if (previousVal == Integer.MIN_VALUE) {
                previousVal = currVal;
            } else {
                if (previousVal < currVal) {
                    previousVal = currVal;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.incremovableSubarrayCount(new int[]{1,2,3,4});
        sol.incremovableSubarrayCount(new int[]{6,5,7,8});
        sol.incremovableSubarrayCount(new int[]{8,7,6,6});




    }
}
