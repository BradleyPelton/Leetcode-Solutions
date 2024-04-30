package contests.contests2024.lc0420.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted, trivial two hashmap
// accepted after 5 minutes

class Solution {
    public int numberOfSpecialChars(String word) {

        Map<Character, Integer> firstOcc = new HashMap<>();
        Map<Character, Integer> lastOcc = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            if (!firstOcc.containsKey(word.charAt(i))) {
                firstOcc.put(word.charAt(i), i);
            }
            lastOcc.put(word.charAt(i), i);
        }

        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (firstOcc.containsKey(c)) {
                int lastOccOfLower = lastOcc.get(c);
                int firstOccOfUpper = firstOcc.getOrDefault(Character.toUpperCase(c), Integer.MIN_VALUE);
                if (lastOccOfLower < firstOccOfUpper) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        return ans;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfSpecialChars("aaAbcBC");
        sol.numberOfSpecialChars("abc");
        sol.numberOfSpecialChars("AbBCab");




    }
}
