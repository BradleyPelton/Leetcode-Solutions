package _Study.Problems.dailyTemperature;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * Canonical monotonic stack problem (find next greatest element)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) { // Monotonic Stack - 77% runtime, 24% memory
        int n = temperatures.length;
//        Stack<Integer> tempDeque = new Stack<>(); // debatable to just always use ArrayDeque for everything
        ArrayDeque<Integer> tempDeque = new ArrayDeque<>(); // debatable to just always use ArrayDeque for everything

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int currTemp = temperatures[i];
            while (!tempDeque.isEmpty()) {
                if (currTemp > temperatures[tempDeque.peek()]) {
                    int topOfStackIndex = tempDeque.remove();
                    ans[topOfStackIndex] = i - topOfStackIndex;
                } else {
                    break;
                }
            }
            tempDeque.addFirst(i);
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        sol.dailyTemperatures(new int[]{30,40,50,60});
        sol.dailyTemperatures(new int[]{30,60,90});
    }
}


