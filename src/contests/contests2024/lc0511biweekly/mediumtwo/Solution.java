package contests.contests2024.lc0511biweekly.mediumtwo;

// Accepted after 23 minutes
// Accepted after first attempt
// Another typical string DP problem. Fumbled around with the subproblem calls.


// Big O (n ** 2)


class Solution {
    // BOTTOM UP
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            int localAns = Integer.MAX_VALUE;

            int[] charCount = new int[26];
            for (int j = i; j < n; j++) {
                charCount[s.charAt(j) - 'a']++;
                if (isCharBalanced(charCount)) {
                    localAns = Math.min(localAns, dp[j + 1] + 1);
                }
            }
            dp[i] = localAns;
        }


        return dp[0];
//        int ans = dp[0];
//        System.out.println(ans);
//        return ans;
    }


    // TOP DOWN
//    Integer[] dp;
//    private int n;
//    String s;
//    public int minimumSubstringsInPartition(String s) {
//        this.s = s;
//        n = s.length();
//        dp = new Integer[n];
//
//
//        int ans = partition(0);
//        System.out.println(ans);
//        return ans;
//    }
//
//    private int partition (int index) {
//        if (index >= n) {
//            return 0;
//        }
//
//        if (dp[index] != null) {
//            return dp[index];
//        }
//
//        int ans = Integer.MAX_VALUE;
//        int[] charCount = new int[26];
//        for (int i = index; i < n; i++) {
//            charCount[s.charAt(i) - 'a']++;
//            if (isCharBalanced(charCount)) {
//
//                int localAns = partition(i + 1);
//                if (localAns != Integer.MAX_VALUE) {
//                    localAns++;
//                    ans = Math.min(ans, localAns);
//                }
//            }
//        }
//
//        dp[index] = ans;
//        return ans;
//    }
//
    private boolean isCharBalanced(int[] occs) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int occ : occs) {
            if (occ != 0) {
                min = Math.min(min, occ);
                max = Math.max(max, occ);
            }
        }
        return min == max;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumSubstringsInPartition("fabccddg");
        sol.minimumSubstringsInPartition("abababaccddb");




    }
}