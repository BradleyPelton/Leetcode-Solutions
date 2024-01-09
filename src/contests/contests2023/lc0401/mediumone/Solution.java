package contests.contests2023.lc0401.mediumone;

import java.util.ArrayList;
import java.util.List;

// Accepted after 6 minutes
// Cool problem. Just a matter of working with Lists
// brute force was trivial

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        OUTER_LOOP:
        for (int e : nums) {
            INNER_LOOP:
            for (List<Integer> subArr : ans) {
                if (subArr.contains(e)) {
                    continue INNER_LOOP;
                } else {
                    subArr.add(e);
                    continue OUTER_LOOP;
                }
            }
            // if we get here, no arrays eligible
            List<Integer> newArr = new ArrayList<>();
            newArr.add(e);
            ans.add(newArr);
        }

//        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findMatrix(new int[]{1,3,4,1,2,3,1});
        sol.findMatrix(new int[]{1,2,3,4});
    }
}