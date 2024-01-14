package contests.contests2024.lc0113.mediumtwo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public long findMaximumNumber(long k, int x) {

        // The price of a number num is the number of indices such that
        // index % x == 0
        // binNum[index] == 1

        // let X = 3;
        // then every number [0,7] has zero price
        // 8 has the price of one
        // 9 has th eprice of one
        // ...
        //

        List<Long> pivotPoints = new ArrayList<>();
        for (int multiplesOfX = 1; multiplesOfX < 32; multiplesOfX++) {
            // if x == 3
            // we want 100(8), 100_000(63)
            long point = 1L << (x * multiplesOfX);
            if (point > Integer.MAX_VALUE) {
                break;
            }
            pivotPoints.add(point);
        }

        long currPriceSum = 0;
        long maxNum = pivotPoints.get(0) - 1; // the numbers before the first pivot are all free

        for (int pivotIndex = 1; pivotIndex < pivotPoints.size(); pivotIndex++) {
            long currPivot = pivotPoints.get(pivotIndex);
            long previousPivot = pivotPoints.get(pivotIndex - 1);

            long costBetween = (currPivot - previousPivot) * (pivotIndex + 1);
            if (currPriceSum + costBetween <= k) {
                currPriceSum += costBetween;
                maxNum = currPivot;
            } else {

            }

        }

        System.out.println(maxNum);
        return maxNum;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.findMaximumNumber(9, 1);
        sol.findMaximumNumber(7, 2);


//        sol.findMaximumNumber(7,3);





    }
}
