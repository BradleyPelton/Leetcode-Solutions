package contests.contests2021.lc0717.easy;

// Accepted after 5 minutes, trivial
// Accepted first try

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        String[] words = text.split(" ");

        int ans = 0;
        wordLoop:
        for (String word : words) {
            charloop:
            for (int i = 0; i < word.length(); i++) {
                String charStr = String.valueOf(word.charAt(i));
                if (brokenLetters.contains(charStr)) {
                    continue wordLoop;
                }
            }
            ans++;
        }

        System.out.println("final ans " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canBeTypedWords("hello world", "ad");
        sol.canBeTypedWords("leet code", "lt");
        sol.canBeTypedWords("leet code", "e");

    }
}
