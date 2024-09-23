package contests.contests2024.lc0914biweekly.easy;

import java.util.ArrayList;
import java.util.List;

// Accepted first attempt
// Accepted after 2 minutes

// Trivial

class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {


        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            int prev = height[i - 1];
            if (prev > threshold) {
                ans.add(i);
            }
        }

//        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.stableMountains(
                new int[]{1,2,3,4,5},
                2
        );
        sol.stableMountains(
                new int[]{10,1,10,1,10},
                3
        );
        sol.stableMountains(
                new int[]{10,1,10,1,10},
                10
        );




    }
}