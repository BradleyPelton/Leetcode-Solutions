package contests.contests2023.lc0722biweekly.mediumone;

import java.util.Map;
import java.util.TreeMap;

// Accpeted after 14 minutes
// Trivial ish

class Solution {
    public String sortVowels(String s) {

        Map<Character, Integer> vowelMap = new TreeMap<>();
        vowelMap.put('A', 0);
        vowelMap.put('E', 0);
        vowelMap.put('I', 0);
        vowelMap.put('O', 0);
        vowelMap.put('U', 0);
        vowelMap.put('a', 0);
        vowelMap.put('e', 0);
        vowelMap.put('i', 0);
        vowelMap.put('o', 0);
        vowelMap.put('u', 0);

        for (int i = 0; i < s.length(); i++) {
            char currChar  = s.charAt(i);
            if (vowelMap.containsKey(currChar)) {
                vowelMap.put(currChar, vowelMap.get(currChar) + 1);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char currChar  = s.charAt(i);
            if (vowelMap.containsKey(currChar)) {
                for (char vowel : vowelMap.keySet()) {
                    int currOcc = vowelMap.get(vowel);
                    if (currOcc == 0) {
                        continue;
                    } else {
                        currOcc -= 1;
                        vowelMap.put(vowel, currOcc);
                        sb.setCharAt(i, vowel);
                        break;
                    }
                }
            }
        }

        String ans = sb.toString();
        System.out.println("ans = " + ans);
        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sortVowels("lEetcOde");
        sol.sortVowels("lYmpH");
    }
}
