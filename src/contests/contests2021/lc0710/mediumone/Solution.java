package contests.contests2021.lc0710.mediumone;

import java.util.HashSet;

// Accepted after 13 minutes
// Accepted first try

// Cool problem, I was one of the first 1000 to get it correct
// Optimal choosing of first and last index, double hashset
// Cool problem

class Solution {
    public int countPalindromicSubsequence(String s) {


        // three letter palindrome iff s[0] == s[2]

        HashSet<String> allPalindromes = new HashSet<>();


        for (char ch = 'a'; ch < 123; ch++) {
            System.out.println(ch);

            int firstIndex = s.indexOf(ch);
            int lastIndexOf = s.lastIndexOf(ch);

            if (firstIndex == lastIndexOf) {
                continue;
            }

            // unique letters between two indices
            HashSet<Character> uniqueChars = new HashSet<>();
            for (int i = firstIndex + 1; i < lastIndexOf; i++) {
                uniqueChars.add(s.charAt(i));
            }

            for (Character uniqueChar : uniqueChars) {
                String temp = "" + ch + uniqueChar + ch;
//                System.out.println(temp);
                allPalindromes.add(temp);
            }

        }


        int ans = allPalindromes.size();
        System.out.println("final ans " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countPalindromicSubsequence("aabca");
        sol.countPalindromicSubsequence("adc");
        sol.countPalindromicSubsequence("bbcbaba");


    }
}