package _Study.Problems.numberOfMatchingSubsequences;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 792. Number of Matching Subsequences
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 *
 *
 * TODO - ANALYZE MY SOLUTION. I don't think this is dp
 *
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        // Note the famous DP problem : Length of longest common subsequence.
        // This problem is effectively, count the number of lOLCS(s1,s2) == s1.


        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dp.add(new ArrayList<>());
        }
        Map<Character, Integer> currentOccMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offsetIndex = c - 97;
            dp.get(offsetIndex).add(i);
        }


        int ans = 0;
        WORD_LOOP:
        for (String word : words) {
            int sIndex = s.length() - 1;
            List<List<Integer>> dpCopy = new ArrayList<>();
            for (List<Integer> dpArr : dp) {
                dpCopy.add(new ArrayList<>(dpArr));
            }

            for (int i = word.length() - 1; i >= 0; i--) {
                if (sIndex < 0) {
                    continue WORD_LOOP;
                }
                char nextChar = word.charAt(i);
                int charAsInt = nextChar - 97;
                List<Integer> charList = dpCopy.get(charAsInt);

                while (true) {
                    if (charList.isEmpty()) { // not enough chars
                        continue WORD_LOOP;
                    }
                    int nextAvailable = dpCopy.get(charAsInt).remove(charList.size() - 1);
                    if (nextAvailable > sIndex) {
                        continue;
                    } else {
                        sIndex = nextAvailable - 1;
                        break;
                    }
                }
            }
            // WORD FINISHED
            ans++;
        }
        System.out.println(ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numMatchingSubseq(
                "abcde",
                new String[]{"a","bb","acd","ace"}
        );
        sol.numMatchingSubseq(
                "dsahjpjauf",
                new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}
        );
    }
}
