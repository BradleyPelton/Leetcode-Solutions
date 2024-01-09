package contests.contests2023.lc0624.mediumtwo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {

        List<Long> pows = new ArrayList<>();

        int lastOneIndex = -1;
        int numberOfZeroesBetween = 0;
        for (int i = 0; i < nums.length; i++) {

            // handle firstIndex
            if (lastOneIndex == -1) {
                if (nums[i] == 1) {
                    lastOneIndex = i;
                }
                continue;
            }

            // last index handled trivially. I think so.

            if (nums[i] == 0) {
                numberOfZeroesBetween++;
            } else {
                // number of ways of partitioning
                // between lastOneIndex and rightIndex
                pows.add(numberOfZeroesBetween + 1L);

                numberOfZeroesBetween = 0;
                lastOneIndex = i;
            }
        }

        if (lastOneIndex == -1) {
            System.out.println("no ones found, returning zero");
            return 0;
        }

        if (pows.size() == 0) {
            System.out.println("only one one found, returning one");
            return 1;
        }


        final long rem = 1_000_000_007L;
        int ans = 1;
        for (Long e : pows) {
            long beforeMod = ans * e;
            ans = (int)(beforeMod % rem);
        }

        System.out.println("ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfGoodSubarraySplits(new int[]{0,1,0,0,1});
        sol.numberOfGoodSubarraySplits(new int[]{0,1,0});
        sol.numberOfGoodSubarraySplits(new int[]{0,0});
        sol.numberOfGoodSubarraySplits(new int[]{0,0});
    }
}

