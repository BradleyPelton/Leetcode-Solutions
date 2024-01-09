package contests.contests2021.lc1009.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// Accepted after 8 minutes

// Fumbled around with Streams. Slower but faster to code solution was for loops

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);

        HashSet<Integer> ans = new HashSet<>();

        for(Integer e : nums1) {
            if (Arrays.binarySearch(nums2, e) >= 0) {
                ans.add(e);
            } else if (Arrays.binarySearch(nums3, e) >= 0) {
                ans.add(e);
            }
        }

        for(Integer e : nums2) {
            if (Arrays.binarySearch(nums1, e) >= 0) {
                ans.add(e);
            } else if (Arrays.binarySearch(nums3, e) >= 0) {
                ans.add(e);
            }
        }

        for(Integer e : nums3) {
            if (Arrays.binarySearch(nums1, e) >= 0) {
                ans.add(e);
            } else if (Arrays.binarySearch(nums2, e) >= 0) {
                ans.add(e);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (Integer e : ans) {
            ansList.add(e);
        }

//        System.out.println(ansList);
        return ansList;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.twoOutOfThree(
                new int[]{1,1,3,2},
                new int[]{2,3},
                new int[]{3}
        );

        sol.twoOutOfThree(
                new int[]{3,1},
                new int[]{2,3},
                new int[]{1,2}
        );

        sol.twoOutOfThree(
                new int[]{1,2,2},
                new int[]{4,3,3},
                new int[]{5}
        );


    }
}
