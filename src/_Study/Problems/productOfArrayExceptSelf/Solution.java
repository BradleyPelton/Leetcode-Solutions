package _Study.Problems.productOfArrayExceptSelf;


import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * // Theres a clever O(1) space solution. Mehhhh, overkill
 */
class Solution {
    public int[] productExceptSelf(int[] nums) { // prefix/suffix sum - 7% runtime, 5% memory
        int n = nums.length;
        int[] prefixProduct = new int[n];
        prefixProduct[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
        }

        int[] suffixProduct = new int[n];
        suffixProduct[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }

        int[] ans = new int[n];
        ans[0] = suffixProduct[1];
        ans[n - 1] = prefixProduct[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = prefixProduct[i - 1] * suffixProduct[i + 1];
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.productExceptSelf(new int[]{1,2,3,4});
        sol.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
}
