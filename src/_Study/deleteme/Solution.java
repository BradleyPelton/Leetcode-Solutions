package _Study.deleteme;


import util.TreeNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> numsPQ = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        for (int val : nums) {
            numsPQ.add(val);
        }

        for (int i = 0; i < k - 1; i++) {
            numsPQ.remove();
        }
        int ans = numsPQ.remove();
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

    }
}
