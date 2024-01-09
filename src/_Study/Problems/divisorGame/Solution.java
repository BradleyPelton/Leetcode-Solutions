package _Study.Problems.divisorGame;

class Solution {
    Boolean[] dp;
    public boolean divisorGameBottomUp(int n) {
        dp = new Boolean[n + 1];
        dp[0] = true;
        dp[1] = false;

        // Let dp[i] == true if the person wins whose turn it is at i
        OUTER_LOOP:
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (!dp[i - j]) { // current player at i can force other player to lose at i - j
                        dp[i] = true;
                        continue OUTER_LOOP;
                    }
                }
            }
            dp[i] = false;
            System.out.println("reached the end of inner loop");
        }

        boolean ans = dp[n];
        System.out.println(ans);
        return ans;
    }
    public boolean divisorGameTopDown(int n) {
        dp = new Boolean[n + 1];
        dp[0] = true;
        dp[1] = false;
        divisorGameScore(n);
        boolean ans = dp[n];
        System.out.println(ans);
        return ans;
    }

    private boolean divisorGameScore(int n) { // return true if the player wins at turn when val = n
        if (dp[n] != null) {
            return dp[n];
        }

        for (int i = 1; i < n; i++) {
            if (n % i  == 0) {
                if (!divisorGameScore(n - i)) {  // current player at i can force other player to lose at i - j
                    dp[n] = true;
                    break;
                }
            }
            dp[n] = false;
        }
        return dp[n];
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.divisorGame(2);   // true
//        sol.divisorGame(3);   // false
//        sol.divisorGame(465); // false
    }
}
