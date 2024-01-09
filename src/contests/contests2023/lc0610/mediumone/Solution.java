package contests.contests2023.lc0610.mediumone;

// Accepted after 18 minutes
// 4 Incorrect answers
// Sloppy handling of indices
// IndexOutOfBounds, missing substring, sloppy sloppy

class Solution {
    public String smallestString(String s) {

        if (s.length() == 1) {
            if (s.equals("a")) {
                System.out.println("z");
                return "z";
            } else {
                System.out.println(String.valueOf(   (char)(s.charAt(0) - 1)  ));
                return String.valueOf(   (char)(s.charAt(0) - 1)  );
            }
        }

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                continue;
            }

            int startIndex = i;
            int endIndex = i;
            while (true) {
                i++;
                if (i == s.length()) {
                    endIndex = i - 1;
                    break;
                }

                if (s.charAt(i) == 'a') {
                    endIndex = i - 1;
                    break;
                }

            }

            for (int j = startIndex; j <= endIndex; j++) {
                char currChar = s.charAt(j);
                char newChar = (char)(currChar - 1);
                sb.setCharAt(j, newChar);
            }

            break;
        }

        String ans = sb.toString();
        if (ans.equals(s)) {
            ans = ans.substring(0, ans.length() - 1) + 'z';
        }

        System.out.println("ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.smallestString("cbabc");
        sol.smallestString("acbbc");
        sol.smallestString("leetcode");
        sol.smallestString("aaaaaaaa");
        sol.smallestString("a");
        sol.smallestString("c");
        sol.smallestString("aa"); // expected "az"
        sol.smallestString("ab"); // expected "az"
    }
}