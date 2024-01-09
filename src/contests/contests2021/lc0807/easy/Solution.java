package contests.contests2021.lc0807.easy;

// Accepted after 4 minutes
// Trivial

// I'm getting better and better with Strinbuilder. It's an awesome tool to have

class Solution {
    public boolean isPrefixString(String s, String[] words) {

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word);

            if (sb.toString().equals(s)) {
                System.out.println("TRUEEEE");
                return true;
            }

            if (sb.toString().length() > s.length()) {
                System.out.println("sb longer than s");
                return false;
            }
        }

        System.out.println("all words added and still not equal");
        return false;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.isPrefixString("iloveleetcode", new String[]{"i","love","leetcode","apples"});
        sol.isPrefixString("iloveleetcode", new String[]{"apples","i","love","leetcode"});
    }
}