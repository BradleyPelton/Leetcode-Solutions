package _Study.Problems.reverseBitsTODO;

/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/description/
 */
public class Solution {
    public int reverseBits(int n) {
        // Dumb problem . toBinaryString().reverse.parseBinary() should have worked.

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ans = ans | (1 << (31 - i));
            }
        }
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.reverseBits(0b00000010100101000001111010011100);
        sol.reverseBits(0b11111111111111111111111111111101);
    }
}