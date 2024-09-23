package contests.contests2024.lc0921.easy;

import java.util.HashSet;
import java.util.Set;

// Accepted after 3 minutes
// Trivial

class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {

        Set<String> wordsSet = new HashSet<>();
        for (String word : bannedWords) {
            wordsSet.add(word);
        }

        int bannedWordCount = 0;
        for (String word : message) {
            if (wordsSet.contains(word)) {
                bannedWordCount++;
            }
        }

        boolean isMessageSpam = bannedWordCount >= 2;
        System.out.println(isMessageSpam);
        return isMessageSpam;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.reportSpam(
                new String[]{"hello","world","leetcode"},
                new String[]{"world","hello"}
        );
        sol.reportSpam(
                new String[]{"hello","programming","fun"},
                new String[]{"world","programming","leetcode"}
        );



    }
}
