package contests.contests2023.lc1111.mediumtwo;

import java.util.Arrays;

// Accepted First Try
// Accepted after 30 minutes
// Misread the problem and wasted 10 minutes

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] nums1Copy = Arrays.copyOf(nums1, n);
        int[] nums2Copy = Arrays.copyOf(nums2, n);

        // Count the number of operations on 0, ..., n - 1 needed (not including last element)
        int ansBeforeSwap = countOperations(nums1, nums2);

        // Swap the last two elements and count the number of operations on 0, ..., n - 1 needed (not including last element)
        int tempSwap = nums1Copy[n - 1];
        nums1Copy[n - 1] = nums2Copy[n - 1];
        nums2Copy[n - 1] = tempSwap;
        int ansAfterSwap = countOperations(nums1, nums2);
        ansAfterSwap = ansAfterSwap == Integer.MAX_VALUE ? ansAfterSwap : ansAfterSwap + 1; // add the extra last element swap

        if (ansBeforeSwap == Integer.MAX_VALUE && ansAfterSwap == Integer.MAX_VALUE) {
            return -1;
        } else {
            return Math.min(ansBeforeSwap, ansAfterSwap);
        }
    }

    private int countOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int currNums1LastElement = nums1[n - 1];
        int currNums2LastElement = nums2[n - 1];
        int numberOfOperations = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums1[i] > currNums1LastElement) {
                int temp = nums2[i];
                nums2[i] = nums1[i];
                nums1[i] = temp;
                numberOfOperations++;
                if (nums1[i] > currNums1LastElement || nums2[i] > currNums2LastElement) {
                    return Integer.MAX_VALUE;  //
                }
            } else if (nums2[i] > currNums2LastElement) {
                int temp = nums2[i];
                nums2[i] = nums1[i];
                nums1[i] = temp;
                numberOfOperations++;
                if (nums1[i] > currNums1LastElement || nums2[i] > currNums2LastElement) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return numberOfOperations;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(
                new int[]{1,2,7},
                new int[]{4,5,3}
        );
        sol.minOperations(
                new int[]{2,3,4,5,9},
                new int[]{8,8,4,4,4}
        );
        sol.minOperations(
                new int[]{1,5,4},
                new int[]{2,5,3}
        );
    }
}