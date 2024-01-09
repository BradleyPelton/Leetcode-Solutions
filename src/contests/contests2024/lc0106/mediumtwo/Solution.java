package contests.contests2024.lc0106.mediumtwo;

import java.util.HashSet;
import java.util.Set;

// Accepted after 45 minutes
// Horribly sloppy. I fumbled with the question and it was just a simple hashing problem.
// Still finished at pos 1863. A lot of people are struggling with the mediumone
// I had a huge lead over the 3Q gang but I blew 15 minutes

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> uniqueNums1 = new HashSet<>();
        Set<Integer> uniqueNums2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueNums1.add(nums1[i]);
            uniqueNums2.add(nums2[i]);
        }

        int valsInOneButNotTwo = 0;
        int valsInTwoButNotOne = 0;
        int sharedValsCount = 0;
        for (int val : uniqueNums1) {
            if (!uniqueNums2.contains(val)) {
                valsInOneButNotTwo++;
            } else {
                sharedValsCount++;
            }
        }
        for (int val : uniqueNums2) {
            if (!uniqueNums1.contains(val)) {
                valsInTwoButNotOne++;
            }
        }

        // GREEDY: Use as many shared vals are you can

        int oneValsUsed = Math.min(valsInOneButNotTwo, n / 2);
        int twoValsUsed = Math.min(valsInTwoButNotOne, n / 2);

        int sharedValsUsed = Math.min(n / 2 - oneValsUsed, sharedValsCount);
        sharedValsCount -= sharedValsUsed;
        oneValsUsed += sharedValsUsed;

        int sharedValsUsedAgain = Math.min(n / 2 - twoValsUsed, sharedValsCount);
        twoValsUsed += sharedValsUsedAgain;

        int ans = oneValsUsed + twoValsUsed;
        System.out.println(ans);
        return ans;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumSetSize(
                new int[]{1,2,1,2},
                new int[]{1,1,1,1}
        );
        sol.maximumSetSize(
                new int[]{1,2,3,4,5,6},
                new int[]{2,3,2,3,2,3}
        );
        sol.maximumSetSize(
                new int[]{1,1,2,2,3,3},
                new int[]{4,4,5,5,6,6}
        );









    }
}