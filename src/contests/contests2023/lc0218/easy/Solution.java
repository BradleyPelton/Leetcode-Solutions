package contests.contests2023.lc0218.easy;

import java.util.*;

// Tedious easy problem.
// 14 minutes

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        Map<Integer, Integer> nums1AsMap = new HashMap<>();
        Map<Integer, Integer> nums2AsMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int[] currentPair = nums1[i];
            int currentId = currentPair[0];
            int currentValue = currentPair[1];
            nums1AsMap.put(currentId, currentValue);
        }

        for (int i = 0; i < nums2.length; i++) {
            int[] currentPair = nums2[i];
            int currentId = currentPair[0];
            int currentValue = currentPair[1];
            nums2AsMap.put(currentId, currentValue);
        }

        List<int[]> answerAsList = new ArrayList<>();

        for (int i = 1; i < 1001; i++) {
            if (!nums1AsMap.containsKey(i) && !nums2AsMap.containsKey(i)) {
                continue;
            }

            int nums1Val = nums1AsMap.getOrDefault(i, 0);
            int nums2Val = nums2AsMap.getOrDefault(i, 0);
            answerAsList.add(new int[]{i, nums1Val + nums2Val});
        }

        int[][] ans = new int[answerAsList.size()][2];
        for (int i = 0; i < answerAsList.size(); i++) {
            ans[i] = answerAsList.get(i);
        }

        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.mergeArrays(new int[][]{{1,2},{2,3},{4,5}},
                new int[][]{{1,4},{3,2},{4,1}}
        );
        sol.mergeArrays(new int[][]{{2,4},{3,6},{5,5}},
                new int[][]{{1,3},{4,3}}
        );
    }
}
