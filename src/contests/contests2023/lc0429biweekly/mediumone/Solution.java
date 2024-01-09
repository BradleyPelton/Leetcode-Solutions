package contests.contests2023.lc0429biweekly.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 8 minutes.
// Pretty easy medium problem.

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        Map<Integer, Integer> aIndexMap = new HashMap<>();
        Map<Integer, Integer> bIndexMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int aNum = A[i];
            int bNum = B[i];

            aIndexMap.put(aNum, i);
            bIndexMap.put(bNum, i);
        }

        int[] ans = new int[A.length];

        for (int i = 1; i <= A.length; i++) {

            int aFirstIndex = aIndexMap.get(i);
            int bFirstIndex = bIndexMap.get(i);

            int firstIndexInCommon = Math.max(aFirstIndex, bFirstIndex);

            for (int j = firstIndexInCommon; j < A.length; j++) {
                ans[j]++;
            }
        }

//        System.out.println("ans = " + Arrays.toString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findThePrefixCommonArray(
                new int[]{1,3,2,4},
                new int[]{3,1,2,4}
        );
        sol.findThePrefixCommonArray(
                new int[]{2,3,1},
                new int[]{3,1,2}
        );
    }
}