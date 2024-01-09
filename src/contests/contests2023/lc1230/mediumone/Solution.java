package contests.contests2023.lc1230.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 14 minutes
// Fumbled around occMap indicies. Misstyped a key
// Brute force. Sloppy solution

class Solution {
    public int maximumLength(String s) {
        int n = s.length();

        Map<String, Integer> specialStringOcc = new HashMap<>();

        OUTER_LOOP:
        for (int i = 0; i < n; i++) {
            char firstChar = s.charAt(i);
            String firstCharAsString = String.valueOf(firstChar);
            int firstCharOcc = specialStringOcc.getOrDefault(firstCharAsString, 0) + 1;
            specialStringOcc.put(firstCharAsString, firstCharOcc);
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == firstChar) {
                    String specString = firstCharAsString.repeat(j - i + 1);
                    int newOcc = specialStringOcc.getOrDefault(specString, 0) + 1;
                    specialStringOcc.put(specString, newOcc);
                } else {
                    continue OUTER_LOOP;
                }

            }
        }

        String ansString = "";
        for (String specString : specialStringOcc.keySet()) {
            if (specialStringOcc.get(specString) >= 3) {
                if (specString.length() >= ansString.length()) {
                    ansString = specString;
                }
            }
        }

        int ans;
        if (ansString.isEmpty()) {
            ans = -1;
        } else {
            ans = ansString.length();
        }



        System.out.println(ans);
        return ans;

    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumLength("aaaa");
        sol.maximumLength("abcdef");
        sol.maximumLength("abcaba");


    }
}