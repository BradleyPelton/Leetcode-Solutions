package contests.contests2024.lc0427.mediumone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Accepted after 17 minutes
// Ended up brute forcing. I thought there was some clever solution with array sums, but too much time.

class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int smallestAns = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            INNER_LOOP:
            for (int j = i + 1; j < nums1.length; j++) {
                // skip the indices at i,j


                int left = 0;
                int right = 0;
                Integer diff = null;
                for (int k = 0; k < nums1.length; k++) {
                    if (k == i || k == j) {
                        left++;
                        continue;
                    }

                    int localDiff = nums2[right] - nums1[left];
                    if (diff == null) {
                        diff = localDiff;
                    } else {
                        if (diff != localDiff) {
                            continue INNER_LOOP;
                        }
                    }
                    left++;
                    right++;
                }

                smallestAns = Math.min(smallestAns, diff);
            }
        }

        System.out.println(smallestAns);
        return smallestAns;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumAddedInteger(
                new int[]{4,20,16,12,8},
                new int[]{14,18,10}
        );
        sol.minimumAddedInteger(
                new int[]{3,5,5,3},
                new int[]{7,7}
        );




    }
}
