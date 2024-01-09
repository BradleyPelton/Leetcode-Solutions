package contests.contests2024.lc0106biweekly.mediumone;

import java.util.ArrayList;
import java.util.List;

// Accepted after 28 minutes
// Binary remains a weakness
// I am bruteforcing binary comparisons with Binary strings instead of using XOR as intended.


class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;


        int ans = 0;
        char[] kAsBin = Integer.toBinaryString(k).toCharArray();
        List<Character> kList = new ArrayList<>();
        for (int i = 0; i < kAsBin.length; i++) {
            kList.add(kAsBin[i]);
        }

        char[] lastBin = Integer.toBinaryString(nums[n - 1]).toCharArray();
        List<Character> lastList = new ArrayList<>();
        for (int i = 0; i < lastBin.length; i++) {
            lastList.add(lastBin[i]);
        }



        if (n == 1) {

            int maxLength = Math.max(kList.size(), lastList.size());
            while (kList.size() < maxLength) {
                kList.add(0, '0');
            }
            while (lastList.size() < maxLength) {
                lastList.add(0, '0');
            }

            for (int i = 0; i < lastList.size(); i++) {
                if (lastList.get(i) != kList.get(i)) {
                    ans++;
                }
            }




        } else {
            int xorOfAllButOneVal = nums[0];
            for (int i = 1; i < n - 1; i++) {
                xorOfAllButOneVal = xorOfAllButOneVal ^ nums[i];
            }


            char[] xorOfAllButOneValBin = Integer.toBinaryString(xorOfAllButOneVal).toCharArray();
            List<Character> xorOfAllButOneList = new ArrayList<>();
            for (int i = 0; i < xorOfAllButOneValBin.length; i++) {
                xorOfAllButOneList.add(xorOfAllButOneValBin[i]);
            }

            int maxLength = Math.max(xorOfAllButOneList.size(), Math.max(kList.size(), lastList.size()));
            while (kList.size() < maxLength) {
                kList.add(0, '0');
            }
            while (xorOfAllButOneList.size() < maxLength) {
                xorOfAllButOneList.add(0, '0');
            }
            while (lastList.size() < maxLength) {
                lastList.add(0, '0');
            }



            for (int i = 0; i < kList.size(); i++) {
                if (kList.get(i) == '1') {
                    if (xorOfAllButOneList.get(i) == lastList.get(i)) {
                        ans++;
                    } else {
                    }
                } else { // else == 0
                    if (xorOfAllButOneList.get(i) == lastList.get(i)) {
                    } else {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
        return ans;
    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(
                new int[]{2,1,3,4},
                1
        );
        sol.minOperations(
                new int[]{2,0,2,0},
                0
        );
        sol.minOperations(
                new int[]{4},
                7
        ); // 2





    }
}