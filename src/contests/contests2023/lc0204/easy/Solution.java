package contests.contests2023.lc0204.easy;

import java.util.PriorityQueue;

// PQ for a easy is intense.
// Trivial, 6 minutes. Took longer to write than to think.

class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> giftQueue = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for (int i = 0; i < gifts.length; i++) {
            giftQueue.add(gifts[i]);
        }

        for (int i = 0; i < k; i++) {
            int currentVal = giftQueue.poll();
            currentVal = (int) Math.floor(Math.sqrt(currentVal));
            giftQueue.add(currentVal);
        }

        long sumAfter = 0;
        while (!giftQueue.isEmpty()) {
            sumAfter += giftQueue.poll();
        }

        System.out.println("ans = " + sumAfter);
        return sumAfter;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.pickGifts(new int[]{25,64,9,4,100}, 4);
        sol.pickGifts(new int[]{1,1,1,1}, 4);

    }
}
