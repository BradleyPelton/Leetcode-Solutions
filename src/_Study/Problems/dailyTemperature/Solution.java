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
    public int[] dailyTemperatures(int[] temperatures) { // Monotonic Stack - 92% runtime, 79% memory
        int n = temperatures.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> temperatureStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!temperatureStack.isEmpty()) {
                if (temperatures[i] > temperatures[temperatureStack.peekFirst()]) {
                    int index = temperatureStack.removeFirst();
                    ans[index] = i - index;
                } else {
                    break;
                }
            }
            temperatureStack.addFirst(i);
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


