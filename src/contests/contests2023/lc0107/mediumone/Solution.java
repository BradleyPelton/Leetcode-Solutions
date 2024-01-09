package contests.contests2023.lc0107.mediumone;

import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int num : nums) {
            pq.offer(num);
        }


        long score = 0;
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                int nextVal = pq.poll();
                score += nextVal;
                nextVal = (int) Math.ceil(nextVal / 3.0);
                pq.add(nextVal);
            }
        }

        System.out.println("ans = " + score);
        return score;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.maxKelements(new int[]{10,10,10,10,10}, 5);
        sol.maxKelements(new int[]{1,10,3,3,3}, 3);
    }
}
