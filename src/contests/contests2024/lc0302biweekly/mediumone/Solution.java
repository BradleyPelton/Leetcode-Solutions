package contests.contests2024.lc0302biweekly.mediumone;

import java.util.PriorityQueue;

// Accepted third attempt
// Two wrong answers due to sloppyness
// first wrong answer: vague question (secondInt >= k)
// second answer: int overflow

class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int val : nums) {
            minHeap.add((long) val);
        }

        int numOps = 0;
        while (minHeap.size() >= 2) {
            if (minHeap.peek() >= k) {
                break;
            }
            long firstInt = minHeap.remove();
            long secondInt = minHeap.remove();

            numOps++;
            long val = Math.min(firstInt, secondInt) * 2 + Math.max(firstInt, secondInt);
            minHeap.add(val);
        }
        System.out.println(numOps);
        return numOps;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(
                new int[]{2,11,10,1,3},
                10
        ); // 2
        sol.minOperations(
                new int[]{1,1,2,4,9},
                20
        ); // 4
        sol.minOperations(
                new int[]{97,24,43,45,45,26},
                45
        ); // 2
        sol.minOperations(
                new int[]{1000000000,999999999,1000000000,999999999,1000000000,999999999},
                1000000000
        ); // 2





    }
}