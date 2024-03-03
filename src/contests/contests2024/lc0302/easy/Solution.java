package contests.contests2024.lc0302.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Accepted after 5 minutes
// Accepted first attempt
// Sloppy that it took 5 minutes.

class Solution {
    public int[] resultArray(int[] nums) {

        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList = new ArrayList<>();
        oneList.add(nums[0]);
        twoList.add(nums[1]);

        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if (oneList.get(oneList.size() - 1) > twoList.get(twoList.size() - 1)) {
                oneList.add(nums[i]);
            } else {
                twoList.add(nums[i]);
            }
        }

        oneList.addAll(twoList);
        int[] ans = oneList.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.resultArray(
                new int[]{2,1,3}
        );
        sol.resultArray(
                new int[]{5,4,3,8}
        );


    }
}
