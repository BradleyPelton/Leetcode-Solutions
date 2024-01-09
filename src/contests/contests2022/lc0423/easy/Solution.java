package contests.contests2022.lc0423.easy;

import java.util.*;

// Accepted after 9 minutes
// Trivial but still took me too long


class Solution {
    public List<Integer> intersection(int[][] nums) {

        Map<Integer, Integer> occMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int val = nums[i][j];

                if (occMap.containsKey(val)) {
                    int currOcc = occMap.get(val);
                    occMap.put(val, ++currOcc);
                } else {
                    occMap.put(val, 1);
                }
            }
        }

        int numberOfArrays = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int intKey : occMap.keySet()) {
            if (occMap.get(intKey) == numberOfArrays) {
                ans.add(intKey);
            }
        }

        Collections.sort(ans);
//        System.out.println(ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.intersection(new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}});
        sol.intersection(new int[][]{{1,2,3},{4,5,6}});






    }
}