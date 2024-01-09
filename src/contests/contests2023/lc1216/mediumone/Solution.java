package contests.contests2023.lc1216.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Accepted after 13 minutes
// First attempt rejected wrong answer. Missed a comaprison.

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        List<int[]> ansList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i < n - 2) {
                int firstElement = nums[i];
                int secondElement = nums[i + 1];
                int thirdElement = nums[i + 2];

                if (Math.abs(firstElement - secondElement) <= k
                    && Math.abs(secondElement - thirdElement) <= k
                    && Math.abs(firstElement - thirdElement) <= k) {
                    ansList.add(new int[]{firstElement, secondElement, thirdElement});
                } else {
                    System.out.println("false, bad comparisons");
                    return new int[][]{};
                }
            } else if (i < n - 1) {
                System.out.println("false, not enough");
                return new int[][]{};
            } else {
                System.out.println("false, not enough");
                return new int[][]{};
            }
            i++;
            i++;
        }

        int[][] ans = ansList.toArray(new int[ansList.size()][]);
//        for (int i = 0; i < ansList.size(); i++) {
//            ans[i] = ansList.get(i);
//        }
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.divideArray(
                new int[]{1,3,4,8,7,9,3,5,1},
                2
        );
        sol.divideArray(
                new int[]{1,3,3,2,7,3},
                3
        );
        sol.divideArray(
                new int[]{15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2},
                2
        ); // expected int[][]



    }
}