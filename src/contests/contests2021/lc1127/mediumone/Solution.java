package contests.contests2021.lc1127.mediumone;

import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {


        int[] ans = new int[nums.length];
        if (nums.length <= 2*k) {
            System.out.println("impossible length");
            for (int i = 0; i < nums.length; i++) {
                ans[i] = -1;
            }
            return ans;
        }


        for (int i = 0; i < k; i++) {
            ans[i] = -1;
        }

        for (int i = nums.length - k; i < nums.length; i++) {
            ans[i] = -1;
        }

        int currSum = Arrays.stream(Arrays.copyOfRange(nums, 0, k + k + 1)).sum();
        ans[k] = currSum/(2*k+1);
        System.out.println("test");
        for (int i = k; i < nums.length - k - 1; i++) {
            currSum -= nums[i - k];
            currSum += nums[i + k + 1];

            int avg = currSum/(2*k+1);
            ans[i+1] = avg;
        }

//        System.out.println("final ans = \n" + Arrays.toString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3);
//        sol.getAverages(new int[]{100000}, 0);
//        sol.getAverages(new int[]{8}, 100000);

        sol.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3);
    }
}