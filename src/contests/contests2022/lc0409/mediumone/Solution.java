package contests.contests2022.lc0409.mediumone;

import java.util.ArrayList;
import java.util.List;

// Beautiful problem
// Accepted first try, everything worked the first time I typed it (expect String.split funny enough)
// What an amazing feeling. No IndexOutOfBound exceptions, no cast exceptions, everything just worked flawlessly.

// This is what progress feels like



class Solution {
    public String minimizeResult(String expression) {

        String[] splitVals = expression.split("\\+");

        String leftVal = splitVals[0];
        String rightVal = splitVals[1];


        // 247+38
        List<String> leftInserts = new ArrayList<>();
        for (int i = 0; i < leftVal.length(); i++) {
            StringBuilder sb = new StringBuilder(leftVal);
            sb.insert(i, '(');
//            System.out.println(sb.toString());
            leftInserts.add(sb.toString());
        }

        List<String> rightInserts = new ArrayList<>();
        for (int i = 1; i < rightVal.length() + 1; i++) {
            StringBuilder sb = new StringBuilder(rightVal);
            sb.insert(i, ')');
//            System.out.println(sb.toString());
            rightInserts.add(sb.toString());
        }


        long smallestVal = Long.MAX_VALUE;
        String answerString = null;
        for (String leftString : leftInserts) {
            for (String rightString : rightInserts) {
                String fullExpression = leftString + "+" + rightString;
//                System.out.println("fullExpression = " + fullExpression);

                long valueOfExpression = evalExpression(fullExpression);
                if (valueOfExpression < smallestVal) {
                    smallestVal = valueOfExpression;
                    answerString = fullExpression;
                }
            }
        }


        System.out.println("final ans = " + answerString);
        return answerString;
    }

    public long evalExpression(String expr) {
        StringBuilder leftMultiple = new StringBuilder();
        StringBuilder rightMultiple = new StringBuilder();
        StringBuilder leftInnerSum = new StringBuilder();
        StringBuilder rightInnerSum = new StringBuilder();

        int currIndex = 0;

        // left multiple
        for (int i = currIndex; i < expr.length(); i++) {
            char nextChar = expr.charAt(i);

            if (nextChar == '(') {
                break;
            } else {
                leftMultiple.append(nextChar);
            }
        }

        currIndex = leftMultiple.length() + 1;

        // left inner sum
        for (int i = currIndex; i < expr.length(); i++) {
            char nextChar = expr.charAt(i);

            if (nextChar == '+') {
                break;
            } else {
                leftInnerSum.append(nextChar);
            }
        }

        currIndex = leftMultiple.length() + 1 + leftInnerSum.length() + 1;

        // right inner sum
        for (int i = currIndex; i < expr.length(); i++) {
            char nextChar = expr.charAt(i);

            if (nextChar == ')') {
                break;
            } else {
                rightInnerSum.append(nextChar);
            }
        }

        currIndex = leftMultiple.length() + 1 + leftInnerSum.length() + 1 + rightInnerSum.length() + 1;

        // right inner sum
        for (int i = currIndex; i < expr.length(); i++) {
            char nextChar = expr.charAt(i);

            rightMultiple.append(nextChar);
        }

        long innerSum = Integer.parseInt(leftInnerSum.toString()) + Integer.parseInt(rightInnerSum.toString());
        long leftMultipleVal = leftMultiple.length() > 0 ? Integer.parseInt(leftMultiple.toString()) : 1;
        long rightMultipleVal = rightMultiple.length() > 0 ? Integer.parseInt(rightMultiple.toString()) : 1;

        long val = (innerSum) * leftMultipleVal * rightMultipleVal;
//        System.out.println(val);
        return val;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // UNIT TESTS FOR evalExpression
//        sol.evalExpression("2(47+38)");
//        sol.evalExpression("1(2+3)4");
//        sol.evalExpression("(999+999)");


        sol.minimizeResult("247+38");
        sol.minimizeResult("12+34");
        sol.minimizeResult("999+999");
    }
}