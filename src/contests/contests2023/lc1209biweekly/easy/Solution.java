package contests.contests2023.lc1209biweekly.easy;

import java.util.Arrays;

// Accepted after 4 minutes
// Trivial

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int firstValAppearances = 0;
        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            if (Arrays.binarySearch(nums2, val) >= 0) {
                firstValAppearances++;
            }
        }

        int secondValAppearances = 0;
        for (int i = 0; i < nums2.length; i++) {
            int val = nums2[i];
            if (Arrays.binarySearch(nums1, val) >= 0) {
                secondValAppearances++;
            }
        }

        int[] ans = {firstValAppearances, secondValAppearances};
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findIntersectionValues(
                new int[]{4,3,2,3,1},
                new int[]{2,2,5,2,3,6}
        );
        sol.findIntersectionValues(
                new int[]{3,4,2,3},
                new int[]{1,5}
        );


    }
}
