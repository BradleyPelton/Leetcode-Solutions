package contests.contests2024.lc0127.mediumtwo;




// x in clockwise around
// y in counter-clockwise around

// choose clockwise or counter-clockwise
// decrement that side

// Alice only wins if there are a odd number of total flowers
// Count the number of

// 1, 2
// 1, 4
// 1, 6
// ...

// 2,1
// 2,3
// 2,5
//...

// 3, 2
//


// First attempt memory exceeded. We can't use a DP array apparently
// Second attempt wrong answer.


// Accepted third attempt
// Spent 10 minutes debugging an off by one error, only to find out the the return type is long, not int.
// Arggggggg java. Gave away my advantage.

class Solution {

    public long flowerGame(int n, int m) {
        if (n == 1 && m == 1) {
            System.out.println("0, trivial");
            return 0;
        }

        long numberOfEvensForN = numberOfEvens(n);
        long numberOfOddsForN = numberOfOdds(n);

        long numberOfEvensForM = numberOfEvens(m);
        long numberOfOddsForM = numberOfOdds(m); // 1,3,5,7


        long ans = numberOfEvensForN * numberOfOddsForM
                + numberOfOddsForN * numberOfEvensForM;

        System.out.println(ans);
        return ans;
    }

    private long numberOfEvens(long upper) {
        // 1..upper
        if (upper % 2 == 0) { // 1..6 = 2,4,6
            return upper / 2;
        } else {
            return (upper - 1) / 2;
        }
    }

    private long numberOfOdds(long upper) {
        //1..upper
        if (upper % 2 == 1) { // 1..7 == 1,3,5,7
            return (upper + 1) / 2;
        } else {
            return upper / 2;
        }
    }

//    private int getCount(int leftRemaining, int rightRemaining) {
//        if (leftRemaining <= 0 || rightRemaining <= 0 || (leftRemaining == 1 && rightRemaining == 1)) {
//            return 0;
//        }
//
//        if (dp[leftRemaining][rightRemaining] != null) {
//            return dp[leftRemaining][rightRemaining];
//        }
//
//        int totalCount = 0;
//        if (leftRemaining % 2 == 0) {
//            if (rightRemaining % 2 == 0) {
//                totalCount = getCount(leftRemaining - 1, rightRemaining)
//                        + getCount(leftRemaining, rightRemaining - 1);
//            } else {
//                totalCount = getCount(leftRemaining - 1, rightRemaining)
//                        + getCount(leftRemaining, rightRemaining - 1)
//                        + 1;
//            }
//        } else { // leftRemaining % 2 == 1
//            if (rightRemaining % 2 == 0) {
//                totalCount = getCount(leftRemaining - 1, rightRemaining)
//                        + getCount(leftRemaining, rightRemaining - 1)
//                        + 1;
//            } else {
//                totalCount = getCount(leftRemaining - 1, rightRemaining)
//                        + getCount(leftRemaining, rightRemaining - 1);
//            }
//        }
//
//        dp[leftRemaining][rightRemaining] = totalCount;
//        return totalCount;
//    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.flowerGame(3, 2); // 3
        sol.flowerGame(1, 1); // 0






        sol.flowerGame(1, 7); // 1,2 , 1,4 , 1,6







    }
}