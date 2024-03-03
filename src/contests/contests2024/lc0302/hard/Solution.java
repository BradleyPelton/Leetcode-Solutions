package contests.contests2024.lc0302.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;


        List<Integer> arr1 = new ArrayList<>(n/2);
        List<Integer> arr2 = new ArrayList<>(n/2);
        arr1.add(nums[0]);
        arr2.add(nums[1]);










        int[] ans = new int[n];
        int arr1Size = arr1.size();
        for (int i = 0; i < arr1Size; i++) {
            ans[i] = arr1.get(i);
        }
        for (int i = 0; i < arr2.size(); i++) {
            ans[i + arr1Size] = arr2.get(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.resultArray(
                new int[]{2,1,3,3}
        );
        sol.resultArray(
                new int[]{5,14,3,1,2}
        );
        sol.resultArray(
                new int[]{3,3,3,3}
        );
    }
}
