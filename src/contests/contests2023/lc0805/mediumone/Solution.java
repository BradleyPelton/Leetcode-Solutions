package contests.contests2023.lc0805.mediumone;

import java.util.ArrayList;
import java.util.List;

// Accepted after 3 attempts
// Wrong answer 2 times

// Greedy was wrong. Brainteaser. adjacent pari

class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {

        if (nums.size() <= 2) {
            System.out.println("trivial");
            return true;
        }

        // true if there exists a pair of adjacent numbers greater than or equal to m

        for (int i = 0; i < nums.size() - 1; i++) {
            int leftVal = nums.get(i);
            int rightVal = nums.get(i + 1);

            if (leftVal + rightVal >= m) {
                System.out.println("find adjacent pair, returning true");
                return true;
            }
        }
        System.out.println("no good pairs");
        return false;


//        int currentSum =  nums.stream().mapToInt(Integer::intValue).sum();
//        List<Integer> currSubArr = new ArrayList<>(nums);
//        int n = nums.size();
//
//        while (true) {
//            if (currSubArr.size() == 2) {
//                System.out.println("reached two, returning true");
//                return true;
//            }
//            int leftVal = currSubArr.get(0);
//            int rightVal = currSubArr.get(currSubArr.size() - 1);
//
//            // remove right
//            if (leftVal > rightVal) {
//                currentSum -= rightVal;
//                currSubArr = currSubArr.subList(0, currSubArr.size() - 1);
//            } else if (leftVal < rightVal) {
//                currentSum -= leftVal;
//                currSubArr = currSubArr.subList(1, currSubArr.size());
//            } else {
//                // else left == right
//
//                int leftPlusOne = currSubArr.get(1);
//                int rightMinusOne = currSubArr.get(currSubArr.size() - 2);
//
//                // tie breaker
//                if (leftPlusOne > rightMinusOne) {
//                    // we want to take right
//                    currentSum -= rightVal;
//                    currSubArr = currSubArr.subList(0, currSubArr.size() - 1);
//                } else {
//                    // we want to take left
//                    currentSum -= leftVal;
//                    currSubArr = currSubArr.subList(1, currSubArr.size());
//                }
//            }
//
//            if (currentSum < m) {
//                System.out.println("reached bad state");
//                return false;
//            }
//        }


    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canSplitArray(
                new ArrayList<>(List.of(2, 2, 1)),
                4
        );
        sol.canSplitArray(
                new ArrayList<>(List.of(2, 1, 3)),
                5
        );
        sol.canSplitArray(
                new ArrayList<>(List.of(2, 3, 3, 2, 3)),
                6
        );

        sol.canSplitArray(
                new ArrayList<>(List.of(9, 2, 5, 7, 2)),
                12
        );  //expected true

        sol.canSplitArray(
                new ArrayList<>(List.of(1, 1, 2)),
                3
        );  //expected true

    }
}
