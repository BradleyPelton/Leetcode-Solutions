package contests.contests2020.lc0815biweekly.easy;

// Accepted frist attempt
// Acceptec after 18 minutes
// Fumbled around with modulus for wayyyyy to long

class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {

        int initialAmount = 100;
        int exactSubtract = initialAmount - purchaseAmount;

        int ans;

        if (exactSubtract == 0) {
            ans = 0;
            System.out.println("returning exact 0");
            return ans;
        }

        int modTen = exactSubtract % 10;  // 7
        // 37
        int roundUp = purchaseAmount - (10 - modTen) + 10;
        int roundDown = purchaseAmount - (10 - modTen);

        int roundUpDiff = Math.abs(purchaseAmount - roundUp);
        int roundDownDiff = Math.abs(purchaseAmount - roundDown);

        if (roundUpDiff < roundDownDiff) {
            ans = initialAmount - roundUp;
        } else if (roundDownDiff < roundUpDiff){
            ans = initialAmount - roundDown;
        } else if (roundDownDiff == roundUpDiff) {
            ans = initialAmount - roundUp;
        } else {
            ans = -42;
        }

        System.out.println("ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.accountBalanceAfterPurchase(9);
        sol.accountBalanceAfterPurchase(15);
        sol.accountBalanceAfterPurchase(11);







    }
}
