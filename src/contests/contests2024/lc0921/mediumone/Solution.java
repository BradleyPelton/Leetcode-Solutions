package contests.contests2024.lc0921.mediumone;

import java.util.Comparator;
import java.util.PriorityQueue;

// Accepted after 3 attempts
// Accepted at 9:54

// Panicked and overcomplicated the PQ with two sort parameters
// misunderstood the problem.

// Sloppy, missed int overflow with long return parameter.

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        PriorityQueue<long[]> maxHeap = new PriorityQueue<>(
//                Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> b[2])
                Comparator.comparingLong((long[] a) -> a[2])
        );

        for (int worker : workerTimes) {
            maxHeap.add(new long[]{1L, worker, worker}); // iteration, originalWorkTime, currentWorkTime
        }

        long numberOfSeconds = 0;
        while (mountainHeight > 0) {
            long[] worker = maxHeap.remove();
            mountainHeight--;

            numberOfSeconds = Math.max(numberOfSeconds, worker[2]);

            worker[0]++;
            worker[2] += (worker[0] * worker[1]);
            maxHeap.add(worker);
        }

        System.out.println(numberOfSeconds);
        return numberOfSeconds;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minNumberOfSeconds(
                4,
                new int[]{2,1,1}
        ); // 3
        sol.minNumberOfSeconds(
                10,
                new int[]{3,2,2,4}
        ); // 12
        sol.minNumberOfSeconds(
                5,
                new int[]{1}
        ); // 15
        sol.minNumberOfSeconds(
                5,
                new int[]{1,5}
        ); // 10





    }
}
