package _Study.Problems.maximumNumberOfEventsThatCanBeAttended2;

/**
 * 1751. Maximum Number of Events That Can Be Attended II
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/
 *
 */
class Solution {
    public int maxValue(int[][] events, int k) {
        return -42;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxValue(
                new int[][]{{1,2,4},{3,4,3},{2,3,1}},
                2
        );
        sol.maxValue(
                new int[][]{{1,2,4},{3,4,3},{2,3,10}},
                2
        );
        sol.maxValue(
                new int[][]{{1,1,1},{2,2,2},{3,3,3},{4,4,4}},
                3
        );



    }
}