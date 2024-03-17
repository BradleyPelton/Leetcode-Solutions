package contests.contests2024.lc0316biweekly.mediumtwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Accepted after 45 minutes
// First attempt rejected: wrong answer
// Second attempt accepted

// Tricky question. Greedy seemed like it would work.
// There was a huge optimization: Inserting a char at the end or the beginning doesn't make a difference.
// We just need to calculate which characters are going to be added (regardless of order), then add them in lexicographical order.

// The trick for question 3: calculate which characters are going to be added (regardless of order), then add them in lexicographical order.


class Solution {
    public String minimizeStringValue(String s) {
        int n = s.length();
        int[] charTotals = new int[26];
        int questionMarkTotal = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                questionMarkTotal++;
            } else {
                charTotals[s.charAt(i) - 97]++;
            }
        }

        PriorityQueue<int[]> charMinPQ = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> b[1]));
        for (char c = 'a'; c <= 'z'; c++) {
            charMinPQ.add(new int[]{charTotals[c - 97], c - 97});
        }

        int[] charsToAdd = new int[26];
        for (int i = 0; i < questionMarkTotal; i++) {
            int[] val = charMinPQ.remove();
            charsToAdd[val[1]]++;
            val[0]++;
            charMinPQ.add(val);
        }


        // BUILD ANS, efficient, O(n)
        char nextChar = 'a';
        StringBuilder ansBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {

                char minCostChar;
                if (charsToAdd[nextChar - 97] > 0) {
                    minCostChar = nextChar;
                    charsToAdd[nextChar - 97]--;
                } else {
                    while (charsToAdd[nextChar - 97] == 0) {
                        nextChar++;
                    }

                    minCostChar = nextChar;
                    charsToAdd[nextChar - 97]--;
                }
                ansBuilder.setCharAt(i, minCostChar);
            }
        }

        String ans = ansBuilder.toString();
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimizeStringValue("???");
        sol.minimizeStringValue("a?a?");
        sol.minimizeStringValue("abcdefghijklmnopqrstuvwxy??"); // "abcdefghijklmnopqrstuvwxyaz"



        sol.minimizeStringValue("???????????????????????????????????????????????????????????????????????????????"); //


    }
}
