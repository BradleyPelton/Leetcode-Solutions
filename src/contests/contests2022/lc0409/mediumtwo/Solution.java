package contests.contests2022.lc0409.mediumtwo;

import java.util.PriorityQueue;

// First attempt, wrong answer
// Time Limit Exceeded second attempt, frustrating bullshit modulus long overflow
// Third attempt accepted

// LESSONS LEARNED:
// long overflow is a thing.
// BigInteger is an expensive class to use.
// I thought


//Math Proof: Isoperimetric Theorem + Hyperrectangle + Hypercubes

// THEOREM: A particular case of the Isoperimetric Theorem says that among all rectangles of a given perimeter, the square has the largest area.
// An int[] array can be thought of as a n-dimensional rectangle(Hyperrectangle) where ith index represents the ith side of length nums[i]
// Thus, the answer to the question of maximum product of an int[] is to make the n-dimensional rectangle as much of a HyperCube as possible
// by incrementing the smallest value

class Solution {
    public int maximumProduct(int[] nums, int k) {

        // Theory: The closer the nums are together, the larger the val
        // Always increment the smallest value

        PriorityQueue<Integer> intPQ = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return -1;
            } else if (a.equals(b)) {
                return 0;
            } else {
                return 1;
            }
        });

        for (int e : nums) {  // Theres a way
            intPQ.add(e);
        }

        for (int i = 0; i < k; i++) {  // Theres
            int smallestVal = intPQ.poll();
            smallestVal++;
            intPQ.add(smallestVal);
        }

        long totalProduct =  1L;
        final long rem = 1_000_000_007L;
        while (!intPQ.isEmpty()) {
            int polledInt = intPQ.poll();
            totalProduct = (totalProduct * polledInt) % rem;
        }

        System.out.println("total Product = " + totalProduct);
        int ansModded = (int)(totalProduct % rem);
        System.out.println("final ans = " + ansModded);
        return ansModded;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.maximumProduct(new int[]{0,4}, 5);
        sol.maximumProduct(new int[]{6,3,3,2}, 2);


        sol.maximumProduct(new int[]{92,36,15,84,57,60,72,86,70,43,16}, 62);


                // expected 800222867


    }
}