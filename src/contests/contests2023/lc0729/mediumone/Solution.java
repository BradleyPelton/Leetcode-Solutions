package contests.contests2023.lc0729.mediumone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// Accepted after 9 minutes
// Pretty easy medium. I was worried about time complexity, but brute force worked.

class Solution {
    public int countCompleteSubarrays(int[] nums) {

        int numOfTotalDistinct = (int) Arrays.stream(nums).distinct().count();

        int ans = 0;
        OUTER_LOOP:
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> currWindow = new HashSet<>();
            currWindow.add(nums[i]);
            if (currWindow.size() == numOfTotalDistinct) {
                ans++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                currWindow.add(nums[j]);
                if (currWindow.size() == numOfTotalDistinct) {
                    ans++;
                } else if (currWindow.size() > numOfTotalDistinct) {
                    continue OUTER_LOOP;
                }
            }
        }

        System.out.println("ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countCompleteSubarrays(new int[]{1,3,1,2,2});
        sol.countCompleteSubarrays(new int[]{5,5,5,5});






    }
}