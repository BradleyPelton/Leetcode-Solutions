package contests.contests2024.lc0302biweekly.easy;

import java.util.PriorityQueue;

// Accepeted first try
// Accepted after 3 minutes, trivial

class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : nums) {
            minHeap.add(val);
        }

        int numOps = 0;
        while (!minHeap.isEmpty()) {
            if (minHeap.peek() >= k) {
                break;
            }
            numOps++;
            minHeap.remove();
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
        ); // 3
        sol.minOperations(
                new int[]{1,1,2,4,9},
                1
        ); // 0
        sol.minOperations(
                new int[]{1,1,2,4,9},
                9
        );  // 4




    }
}