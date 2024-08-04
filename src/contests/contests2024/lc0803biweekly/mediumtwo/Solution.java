package contests.contests2024.lc0803biweekly.mediumtwo;

class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int numberOfOnes = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numberOfOnes++;
                }
            }
        }

        boolean mIsOdd = m % 2 == 1;
        boolean nIsOdd = n % 2 == 1;

        int plusMinusOneOperations = 0;

        int numberOfThreeZeroes = 0;
        int numberOfThreeOnes = 0;

        int numberOfTwo1sAndOne0 = 0;
        int numberOfTwo0sAndOne1 = 0;

        for (int i = 0; i < m/2 + 1; i++) {
            for (int j = 0; j < n/2 + 1; j++) {
                int currValue = grid[i][j];
                int rightValue = grid[i][n - j - 1];
                int downValue = grid[m - i - 1][j];

                if (mIsOdd
                        && nIsOdd
                        && i == m/2
                        && j == n/2) {
                    //this element can be anything
                } else if (mIsOdd
                        && i == m/2) { // center row
                    if (currValue != rightValue) {
                        plusMinusOneOperations++;
                    }
                } else if (nIsOdd
                        && j == n/2) { // middle column
                    if (currValue != downValue) {
                        plusMinusOneOperations++;
                    }
                } else {
                    // two value operations
                    int numberOfLocalOnes = currValue + rightValue + downValue;
                    if (numberOfLocalOnes == 3) {
                        numberOfThreeOnes++;
                    } else if (numberOfLocalOnes == 2) {
                        numberOfTwo1sAndOne0++;
                    } else if (numberOfLocalOnes == 1) {
                        numberOfTwo0sAndOne1++;
                    } else {
                        numberOfThreeZeroes++;
                    }
                }
            }
        }



        int changeAllToZeroesAns = (m * n) - ((m*n) - numberOfOnes);
        int changeAllToOnesAns = (m*n % 4 == 0) ? (m*n) - numberOfOnes : Integer.MAX_VALUE;
        int ans = Math.min(changeAllToZeroesAns, changeAllToOnesAns);

        if (m * n <= 4) {
            System.out.println(ans);
            return ans;
        }


        int localOperations = plusMinusOneOperations + (2 * (numberOfTwo0sAndOne1 + numberOfTwo1sAndOne0));
        if (numberOfOnes % 4 == 0) {


            // GOAL: Maintain the balance of Ones
            int balance = ((2 * numberOfTwo0sAndOne1) + (2 * numberOfTwo1sAndOne0) + plusMinusOneOperations) % 2;
            if (balance == 0) {
                ans = Math.min(ans, localOperations);
            } else { // FUNDAMENTAL IMBALANCE
                boolean wildcard = mIsOdd && nIsOdd;
                if (wildcard) {
                    ans = Math.min(ans, localOperations + 1);
                } else {
                    ans = Math.min(ans, localOperations + 2);
                }
            }
        } else if (numberOfOnes % 4 == 1 || numberOfOnes % 4 == 3) {
            int balance = ((2 * numberOfTwo0sAndOne1) + (2 * numberOfTwo1sAndOne0) + plusMinusOneOperations) % 2;
            if (balance == 1) {
                ans = Math.min(ans, localOperations);
            } else { // FUNDAMENTAL IMBALANCE
                boolean wildcard = mIsOdd && nIsOdd;
                if (wildcard) {
                    ans = Math.min(ans, localOperations + 1);
                } else {
                    ans = Math.min(ans, localOperations + 2);
                }
            }
        } else if (numberOfOnes % 4 == 2) {
            int balance = ((2 * numberOfTwo0sAndOne1) + (2 * numberOfTwo1sAndOne0) + plusMinusOneOperations) % 2;
            if (balance == 0) {
                ans = Math.min(ans, localOperations);
            } else { // FUNDAMENTAL IMBALANCE
                boolean wildcard = mIsOdd && nIsOdd;
                if (wildcard) {
                    ans = Math.min(ans, localOperations + 1);
                } else {
                    ans = Math.min(ans, localOperations + 2);
                }
            }
        } else {
            throw new IllegalStateException("unreachable mod 4");
        }


        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minFlips(
                new int[][]{{1,0,0},{0,1,0},{0,0,1}}
        );
        sol.minFlips(
                new int[][]{{0,1},{0,1},{0,0}}
        );
        sol.minFlips(
                new int[][]{{1},{1}}
        );




    }
}
