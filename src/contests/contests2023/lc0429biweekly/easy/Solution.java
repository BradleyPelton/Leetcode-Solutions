package contests.contests2023.lc0429biweekly.easy;

import java.util.*;
import java.util.stream.Collectors;

// Accepted after 3 minutes
// trivial


class Solution {
    public int maximizeSum(int[] nums, int k) {

        Queue<Integer> scoreQueue = new PriorityQueue<>(Comparator.reverseOrder());
        scoreQueue.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));


        int ans = 0;
        for (int i = 0; i < k; i++) {
            int nextNum = scoreQueue.poll();
            ans += nextNum;
            scoreQueue.add(nextNum + 1);
        }

        System.out.println("ans " + ans);
        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximizeSum(new int[]{1,2,3,4,5}, 3);
        sol.maximizeSum(new int[]{5,5,5}, 2);
    }
}
