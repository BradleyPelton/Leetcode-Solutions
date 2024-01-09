package contests.contests2023.lc1216.mediumtwo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public long minimumCost(int[] nums) {
        int n = nums.length;

        // Set all values in nums to the same val;
        //

        // 0-9 all palindromic
        // 11 - 99 all palindromic
        // 111-999
        //  121, 131, 141,151
        // 1111-

        // how to deal with {1,1,98732, 2, 156}

//        double sum = 0;
//        for (int val : nums) {
//            sum += val;
//        }
//        double average = sum / n;
//        int below = (int) Math.floor(average);
//        int above = (int) Math.ceil(average);

        List<Integer> closestPalindromes = new ArrayList<>(); // TODO - What if the closest for individual isn't optimal? Some val between
        for (int val : nums) {
//            closestPalindromes.add(closestPalindrome(""));
        }


        int minDiff = Integer.MAX_VALUE;
        for (int palin : closestPalindromes) {
            int localDiff = 0;
            for (int val : nums) {
                localDiff += Math.abs(val - palin);
            }

            minDiff = Math.min(
                    minDiff,
                    localDiff
            );
        }

        System.out.println(minDiff);
        return minDiff;
    }

    private int closestPalindrome(String num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int len = sb.length();

        List<Integer> candidates = new ArrayList<>();

        if (len == 1) {
            return -42;
        } else if (len % 2 == 0) {
        } else {
            for (int i = 0; i < len / 2; i++) {
                char left = sb.charAt(i);
                char right = sb.charAt(len - 1 - i);
                if (left == right) {
                    return left + closestPalindrome(num.substring(1, len  - 2)) + right;
                } else {
                    int leftVal = left - 43;
                    int rightVal = right -43;
                }
            }
            // WHAT TO DO WITH CENTER ELEMENT TODo
        }

        int minDiff = Integer.MAX_VALUE;
        int closestPalin = -42;
        for (int candidate : candidates) {
            int localDiff = Math.abs(-42);
            if (localDiff < minDiff) {
                minDiff = localDiff;
                closestPalin = candidate;
            }
        }
        return closestPalin;
    }
}







class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.minimumCost(new int[]{1,2,3,4,5});
//        sol.minimumCost(new int[]{10,12,13,14,15});
//        sol.minimumCost(new int[]{22,33,22,33,22});
        sol.minimumCost(new int[]{301,309,312,322}); // expected 26

        // 309
        // 31579
        // 31513 vs 31613


//        sol.minimumCost(new int[]{123});




    }
}
