package contests.contests2021.lc0710biweekly.mediumtwo;

import java.util.ArrayList;

class Solution {
    public boolean sumGame(String num) {

        int n = num.length();

        int currentLeftSum = 0;
        int currentRightSum = 0;

        ArrayList<Integer> leftQuestionMarkIndices = new ArrayList<>();
        ArrayList<Integer> rightQuestionMarkIndices = new ArrayList<>();

        for (int i = 0; i < n/2; i++) {
            if (num.charAt(i) != '?') {
                currentLeftSum += Character.getNumericValue(num.charAt(i));
            } else {
                leftQuestionMarkIndices.add(i);
            }
        }

        for (int i = n/2; i < n; i++) {
            if (num.charAt(i) != '?') {
                currentRightSum += Character.getNumericValue(num.charAt(i));
            } else {
                rightQuestionMarkIndices.add(i);
            }
        }

        int numberOfQuestionMarks = leftQuestionMarkIndices.size() + rightQuestionMarkIndices.size();

        System.out.println("AT START " + " currLeft= " + currentLeftSum + " currRight= " + currentRightSum);

        char playersTurn = 'A';

        for (int i = 0; i < numberOfQuestionMarks; i++) {

            int currDifference = currentLeftSum - currentRightSum;

            // IF LAST MOVE
            if (i == numberOfQuestionMarks - 1) {
                if (playersTurn == 'A') {
                    if (rightQuestionMarkIndices.size() > 0) {
                        if (currentLeftSum < currentRightSum) {
                            currentRightSum += 9;
                        } else if (currentLeftSum > currentRightSum) {
                            // currentLeftSum >=  currentRightSum
                            currentRightSum += 0;
                        } else if (currentLeftSum == currentRightSum) {
                            currentRightSum += 9;
                        }
                    } else {
                        // else left.size() > 0
                        if (currentLeftSum < currentRightSum) {
                            currentLeftSum += 0;
                        } else if (currentLeftSum > currentRightSum) {
                            // currentLeftSum >=  currentRightSum
                            currentLeftSum += 9;
                        } else if (currentLeftSum == currentRightSum) {
                            currentLeftSum += 9;
                        }
                    }

                } else {
                    // else bobs turn
                    if (rightQuestionMarkIndices.size() > 0) {
                        if (currentLeftSum < currentRightSum) {
                            currentRightSum += 9;
                        } else if (currentLeftSum > currentRightSum) {
                            // currentLeftSum >=  currentRightSum
                            currentRightSum += Math.min(Math.abs(currDifference), 9);
                        } else if (currentLeftSum == currentRightSum) {
                            currentRightSum += 0;
                        }
                    } else {
                        // else left.size() > 0
                        if (currentLeftSum < currentRightSum) {
                            currentLeftSum += Math.min(Math.abs(currDifference), 9);
                        } else if (currentLeftSum > currentRightSum) {
                            // currentLeftSum >=  currentRightSum
                            currentLeftSum += 0;
                        } else if (currentLeftSum == currentRightSum) {
                            currentLeftSum += 0;
                        }
                    }
                }
                break;
            }

            if (playersTurn == 'A') {

                // IF LEFT SUM LESS
                if (currentLeftSum < currentRightSum && rightQuestionMarkIndices.size() > 0) {
                    int poppedRight = rightQuestionMarkIndices.remove(0);
                    currentRightSum += 9;
                } else  if (currentLeftSum < currentRightSum) {
                    // else leftQUestionMarkIndeces > 0
                    int poppedLeft = leftQuestionMarkIndices.remove(0);
                    currentLeftSum += 0;

                    // TODO - CASE: BOTH SIDES EQUAL, HOW TO CHOOSE LEFT VS RIGHT POP
                // ELSE LEFT SUM MORE
                } else if (currentLeftSum >= currentRightSum && leftQuestionMarkIndices.size() > 0) {
                    int poppedLeft = leftQuestionMarkIndices.remove(0);
                    currentLeftSum += 9;
                } else if (currentLeftSum >= currentRightSum) {
                    // else rightQuestionMarkIndices > 0
                    int poppedRight = rightQuestionMarkIndices.remove(0);
                    currentRightSum += 0;
                }

                playersTurn = 'B';
            } else {
                // else bobs turn

                // IF LEFT SUM LESS
                if (currentLeftSum < currentRightSum && leftQuestionMarkIndices.size() > 0) {
                    int poppedLeft = leftQuestionMarkIndices.remove(0);
                    currentLeftSum += 9;
                } else  if (currentLeftSum < currentRightSum) {
                    // else rightQuestionMarkIndices > 0
                    int poppedRight = rightQuestionMarkIndices.remove(0);
                    currentLeftSum += 0;

                    // TODO - CASE: BOTH SIDES EQUAL, HOW TO CHOOSE LEFT VS RIGHT POP
                    // ELSE LEFT SUM MORE
                } else if (currentLeftSum >= currentRightSum && rightQuestionMarkIndices.size() > 0) {
                    int poppedRight = rightQuestionMarkIndices.remove(0);
                    currentRightSum += 9;
                } else if (currentLeftSum >= currentRightSum) {
                    // else leftQuestionMarkIndices > 0
                    int poppedLeft = leftQuestionMarkIndices.remove(0);
                    currentLeftSum += 0;
                }
                playersTurn = 'A';
            }

//            System.out.println("after turn " + i + " currLeft= " + currentLeftSum + " currRight= " + currentRightSum);
        }




        System.out.println("AT THE END currLeft= " + currentLeftSum + " currRight= " + currentRightSum);

        return currentLeftSum == currentRightSum;



    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.sumGame("5023");
        sol.sumGame("25??");
//        sol.sumGame("?3295???");
    }

}