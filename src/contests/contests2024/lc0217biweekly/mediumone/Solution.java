package contests.contests2024.lc0217biweekly.mediumone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// First attempt TLE
// Second Attempt Accepted
// accepted after 10 minutes
// Had to remove the .toString() which was O(n) operation

class Solution {
    public String lastNonEmptyString(String s) {
        int n = s.length();
        StringBuilder alteredString = new StringBuilder(s);
        Map<Character, ArrayDeque<Integer>> charOccMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charOccMap.computeIfAbsent(s.charAt(i), a -> new ArrayDeque<>()).addLast(i);
        }

        String ansWithPounds = s;
        int numberOfCharactersRemoved = 0;
        while (!charOccMap.isEmpty()) {
            List<Character> keysToRemove = new ArrayList<>();
            for (char key : charOccMap.keySet()) {
                ArrayDeque<Integer> occValues = charOccMap.get(key);
                int indexPop = occValues.removeFirst();
                alteredString.setCharAt(indexPop, '#');
                numberOfCharactersRemoved++;

                if (occValues.isEmpty()) {
                    keysToRemove.add(key);
                }
            }

            for (char key : keysToRemove) {
                charOccMap.remove(key);
            }
            if (charOccMap.isEmpty()) {
                break;
            }
            if (n - numberOfCharactersRemoved <= 27) {
                ansWithPounds = alteredString.toString();
            }
        }

        StringBuilder ansBuilder = new StringBuilder();
        for (char c : ansWithPounds.toCharArray()) {
            if (c != '#') {
                ansBuilder.append(c);
            }
        }
        String ans = ansBuilder.toString();
//        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.lastNonEmptyString("aabcbbca");
        sol.lastNonEmptyString("abcd");



    }
}