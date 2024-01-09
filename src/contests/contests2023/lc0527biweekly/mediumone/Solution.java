package contests.contests2023.lc0527biweekly.mediumone;

import java.util.Arrays;
import java.util.Comparator;

// First attempt wrong answer

class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        Arrays.sort(dictionary, Comparator.comparing(String::length).reversed());
//        System.out.println(Arrays.toString(dictionary));
        
        int minLengthAferAllReplacements = Integer.MAX_VALUE;

        String currentSubString = "";
        OUTER_LOOP:
        for (int i = 0; i < s.length(); i++) {
            currentSubString += String.valueOf(s.charAt(i));

            for (String word : dictionary) {
                if (word.equals(currentSubString)) {
                    continue OUTER_LOOP;
                }
            }
        }

        for (String word : dictionary) {
            s = s.replace(word, "&");
        }
        s = s.replace("&", "");

        int ans = s.length();
        System.out.println("ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.minExtraChar(
//                "leetscode",
//                new String[]{"leet","code","leetcode"}
//        );
//        sol.minExtraChar(
//                "sayhelloworld",
//                new String[]{"hello","world"}
//        );

        sol.minExtraChar(
                "rkmsilizktprllwoimafyuqmeqrujxdzgp",
                new String[]{"afy","lyso","ymdt","uqm","cfybt","lwoim","hdzeg","th","rkmsi","d","e","tp","r","jx","tofxe","etjx","llqs","cpir","p","ncz","ofeyx","eqru","l","demij","tjky","jgodm","y","ernt","jfns","akjtl","wt","tk","zg","lxoi","kt"}
        );// expected 2


    }
}
