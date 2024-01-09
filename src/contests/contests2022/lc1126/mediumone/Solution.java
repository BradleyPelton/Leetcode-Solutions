package contests.contests2022.lc1126.mediumone;

import java.util.HashSet;
import java.util.Set;

// Accepted after 5 minutes
// Trivial brute force.

class Solution {
    public int beautifulSubstrings(String s, int k) {

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int vowelCount = 0;
        int consonantsCount = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            vowelCount = 0;
            consonantsCount = 0;
            if (vowels.contains(s.charAt(i))) {
                vowelCount++;
            } else {
                consonantsCount++;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (vowels.contains(s.charAt(j))) {
                    vowelCount++;
                } else {
                    consonantsCount++;
                }

                if (vowelCount == consonantsCount) {
                    if ((vowelCount * consonantsCount) % k == 0) {
                        ans++;
                    }
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
        sol.beautifulSubstrings("baeyh", 2);
        sol.beautifulSubstrings("abba", 1);
        sol.beautifulSubstrings("bcdf", 1);





    }
}
