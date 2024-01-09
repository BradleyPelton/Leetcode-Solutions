package _Study.Problems.reverseBitsTODO;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        String bin = Integer.toBinaryString(n);
        String reversedBin = new StringBuilder(bin).reverse().toString();
//        int dec = Long.parseLong(reversedBin, 2);
        return -42;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.reverseBits(0b00000010100101000001111010011100);
        sol.reverseBits(0b11111111111111111111111111111101);
    }
}