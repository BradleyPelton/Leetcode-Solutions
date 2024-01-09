package contests.contests2021.lc1016.easy;

// Accepted after 5 minutes
// Trivial

class Solution {
    public boolean areNumbersAscending(String s) {

        String[] words = s.split(" ");

        int previousVal = Integer.MIN_VALUE;
        for (String word : words) {
            try {
                int wordVal = Integer.valueOf(word);
                if (wordVal <= previousVal) {
                    System.out.println("problem found, wordVal = " + wordVal + " previousVal = " + previousVal);
                    return false;
                } else {
                    previousVal = wordVal;
                }
            } catch (NumberFormatException e) {
                ;
            }
        }

        System.out.println("finished, no errors, returning true");
        return true;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
        sol.areNumbersAscending("hello world 5 x 5");
        sol.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s");
        sol.areNumbersAscending("4 5 11 26");

    }
}
