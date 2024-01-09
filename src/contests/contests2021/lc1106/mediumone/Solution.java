package contests.contests2021.lc1106.mediumone;

class Solution {
    public long countVowels(String word) {

        long ans = 0;

        // How frequently does a random character appear in the list of all substrings
        // First hypothesis: It varies. Edge characters appear less frequently than center characters
        for (int i = 0; i < word.length(); i++) {
            char nextChar = word.charAt(i);
            if (nextChar == 'a'
                    || nextChar == 'e'
                    || nextChar == 'i'
                    || nextChar == 'o'
                    || nextChar == 'u'
            ) {
                long charsToTheLeft = i;
                long charsToTheRight = word.length() - 1 - i;
                ans += (1 + charsToTheLeft) * Long.max(1, charsToTheRight);
            }
        }

        System.out.println("final ans = " + ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countVowels("aba");
//        sol.countVowels("abc");
//        sol.countVowels("ltcd");
//        sol.countVowels("noosabasboosa");

    }
}
