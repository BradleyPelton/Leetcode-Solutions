package contests.contests2021.lc0710biweekly.easy;

// Accepted first try
// ACcepted after 11 minutes

// Famous problem
// Find all pythagorean tripples less than n

// Got away with brute force because leetcode doesnt reward usesrs for faster execution time only faster problem acceptance
//

class Solution {
    public int countTriples(int n) {

        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            int targetSum = (int) Math.pow(i,2);

            int low = 1;
            int high = i;

            int iCount = 0;

//            while (high > 0) {
//                int lowSquare = (int) Math.pow(low,2);
//                int highSquare = (int) Math.pow(high,2);
//                if (lowSquare + highSquare == targetSum) {
//                    iCount++;
//                }
//
//                high--;
//                low++;
//            }

            for (int a = 1; a <= i; a++) {
                for (int b = 1; b <= i; b++) {
                    if (Math.pow(a,2) + Math.pow(b,2) == targetSum) {
                        iCount++;
                    }
                }
            }

//            System.out.println("iCOUNT FOR i=" + i + " is equal to " + iCount);
            totalCount += iCount;
        }

        System.out.println("total count " + totalCount);
        return totalCount;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countTriples(5);
        sol.countTriples(10);

    }
}
