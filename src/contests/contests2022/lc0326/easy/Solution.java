package contests.contests2022.lc0326.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Accepted after 5 minutes
// Trivial

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> nums1list = new HashSet<>();
        HashSet<Integer> nums2list = new HashSet<>();


        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();

        for (int e : nums1) {
            nums1list.add(e);
        }

        for (int e : nums2) {
            nums2list.add(e);
        }

        for (int e : nums1list) {
            if (!nums2list.contains(e)) {
                diff1.add(e);
            }
        }

        for (int e : nums2list) {
            if (!nums1list.contains(e)) {
                diff2.add(e);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(diff1);
        ans.add(diff2);

//        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findDifference(new int[]{1,2,3}
                , new int[]{2,4,6}
        );

        sol.findDifference(new int[]{1,2,3,3}
                , new int[]{1,1,2,2}
        );
    }
}