package contests.contests2021.lc1127biweekly.easy;

import java.util.HashMap;
import java.util.Map;

// Accepted after 5 minutes, trivial

class Solution {
    public int countWords(String[] words1, String[] words2) {

        Map<String, Integer> occMap1 = new HashMap<>();
        Map<String, Integer> occMap2 = new HashMap<>();

        for(String word : words1) {
            if (occMap1.containsKey(word)) {
                int currVal = occMap1.get(word);
                occMap1.put(word, currVal+1);
            } else {
                occMap1.put(word, 1);
            }
        }

        for(String word : words2) {
            if (occMap2.containsKey(word)) {
                int currVal = occMap2.get(word);
                occMap2.put(word, currVal+1);
            } else {
                occMap2.put(word, 1);
            }
        }

        int ans = 0;
        for (String word : occMap1.keySet()) {
            int val1 = occMap1.getOrDefault(word, 0);
            int val2 = occMap2.getOrDefault(word, 0);

            if (val1 == 1 && val2 == 1) {
                ans++;
            }
        }

        System.out.println("final; ans = " + ans);
        return ans;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countWords(
                new String[]{"leetcode","is","amazing","as","is"},
                new String[]{"amazing","leetcode","is"}
        );
        sol.countWords(
                new String[]{"b","bb","bbb"},
                new String[]{"a","aa","aaa"}
        );
        sol.countWords(
                new String[]{"a","ab"},
                new String[]{"a","a","a","ab"}
        );

    }
}
