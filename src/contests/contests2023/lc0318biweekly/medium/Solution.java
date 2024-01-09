package contests.contests2023.lc0318biweekly.medium;

import java.util.*;
import java.util.stream.Collectors;

// Tricky problem
// First attempt accepted, 8:20 am. 30 minutes

// Took me a while to think of a solution. Deceptively simple

class Solution {
    public int maximizeGreatness(int[] nums) {
        int[] originalArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);

        Queue<Integer> remainingVals = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        remainingVals.addAll(Arrays.stream(originalArr).boxed().collect(Collectors.toList()));
        int ans = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            int currVal = nums[i];
            int firstValInQueue = remainingVals.peek();

            if (currVal >= firstValInQueue) {
                continue;
            } else {
                remainingVals.poll();
                ans += 1;
            }
        }

        //

        System.out.println("ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximizeGreatness(new int[]{1,3,5,2,1,3,1});
        sol.maximizeGreatness(new int[]{1,2,3,4});
    }
}