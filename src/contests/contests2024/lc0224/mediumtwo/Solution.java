package contests.contests2024.lc0224.mediumtwo;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;

        int numberOfMarked = 0;
        int numberOfDecrements = 0;


        Map<Integer, Integer> occMap = new HashMap<>();

        int ans = -1;
        for (int i = 0; i < m; i++) {
            occMap.put(changeIndices[i] - 1, occMap.getOrDefault(changeIndices[i] - 1, 0) + 1);






        }

        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.earliestSecondToMarkIndices(
//                new int[]{2,2,0},
//                new int[]{2,2,2,2,3,2,2,1}
//        ); // 8
        sol.earliestSecondToMarkIndices(
                new int[]{1,3},
                new int[]{1,1,1,2,1,1,1}
        ); // 6
//        sol.earliestSecondToMarkIndices(
//                new int[]{0,1},
//                new int[]{2,2,2}
//        ); // -1




    }
}
