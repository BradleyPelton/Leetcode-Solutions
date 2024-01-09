package contests.contests2023.lc0311.easy;


import java.util.List;

// Accepted after 3minutes
// Trivial. "I am speed" meme

class Solution {
    public int vowelStrings(String[] words, int left, int right) {

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

        int ans = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (!vowels.contains(word.charAt(0))) {
                continue;
            }
            if (!vowels.contains(word.charAt(word.length() - 1))) {
                continue;
            }
            ans++;
        }
        System.out.println("ans = " + ans);
        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.vowelStrings(new String[]{"are","amy","u"}, 0 ,2 );
        sol.vowelStrings(new String[]{"hey","aeo","mu","ooo","artro"}, 1 ,4 );
    }
}