package contests.contests2021.lc1009.mediumone;

import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {

        int numElements = grid.length * grid[0].length;

        if (numElements == 1) {
            System.out.println("trivial 1 element edge case");
            return 0;
        }

        int totalSum = Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();

        double average = ((double) totalSum)/numElements;

        double targetVal = -10;
        if (average % x == 0) {
            targetVal = average;
        } else {
            double remainder = average % x;
            if ((x - remainder) >= (((double) x)/2)) {
                targetVal = average - remainder;
            } else {
                targetVal = average - remainder + x;
            }
        }

        System.out.println("average = " + average);
        System.out.println("targetVal = " + targetVal);


        int numOfOperations = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                int diff = (int) Math.abs(targetVal - val);

                if (diff % x != 0) {
                    System.out.println("ERROR, diff not possible");
                    System.out.println("val = " + val);
                    System.out.println("diff  = " + diff);
                    System.out.println("x = " + x);
                    return -1;
                } else {
                    numOfOperations += diff/x;
                }
            }
        }


        System.out.println("final ans = " + numOfOperations);
        return numOfOperations;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.minOperations(new int[][]{{2,4},{6,8}},2);
//        sol.minOperations(new int[][]{{1,5}, {2,3}},1);
//        sol.minOperations(new int[][]{{1,2},{3,4}},2);
//
//        sol.minOperations(new int[][]{{146}},86);  // Expected 0

        sol.minOperations(new int[][]{{931,128},{639,712}},73);  // expected 12

    }
}