package _Study.Problems.longestArithmeticSubsequence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1027. Longest Arithmetic Subsequence
 * https://leetcode.com/problems/longest-arithmetic-subsequence/description/
 *
 * Similar question https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 *
 *
 */
class Solution {
    public int longestArithSeqLength(int[] nums) {
        return -42;
        // TODO
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.longestArithSeqLength(new int[]{3,6,9,12});
//        sol.longestArithSeqLength(new int[]{9,4,7,2,10});
//        sol.longestArithSeqLength(new int[]{20,1,15,3,10,5,8});
        sol.longestArithSeqLength(new int[]{44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28});

    }
}
