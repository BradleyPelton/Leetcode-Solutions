package contests.contests2021.lc1113.easy;

// Accepted after 8 minutes

// Brain teaser. Cool problem

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int ans = 0;


        for (int i = 0; i < tickets.length; i++) {
            if (i < k) {
                ans += Math.min(tickets[i], tickets[k]);
            } else if (i == k) {
                ans += tickets[k];
            } else {
                ans += Math.min(tickets[i], tickets[k] - 1);
            }

        }

        System.out.println("final ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.timeRequiredToBuy(new int[]{2,3,2}, 2);
        sol.timeRequiredToBuy(new int[]{5,1,1,1}, 0);





    }
}
