package contests.contests2021.lc0814.mediumone;

// First attempt rejected, "hidden"

// Accepted second attempt. Just brute force it, keep iterating until the list is good

// There is probably a clever edge case here that I am not considering. Brute force leads to better contest results

class Solution {
    public int[] rearrangeArray(int[] nums) {

        while (true) {
            int numOfSwaps = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                double currAvg = ((double) nums[i - 1] + nums[i + 1]) / 2;

                if ((double) nums[i] == currAvg) {
                    numOfSwaps++;
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }

            if (numOfSwaps == 0) {
                break;
            }
        }


//        System.out.println(Arrays.toString(nums));

        return nums;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.rearrangeArray(new int[]{1,2,3,4,5});
        sol.rearrangeArray(new int[]{9,7,6,2,0});
    }
}