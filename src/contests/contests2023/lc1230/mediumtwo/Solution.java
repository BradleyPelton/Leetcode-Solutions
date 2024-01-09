package contests.contests2023.lc1230.mediumtwo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 23 minutes
// First attempt wrong answer
// Cool problem. Optimization was not hard, but busy workl

class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<Character, List<Integer>> occMap = new HashMap<>();

        char previousChar = s.charAt(0);
        int charOcc = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == previousChar) {
                charOcc++;
            } else {
                List<Integer> topThreeValues = occMap.getOrDefault(previousChar, new ArrayList<>());

                // BINARY INSERT
                int pos = Collections.binarySearch(topThreeValues, charOcc);
                if (pos < 0) {
                    topThreeValues.add(-pos - 1, charOcc); // not in
                } else {
                    topThreeValues.add(pos, charOcc);
                }

                // POP
                if (topThreeValues.size() == 4) {
                    topThreeValues.remove(3);
                }
                previousChar = s.charAt(i);
                charOcc = 1;
            }
        }
        occMap.computeIfAbsent(previousChar, a -> new ArrayList<>()).add(charOcc); // clean up last char. Will always end on unstored char.


        int ans = 0;
        for (Character c : occMap.keySet()) {
            int maxForThisChar = maxThriceFromOccurenceValues(occMap.get(c));
            ans = Math.max(ans, maxForThisChar);
        }

        if (ans == 0) {
            ans = -1; //
        }

        System.out.println(ans);
        return ans;
    }

    private int maxThriceFromOccurenceValues(List<Integer> occValues) {
        int greatestOcc = occValues.get(occValues.size() - 1);
        int ans = (greatestOcc - 2); // Use the first substring three times "aaaa" = "aa.." + ".aa." + "..aa"

        if (occValues.size() > 1) {
            int secondGreatest = occValues.get(occValues.size() - 2);
            ans = Math.max(ans,
                    Math.min(greatestOcc - 1, secondGreatest) // use the first substring twice, "aaaa" = "aaa" + ".aaa"
            );

            if (occValues.size() > 2) {
                ans = Math.max(ans,
                        Math.min(greatestOcc, Math.min(secondGreatest, occValues.get(occValues.size() - 3))) // min of all 3 substrings
                );
            }
        }

        return ans;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumLength("aaaa"); // 2
        sol.maximumLength("abcdef"); // -1
        sol.maximumLength("abcaba");  // 1
        sol.maximumLength("jicja"); // -1







    }
}