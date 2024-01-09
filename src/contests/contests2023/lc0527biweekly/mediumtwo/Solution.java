package contests.contests2023.lc0527biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.List;

// Accepted after 20 minutes
// Rare (switch to problem 3 and skip problem 2)
// Fumbled around with edge cases for 15 minutes.

class Solution {
    public long maxStrength(int[] nums) {

        List<Integer> onlyPositives = new ArrayList<>();
        List<Integer> onlyNegatives = new ArrayList<>();
        boolean containsZero = false;

        long positiveProd = 1;
        for (int e : nums) {
            if (e > 0) {
                positiveProd *= e;
                onlyPositives.add(e);
            } else if (e < 0) {
                onlyNegatives.add(e);
            } else if (e == 0) {
                containsZero = true;
            }
        }

        long negativeProd = 1;
        if (onlyNegatives.size() % 2 == 0) {
            for (int e : onlyNegatives) {
                negativeProd *= e;
            }
        } else {
            int largestNegativeNumber = Integer.MIN_VALUE;
            for (int e : onlyNegatives) {
                negativeProd *= e;
                largestNegativeNumber = Math.max(e, largestNegativeNumber);
            }
            negativeProd /= largestNegativeNumber;
        }


        long ans = 0L;
        if (onlyPositives.size() == 0) {
            if (onlyNegatives.size() >= 2) {
                ans = negativeProd;
            } else if (onlyNegatives.size() == 1) {
                if (containsZero) {
                    ans = 0L;
                } else {
                    ans = onlyNegatives.get(0);
                }
            }
        } else {
            if (onlyPositives.size() > 0) {
                ans = positiveProd;
            }

            if (onlyNegatives.size() > 0) {
                ans *= negativeProd;
            }
        }


        System.out.println("ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.maxStrength(new int[]{3,-1,-5,2,5,-9});
        sol.maxStrength(new int[]{-4,-5,-4});
        sol.maxStrength(new int[]{0, -1});
    }
}