package _Study.Problems.decodeWays;


/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/description/
 *
 * // Just a bunch of edge cases, not a great learning experience.
 */
class Solution {
    public int numDecodings(String s) { // Bottom Up DP - Space Optimized - 80% runtime, 70% memory
        int n = s.length();
        if (s.charAt(0) == '0') {
//            System.out.println("0, trivial start");
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int prevSecond = 1; // manually handle the first two scenarios
        int prev;
        if (s.charAt(0) == '1') {
            if (s.charAt(1) == '0') {
                prev = 1;
            } else {
                prev = 2;
            }
        } else if (s.charAt(0) == '2') {
            if (s.charAt(1) == '0') {
                prev = 1;
            } else if (s.charAt(1) >= '1' && s.charAt(1) <= '6') {
                prev = 2;
            } else {
                prev = 1;
            }
        } else {
            if (s.charAt(1) == '0') {
                System.out.println("0, zero after 3>");
                return 0;
            } else {
                prev = 1;
            }
        }

        char prevChar = s.charAt(1);
        for (int i = 2; i < n; i++) {
            char currChar = s.charAt(i);
            int next;
            if (currChar == '0') {
                if (prevChar == '0') {
//                    System.out.println("0, runner runner zero");
                    return 0;
                } else if (prevChar == '1' || prevChar == '2') {
                    next = prevSecond;
                } else {
//                    System.out.println("0, zero after 3>");
                    return 0;
                }
            } else {
                if (prevChar == '2') {
                    if (currChar >= '0' && currChar <= '6') {
                        next = prev + prevSecond;
                    } else {
                        next = prev;
                    }
                } else if (prevChar == '1') {
                    next = prev + prevSecond;
                } else {
                    next = prev;
                }
            }
            prevSecond = prev;
            prev = next;
            prevChar = currChar;
        }
//        System.out.println(prev);
        return prev;
    }



    Integer[] dp;
    public int numDecodingsTOPDOWN(String s) { // Top Down DP - 11% runtime, 74% memory
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
        sol.numDecodings("12"); // 2
        sol.numDecodings("226"); // 3
        sol.numDecodings("06"); // 0
        sol.numDecodings("27"); // 1
        sol.numDecodings("2101"); // 1
    }
}
