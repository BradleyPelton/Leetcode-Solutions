package contests.contests2022.lc0319biweekly.mediumtwo;

import java.util.PriorityQueue;

// Accepted after 10 minutes. Frustrating that this problem was so easy but mediumone was so hard.
// returning to mediumone

class Solution {
    public int halveArray(int[] nums) {

        PriorityQueue<Double> largestNumPQ = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else if (a == b) {
                return 0;
            } {
                return 1;
            }
        });

        double sum = 0;
        for (int e : nums) {
            sum += e;
            largestNumPQ.add((double) e);
        }

        double currSum = sum;
        double halfSum = sum/2;

        int numberOfPolls = 0;
        while (currSum > halfSum) {
            numberOfPolls++;
            double nextVal = largestNumPQ.poll();
            nextVal /= 2;

            largestNumPQ.add(nextVal);
            currSum -= nextVal;

//            System.out.println("currSum = " + currSum);
        }


        System.out.println("final ans = " + numberOfPolls);
        return numberOfPolls;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.halveArray(new int[]{5,19,8,1});
        sol.halveArray(new int[]{3,8,20});
    }
}