package contests.contests2024.lc0504.easy;

// Acepted after 11 minutes
// Accepted after 2 wrong answers
// Dumb problem. DUmb wording . Dumb.

class Solution {
    public boolean isValid(String word) {

        if (word.length() < 3) {
            System.out.println(false);
            return false;
        }


        boolean containsUpper = false;
        boolean containsLower = false;
        boolean containsVowel = false;
        boolean containsConsonant = false;

        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                continue;
            }

            if (c == 'a'
                    || c == 'e'
                    || c == 'i'
                    || c == 'o'
                    || c == 'u'
                    || c == 'A'
                    || c == 'E'
                    || c == 'I'
                    || c == 'O'
                    || c == 'U') {
                containsVowel = true;
            } else {
                containsConsonant = true;
            }

            if ( c >= 'a' && c <= 'z' || (c >= 'A' && c <= 'Z')) {
                if (Character.isUpperCase(c)) {
                    containsUpper = true;
                } else {
                    containsLower = true;
                }
            } else {
                System.out.println(false);
                return false;
            }
        }


        boolean ans = containsConsonant && containsVowel;
        System.out.println(ans);
        return ans;


    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isValid("234Adas");
        sol.isValid("b3");
        sol.isValid("a3$e");
        sol.isValid("AhI"); // true
        sol.isValid("IMG"); // true




    }
}
