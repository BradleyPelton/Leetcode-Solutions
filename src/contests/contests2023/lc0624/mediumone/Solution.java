package contests.contests2023.lc0624.mediumone;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {

        List<Long> modValues = new ArrayList<>();

        long currPowerTwo = 0;

        for (int i = 0; i < 60; i++) {
            long nextValue = (long)(Math.pow(2, currPowerTwo + i) + num2);
            if (nextValue > Math.pow(10, 9)) {
                break;
            }
            modValues.add(nextValue);
        }
        modValues.remove(Long.valueOf(0));
//        Collections.sort(modValues, Comparator.reverseOrder());


        int numberOfSteps = 0;
        for (int i = 0; i < 1000; i++) {
            long nextModValue = 0L;
            long minDiff = Long.MAX_VALUE;
            for (long modValue : modValues) {
                long currDiff = Math.abs(num1 - modValue);
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    nextModValue = modValue;
                }
            }

            if (nextModValue == 0) {
                break;
            } else {
                numberOfSteps++;
                num1 -= nextModValue;
            }
            if (num1 == 0) {
                break;
            }
        }

        if (num1 != 0) {
            System.out.println("Still not 0, return -1");
            numberOfSteps = -1;
        }

        System.out.println("ans = " + numberOfSteps);
        return numberOfSteps;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.makeTheIntegerZero(3, -2);
//        sol.makeTheIntegerZero(5, 7);
        sol.makeTheIntegerZero(5 , -21); // expected 3
    }
}
