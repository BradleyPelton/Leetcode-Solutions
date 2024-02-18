package contests.contests2024.lc0217.easy;


// Accepted after 2 minutes
// Trivial

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].startsWith(words[i])) {
                    if (words[j].endsWith(words[i])) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countPrefixSuffixPairs(
                new String[]{"a","aba","ababa","aa"}
        );
        sol.countPrefixSuffixPairs(
                new String[]{"pa","papa","ma","mama"}
        );
        sol.countPrefixSuffixPairs(
                new String[]{"abab","ab"}
        );


    }
}
