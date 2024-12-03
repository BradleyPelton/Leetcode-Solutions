package contests.contests2024.lc1026biweekly.hard;

import java.util.HashMap;
import java.util.Map;

class Solution {
    String word;
    int n;
    int k;
    Map<Integer, Integer> lastIndexOfSameCharMap;
    final long rem = 1_000_000_007L;
    public int possibleStringCount(String word, int k) {
        this.word = word;
        this.k = k;
        this.n = word.length();
        // NO TIME FOR CAUTION COOPER

        lastIndexOfSameCharMap = new HashMap<>();
        for (int firstIndex = 0; firstIndex < n; firstIndex++) {

            char currChar = word.charAt(firstIndex);
            int lastIndex = firstIndex;
            for (int i = firstIndex + 1; i < n; i++) {
                if (word.charAt(i) == currChar) {
                    lastIndex = i;
                } else {
                    break;
                }
            }
            for (int i = firstIndex; i <= lastIndex; i++) {
                lastIndexOfSameCharMap.put(i, lastIndex);
            }

            firstIndex = lastIndex;
        }

        int ans = recursion(0, 0);
        System.out.println(ans);
        return ans;
    }

    public int recursion(int index, int numberOfLettersTyped) {
        if (index == n) {
            if (numberOfLettersTyped >= k) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        int lastIndex = lastIndexOfSameCharMap.get(index);

        int doNothing = recursion(lastIndex + 1, numberOfLettersTyped + (lastIndex - index + 1));
        int collapse = 0;
        for (int i = index + 1; i <= lastIndex; i++) {
            int localAns = recursion(i + 1, numberOfLettersTyped + 1);
            if (localAns != Integer.MIN_VALUE) {
                collapse = (int)((collapse + localAns) % rem);
            }
        }

        int ans = Integer.MIN_VALUE;
        if (doNothing != Integer.MIN_VALUE && collapse != Integer.MIN_VALUE) {
            ans = (int)((doNothing + collapse) % rem);
        } else if (doNothing != Integer.MIN_VALUE) {
            ans = doNothing;
        } else if (collapse != Integer.MIN_VALUE) {
            ans = collapse;
        }

        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.possibleStringCount(
//                "aabbccdd",
//                7
//        );
//        sol.possibleStringCount(
//                "aabbccdd",
//                8
//        );
        sol.possibleStringCount(
                "aaabbb",
                3
        );



    }
}