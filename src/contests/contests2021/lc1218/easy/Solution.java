package contests.contests2021.lc1218.easy;

// Accepted after 4 minutes, trivial

class Solution {
    public String firstPalindrome(String[] words) {

        for (String word : words) {
            if (isPalindrome(word)) {
                System.out.println("found palindrome, word=" + word);
                return word;
            }
        }

        System.out.println("no palindrome found");
        return "";
    }

    public boolean isPalindrome(String s) {


        String input = "Geeks for Geeks";

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        // reverse StringBuilder input1
        sb.reverse();

        String reversedString = sb.toString();
        if (s.equals(reversedString)) {
            return true;
        } else {
            return false;
        }
    }
}
class Tests {
    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.firstPalindrome(new String[]{"abc","car","ada","racecar","cool"});
        sol.firstPalindrome(new String[]{"notapalindrome","racecar"});
        sol.firstPalindrome(new String[]{"def","ghi"});
    }
}
