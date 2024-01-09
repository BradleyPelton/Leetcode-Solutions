package contests.contests2023.lc0401biweekly.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

// Accepted first attempt
// Fumbled int[] to ArrayList<Integer> conversion

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {


        ArrayList<Integer> nums1ArrList = (ArrayList<Integer>)Arrays.stream(nums1).boxed().collect(Collectors.toList());
        ArrayList<Integer> nums2ArrList = (ArrayList<Integer>)Arrays.stream(nums2).boxed().collect(Collectors.toList());
        for (int i = 0; i < 10; i++) {
            if (nums1ArrList.contains(i) && nums2ArrList.contains(i)) {
                System.out.println("trivial solution i = " + i);
                return i;
            }
        }



        int minFromNums1 = Arrays.stream(nums1).min().getAsInt();
        int minFromNums2 = Arrays.stream(nums2).min().getAsInt();



        int ans = 0;
        if (minFromNums1 < minFromNums2) {
            ans = minFromNums1 * 10 + minFromNums2;
        } else {
            ans = minFromNums2 * 10 + minFromNums1;
        }

        System.out.println("ans = " + ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minNumber(
                new int[]{4,1,3},
                new int[]{5,7}
        );
        sol.minNumber(
                new int[]{3,5,2,6},
                new int[]{3,1,7}
        );
    }
}
