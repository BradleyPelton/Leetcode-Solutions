package contests.contests2021.lc0807.mediumone;

import java.util.PriorityQueue;

// Accepted after 10 minutes

// Priority queues are work again
// Gotta love the PQs. I gotta learn the different parameters though instead of always defaulting to lambda and inner class

class Solution {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pilePq = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));

        for (int pile : piles) {
            pilePq.add(pile);
        }


        for (int i = 0; i < k; i++) {
            int polled = pilePq.poll();
            int newIntVal = polled - (int) Math.floor(polled/2);
            pilePq.add(newIntVal);
        }

        int totalSum = 0;
        while(!pilePq.isEmpty()) {
            totalSum += pilePq.poll();
        }

        System.out.println("final ans " + totalSum);

        return totalSum;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minStoneSum(new int[]{5,4,9}, 2);
        sol.minStoneSum(new int[]{4,3,6,7}, 3);
    }
}