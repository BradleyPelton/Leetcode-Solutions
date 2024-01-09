package contests.contests2023.lc1118.easy;

// Acceptgged after 29 minutes
//dsfiougjhwedrgjkuhdsrflukjghdfskgvljshjdfkjlghdfsg
// DP TLE. What the actual fuck.

class Solution {
    int[][][] dp;
    public int findMinimumOperations(String s1, String s2, String s3) {
        if (s1.equals(s2) && s2.equals(s3)) {
            System.out.println("trivial true, 0");
            return 0;
        }

        int maxLengthString = Math.max(s1.length(), Math.max(s2.length(), s3.length()));

        int maxLengthSubString = Integer.MIN_VALUE;
        for (int i = 1; i <= maxLengthString; i++) {

            String s1Sub = i > s1.length() ? s1 : s1.substring(0, i);
            String s2Sub = i > s2.length() ? s2 : s2.substring(0, i);
            String s3Sub = i > s3.length() ? s3 : s3.substring(0, i);

            if (s1Sub.equals(s2Sub) && s2Sub.equals(s3Sub)) {
                maxLengthSubString = Math.max(maxLengthSubString, i);
            }
        }

        int ans = -1;
        if (maxLengthSubString == Integer.MIN_VALUE) {
            ans = -1;
        } else {
            int s1CharsLost = s1.length() - maxLengthSubString;
            int s2CharsLost = s2.length() - maxLengthSubString;
            int s3CharsLost = s3.length() - maxLengthSubString;
            ans = s1CharsLost + s2CharsLost + s3CharsLost;
        }

        System.out.println(ans);
        return ans;
        
        
        
        
    }
//    public int findMinimumOperations(String s1, String s2, String s3) {
//        dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
//            }
//        }
//
//        if (s1.equals(s2) && s2.equals(s3)) {
//            System.out.println("trivial true, 0");
//            return 0;
//        }
//
////        int minAns = Integer.MAX_VALUE;
////        for (int i = 0; i < s1.length() - 2; i++) {
////            String s1SubString = s1.substring(0, s1.length() - i);
////            for (int j = 0; j < s2.length() - 2; j++) {
////                String s2SubString = s2.substring(0, s2.length() - j);
////                for (int k = 0; k < s3.length() - 2; k++) {
////                    String s3SubString = s3.substring(0, s3.length() - k);
////                    if (s1SubString.equals(s2SubString) && s2SubString.equals(s3SubString)) {
//////                        System.out.println(s1SubString);
//////                        System.out.println(s2SubString);
//////                        System.out.println(s3SubString);
////                        int numOfOps = i + j + k;
//////                        System.out.println(numOfOps);
////                        minAns = Math.min(minAns, numOfOps);
////                    }
////                }
////            }
////        }
//
//        int minAns = minOps(s1, s2, s3);
//        if (minAns == Integer.MAX_VALUE) {
//            minAns = -1;
//        }
//
//        System.out.println(minAns);
//        return minAns;
//    }
//
//    private int minOps(String s1, String s2, String s3) {
//        if (s1.equals(s2) && s2.equals(s3)) {
//            return 0;
//        }
//
//        if (dp[s1.length()][s2.length()][s3.length()] != Integer.MAX_VALUE) {
//            return dp[s1.length()][s2.length()][s3.length()];
//        }
//
//        int s1Pop = Integer.MAX_VALUE;
//        if (s1.length() >= 2) {
//            String s1Sub = s1.substring(0, s1.length() - 1);
//            s1Pop =  minOps(s1Sub, s2, s3);
//        }
//
//        int s2Pop = Integer.MAX_VALUE;
//        if (s2.length() >= 2) {
//            String s2Sub = s2.substring(0, s2.length() - 1);
//            s2Pop =  minOps(s1, s2Sub, s3);
//        }
//
//        int s3Pop = Integer.MAX_VALUE;
//        if (s3.length() >= 2) {
//            String s3Sub = s3.substring(0, s3.length() - 1);
//            s3Pop =  minOps(s1, s2, s3Sub);
//        }
//
//        int minVal = Math.min(s1Pop, Math.min(s2Pop, s3Pop));
//        if (minVal != Integer.MAX_VALUE) {
//            minVal += 1;
//        }
//        dp[s1.length()][s2.length()][s3.length()] = minVal;
//        return minVal;
//
//    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findMinimumOperations(
                "abc",
                "abb",
                "ab"
        );
        sol.findMinimumOperations(
                "dac",
                "bac",
                "cac"
        );
        sol.findMinimumOperations(
                "a",
                "a",
                "a"
        ); // 0
        sol.findMinimumOperations(
                "a",
                "aabc",
                "a"
        );  //expeceted 3
    }
}
