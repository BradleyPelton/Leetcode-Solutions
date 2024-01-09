package _Study.Problems.decodeWays;


/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/description/
 *
 * // TODO - Bottom up dp
 */
class Solution {
    Integer[] dp;
    public int numDecodings(String s) { // 11% runtime, 74% memory
        dp = new Integer[s.length()];
        if (s.startsWith("0")) {
            System.out.println("0, startsWith zero");
            return 0;
        }
        int ans = numDecodings(s, 0);
        System.out.println(ans);
        return ans;
    }

    private int numDecodings(String s, int index) {
        if (index == s.length()) {
            return 1;
        } else if (index > s.length()) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        char currChar = s.charAt(index);
        int numOfWays;
        if (currChar == '0') {
            numOfWays = 0;
        } else if (currChar == '1') {
            if (index <= s.length() - 2) {
                char nextChar = s.charAt(index + 1);
                if (nextChar == '0') {
                    numOfWays = numDecodings(s, index + 2);
                } else {
                    int oneChar = numDecodings(s, index + 1);
                    int twoChar = numDecodings(s, index + 2);
                    numOfWays = oneChar + twoChar;
                }
            } else {
                numOfWays = numDecodings(s, index + 1);
            }
        } else if (currChar == '2') {
            if (index <= s.length() - 2) {
                char nextChar = s.charAt(index + 1);
                if (nextChar == '0') {
                    numOfWays = numDecodings(s, index + 2);
                } else if (nextChar == '7' || nextChar == '8' || nextChar == '9') {
                    numOfWays = numDecodings(s, index + 1);
                } else {
                    int oneChar = numDecodings(s, index + 1);
                    int twoChar = numDecodings(s, index + 2);
                    numOfWays = oneChar + twoChar;
                }
            } else {
                numOfWays = numDecodings(s, index + 1);
            }
        } else {
            numOfWays = numDecodings(s, index + 1);
        }

        dp[index] = numOfWays;
        return numOfWays;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numDecodings("12");
        sol.numDecodings("226");
        sol.numDecodings("06");
    }
}
