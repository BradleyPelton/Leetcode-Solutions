package contests.contests2023.lc0527biweekly.easy;

import java.util.Arrays;

// Accepted after 3 minutes, trivial

class Solution {
    public int buyChoco(int[] prices, int money) {

        Arrays.sort(prices);
        int price1 = prices[0];
        int price2 = prices[1];

        int minPrice = price1 + price2;

        int ans;
        if (minPrice <= money) {
            ans = money - minPrice;
        } else {
            ans = money;
        }

        System.out.println("ans = " + ans);
        return ans;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.buyChoco(
                new int[]{1,2,2},
                3
        );
        sol.buyChoco(
                new int[]{3,2,3},
                3
        );
    }
}