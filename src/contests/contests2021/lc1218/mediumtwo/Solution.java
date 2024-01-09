package contests.contests2021.lc1218.mediumtwo;

// Rejected first attempt (wrong answer, off by one)
// Rejected second attempt (wrong answer; hidden)

// Accepted after third attempt
// Fucking long vs int bullshit made me lost 20 minutes

class Solution {
    public long getDescentPeriods(int[] prices) {

        if (prices.length == 1) {
            System.out.println("trivial ans = " + 1);
            return 1;
        }

//        int ans = 0;
//
//        int periodLength = 1;
//        for (int i = 1; i < prices.length; i++) {
//            int prev = prices[i-1];
//            int curr = prices[i];
//
//            if (curr == prev - 1) {
//                periodLength++;
//                if (i == prices.length - 1) {  // if last index
//                    int triangularNumber = ((periodLength+1)*periodLength)/2;
//                    ans += triangularNumber;
//                } else {
//                    continue;
//                }
//            } else {
//                int triangularNumber = ((periodLength+1)*periodLength)/2;
//                ans += triangularNumber;
//                periodLength = 1;
//                if (i == prices.length - 1) {  // if last index
//                    ans += 1;
//                }
//            }
//        }

        long ans = 0;

        long periodLength = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                periodLength++;
                continue;
            }
            int prev = prices[i-1];
            int curr = prices[i];

            if (curr == prev - 1) {
                periodLength++;
                if (i == prices.length - 1) {
                    // if the last index, cash out
                    long triangularNumber = (((periodLength + 1) * periodLength)) / 2;
                    ans += triangularNumber;
                } else {
                    continue;
                }
            } else {
                long triangularNumber = ((periodLength + 1) * periodLength) / 2;
                ans += triangularNumber;

                if (i == prices.length - 1) {
                    // if the last index, cash out
                    ans += 1;
                }
                periodLength = 1;
            }
        }

//        System.out.println("final ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();

        sol.getDescentPeriods(new int[]{3,2,1,4});
        sol.getDescentPeriods(new int[]{8,6,7,7});
        sol.getDescentPeriods(new int[]{1});
        sol.getDescentPeriods(new int[]{12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7}); // expected 68


    }
}
