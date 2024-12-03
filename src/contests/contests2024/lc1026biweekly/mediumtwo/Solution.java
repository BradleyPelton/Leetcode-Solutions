package contests.contests2024.lc1026biweekly.mediumtwo;


// Accepted after 16 minutes
// Accepted first try
// Typical DP problem. Fumbled indexes for a minute or two.

class Solution {

    Integer[][] dp;
    int n;
    int k;
    int[][] stayScore;
    int[][] travelScore;
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        this.n = n;
        this.k = k;
        this.stayScore = stayScore;
        this.travelScore = travelScore;
        dp = new Integer[n][k + 1];
        //      curr_city  number_of_days_remaining
        //  EDGE CASE: Start in the "stayest" city, stay forever


        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int localAns = topDown(i, 0);
            ans = Math.max(ans, localAns);
        }

//        System.out.println(ans);
        return ans;
    }

    private int topDown(int currCity, int currDay) {
        if (currDay == k) {
            return 0;
        }

        if (dp[currCity][currDay] != null) {
            return dp[currCity][currDay];
        }

        int stayCurr = topDown(currCity, currDay + 1) + stayScore[currDay][currCity];
        int travelAway = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i != currCity) {
                int localScore = topDown(i, currDay + 1) + travelScore[currCity][i];
                travelAway = Math.max(travelAway, localScore);
            }
        }

        int ans = Math.max(stayCurr, travelAway);


        dp[currCity][currDay] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxScore(
                2,
                1,
                new int[][]{{2,3}},
                new int[][]{{0,2},{1,0}}
        );
        sol.maxScore(
                3,
                2,
                new int[][]{{3,4,2},{2,1,2}},
                new int[][]{{0,2,1},{2,0,4},{3,2,0}}
        );



    }
}
