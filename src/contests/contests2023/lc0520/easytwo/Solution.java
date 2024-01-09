package contests.contests2023.lc0520.easytwo;

// Accepted after 9 minutes
// Cool "easy" problem.
// Spent most of the time handling indexes

class Solution {
    public String makeSmallestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);

        if (s.length() == 1) {
            System.out.println("1 edge case");
            return s;
        }


        int leftIndex = 0;
        int rightIndex = 0;


        if (s.length() % 2 == 1) {

            // Center element == (s.length - 1) / 2
            leftIndex = ((s.length() - 1) / 2) - 1;
            rightIndex = ((s.length() - 1) / 2) + 1;
        } else {
            leftIndex = ((s.length() - 1) / 2);
            rightIndex = ((s.length() - 1) / 2) + 1;
        }

        while (leftIndex >= 0) {

            char leftChar = sb.charAt(leftIndex);
            char rightChar = sb.charAt(rightIndex);

            if (leftChar != rightChar) {
                if (leftChar < rightChar) {
                    sb.replace(rightIndex, rightIndex + 1, String.valueOf(leftChar));
                } else {
                    sb.replace(leftIndex, leftIndex + 1, String.valueOf(rightChar));
                }
            }

            leftIndex--;
            rightIndex++;
        }

        final String ans = sb.toString();
//        System.out.println("ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.makeSmallestPalindrome("egcfe");
        sol.makeSmallestPalindrome("abcd");
        sol.makeSmallestPalindrome("seven");
        sol.makeSmallestPalindrome("ab");
    }
}