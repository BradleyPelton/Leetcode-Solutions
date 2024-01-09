package contests.contests2023.lc0624biweekly.easy;

// Accepted after 13 minutes
// Accepted after first attempt

// Pretty tricky easy question

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {

        int[] alreadyPaired = new int[words.length];

        int numberOfPairs = 0;

        OUTER_LOOP:
        for (int i = 0; i < words.length; i++) {
            if (alreadyPaired[i] == 1) {
                continue OUTER_LOOP;
            }
            String word = words[i];
            String reveredWord = new StringBuilder(word).reverse().toString();

            INNER_LOOP:
            for (int j = i + 1; j < words.length; j++) {
                if (alreadyPaired[j] == 1) {
                    continue INNER_LOOP;
                }
                String nextWord = words[j];
                if (reveredWord.equals(nextWord)) {
                    numberOfPairs++;
                    alreadyPaired[i] = 1;
                    alreadyPaired[j] = 1;
                }

            }

        }

        System.out.println("ans = " + numberOfPairs);
        return numberOfPairs;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumNumberOfStringPairs(new String[]{"cd","ac","dc","ca","zz"});
        sol.maximumNumberOfStringPairs(new String[]{"ab","ba","cc"});
        sol.maximumNumberOfStringPairs(new String[]{"aa","ab"});
    }
}
