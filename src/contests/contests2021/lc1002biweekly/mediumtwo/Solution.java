package contests.contests2021.lc1002biweekly.mediumtwo;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {


        int leftIndex = 0;
        int rightIndex = 1;  // EXCLUSIVE

        int currentWindowSize = 1;
        int numberOfFalses = answerKey.charAt(0) == 'T' ? 0 : 1;
        while (true) {
//            char nextChar = answerKey.charAt(rightIndex + 1);
            System.out.println("Current window = " + answerKey.substring(leftIndex, rightIndex));


            rightIndex++;

            if (rightIndex >= answerKey.length() || leftIndex > answerKey.length()) {
                break;
            }
        }
        return 0;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.maxConsecutiveAnswers("TTFF", 2);
    }
}
