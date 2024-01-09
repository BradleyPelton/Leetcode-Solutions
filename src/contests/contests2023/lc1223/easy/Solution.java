package contests.contests2023.lc1223.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Accepted after 4 minutes
// Trivial

class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ansList = new ArrayList<>();

        // 1,0,3,2,5,3

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                ansList.add(nums[i + 1]);
            } else {
                ansList.add(nums[i - 1]);
            }
        }

        int[] ans = ansList.stream().mapToInt(i -> i).toArray();
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberGame(new int[]{5,4,2,3});
        sol.numberGame(new int[]{2,5});





    }
}
