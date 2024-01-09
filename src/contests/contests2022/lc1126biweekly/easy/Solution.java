package contests.contests2022.lc1126biweekly.easy;

import java.util.ArrayList;
import java.util.List;

// Trviial 3 minutes

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.contains(String.valueOf(x))) {
                ans.add(i);
            }
        }
        //System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findWordsContaining(new String[]{"leet","code"}, 'e' );
        sol.findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"}, 'a');
        sol.findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"}, 'z');




    }
}