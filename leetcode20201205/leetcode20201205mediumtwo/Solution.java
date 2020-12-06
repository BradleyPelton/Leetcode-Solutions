package leetcode20201205mediumtwo;

import java.math.BigInteger;

class Solution {
    public int concatenatedBinary(int n) {

        String binString = "";

        for (int i = 1 ; i < n+1; i++){
            String nbinString = Integer.toBinaryString(i);
            binString += nbinString;
        }

        // what is 10**9 + 7 mod in binary? hmm

        return 5;

    }
}

class Tests {
  public static void main(String[] args) {
    Solution sol = new Solution();
      sol.concatenatedBinary(3);
      sol.concatenatedBinary(12);
      sol.concatenatedBinary(1000);
  }
}