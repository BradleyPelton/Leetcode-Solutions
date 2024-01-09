package contests.contests2021.lc0814.easy;

// Accepted after 3 minutes, trivial

class Solution {
    public int numOfStrings(String[] patterns, String word) {

        int ans = 0;
        for (String pat : patterns) {
            if (word.contains(pat)) {
                ans++;
            }
        }

        System.out.println("final ans is " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.numOfStrings(new String[]{"a","abc","bc","d"}, "abc");
        sol.numOfStrings(new String[]{"a","b","c"}, "aaaaabbbbb");
        sol.numOfStrings(new String[]{"a","a","a"}, "ab");






    }
}
