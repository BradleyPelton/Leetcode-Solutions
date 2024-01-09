package contests.contests2021.lc0821biweekly.mediumone;

import java.util.Arrays;

// Accepted first try at 11:24 am

// Trick question. I was trying to greedily choose which element to flip
// The best solution was a trick to move the negatives around
// There will at most ever be 1 or 0 negative numbers
// Choose the smallest number to be the scape goat

class Solution {
    public long maxMatrixSum(int[][] matrix) {

        long startingSum = Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();

        // WE CAN "MOVE" negative signs around by

        int numberOfNegativeNumbers = 0;
        boolean hasAZero = false;
        long smallestVal = Long.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int val = matrix[i][j];
                if (val < 0) {
                    numberOfNegativeNumbers++;
                } else if (val == 0) {
                    hasAZero = true;
                }

                if (Math.abs(val) < smallestVal) {
                    smallestVal = Math.abs(val);
                }
            }
        }

        long finalAns = 0;
        if (numberOfNegativeNumbers % 2 == 0 || hasAZero) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    finalAns += Math.abs(matrix[i][j]);
                }
            }
//        } else if (numberOfNegativeNumbers % 1 == 1 && !hasAZero) {
        } else {
            // find the smallest val and use it as the scape goat
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    finalAns += Math.abs(matrix[i][j]);
                }
            }
            finalAns -= smallestVal * 2;
        }

        System.out.println("final ans is " + finalAns);
        return finalAns;

//        long currSum = startingSum;
//
//        while (true) {
//            int numOfChanges = 0;
//
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix.length; j++) {
//                    int val = matrix[i][j];
//
//                    // left neighbor
//                    if (j > 0) {
//                        int leftNeighbor = matrix[i][j-1];
//
//                        if (leftNeighbor <= 0 && val < 0) {
//                            currSum += leftNeighbor * -1;
//                            currSum += val * -1;
//                            numOfChanges++;
//                            matrix[i][j-1] *= -1;
//                            matrix[i][j] *= -1;
//                            continue;
//                        } else if (leftNeighbor > 0 && val < 0) {
//                            if (Math.abs(leftNeighbor) < Math.abs(val)) {  // if val is more important
//                                currSum += leftNeighbor * -1;
//                                currSum += val * -1;
//                                numOfChanges++;
//                                matrix[i][j-1] *= -1;
//                                matrix[i][j] *= -1;
//                                continue;
//                            }
//                        }
//                    }
//                    // right neighbor
//                    if (j < matrix.length - 1) {
//                        int rightNeighbor = matrix[i][j+1];
//
//                        if (rightNeighbor <= 0 && val < 0) {
//                            currSum += rightNeighbor * -1;
//                            currSum += val * -1;
//                            numOfChanges++;
//                            matrix[i][j+1] *= -1;
//                            matrix[i][j] *= -1;
//                            continue;
//                        } else if (rightNeighbor > 0 && val < 0) {
//                            if (Math.abs(rightNeighbor) < Math.abs(val)) {  // if val is more important
//                                currSum += rightNeighbor * -1;
//                                currSum += val * -1;
//                                numOfChanges++;
//                                matrix[i][j+1] *= -1;
//                                matrix[i][j] *= -1;
//                                continue;
//                            }
//                        }
//                    }
//
//                    // up neighbor
//                    if (i > 0) {
//                        int upNeighbor = matrix[i-1][j];
//
//                        if (upNeighbor <= 0 && val < 0) {
//                            currSum += upNeighbor * -1;
//                            currSum += val * -1;
//                            numOfChanges++;
//                            matrix[i-1][j] *= -1;
//                            matrix[i][j] *= -1;
//                            continue;
//                        } else if (upNeighbor > 0 && val < 0) {
//                            if (Math.abs(upNeighbor) < Math.abs(val)) {  // if val is more important
//                                currSum += upNeighbor * -1;
//                                currSum += val * -1;
//                                numOfChanges++;
//                                matrix[i-1][j-1] *= -1;
//                                matrix[i][j] *= -1;
//                                continue;
//                            }
//                        }
//                    }
//
//                    // down neighbor
//                    if (i < matrix.length - 1) {
//                        int downNeighbor = matrix[i+1][j];
//
//                        if (downNeighbor <= 0 && val < 0) {
//                            currSum += downNeighbor * -1;
//                            currSum += val * -1;
//                            numOfChanges++;
//                            matrix[i+1][j] *= -1;
//                            matrix[i][j] *= -1;
//                            continue;
//                        } else if (downNeighbor > 0 && val < 0) {
//                            if (Math.abs(downNeighbor) < Math.abs(val)) {  // if val is more important
//                                currSum += downNeighbor * -1;
//                                currSum += val * -1;
//                                numOfChanges++;
//                                matrix[i+1][j-1] *= -1;
//                                matrix[i][j] *= -1;
//                                continue;
//                            }
//                        }
//                    }
//                }
//            }
//
//            System.out.println(Arrays.deepToString(matrix));
//            System.out.println("number of changes " + numOfChanges);
//
//            if (numOfChanges == 0) {
//                break;
//            }
//        }
//
//
//        System.out.println("final sum is " + currSum);
//        return currSum;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] firstArr = {{1,-1},{-1,1}};
        int[][] secondArr = {{1,2,3},{-1,-2,-3},{1,2,3}};

        sol.maxMatrixSum(firstArr);
        sol.maxMatrixSum(secondArr);

    }
}