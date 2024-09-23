package contests.contests2024.lc0914.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Accepted after 2 minutes
// Accepted first try

// Trivial - Famous bit problem.

class Solution {
    public int[] getSneakyNumbers(int[] nums) {

        List<Integer> ansArr = new ArrayList<>();
        Set<Integer> seenValues = new HashSet<>();

        for (int val : nums) {
            if (!seenValues.add(val)) {
                ansArr.add(val);
            }
        }

        int[] ans = new int[2];
        ans[0] = ansArr.get(0);
        ans[1] = ansArr.get(1);

        System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getSneakyNumbers(
                new int[]{0,1,1,0}
        );
        sol.getSneakyNumbers(
                new int[]{0,3,2,1,3,2}
        );
        sol.getSneakyNumbers(
                new int[]{7,1,5,4,3,4,6,0,9,5,8,2}
        );




    }
}
