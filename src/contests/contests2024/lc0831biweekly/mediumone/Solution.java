package contests.contests2024.lc0831biweekly.mediumone;

// Accepted first try
// Accepted after 5 minutes
// Trivial. Easier than the easy.



class Solution {
    public String stringHash(String s, int k) {


        StringBuilder ansBuilder = new StringBuilder();

        int n = s.length();
        for (int i = 0; i < n; i += k) {
            int hashSum = 0;

            for (int j = 0; j < k; j++) {
                char currChar = s.charAt(i + j);
                hashSum += currChar - 97;
            }

            hashSum %= 26;
            char output = (char)(hashSum + 'a');
            ansBuilder.append(output);
        }

        String ans = ansBuilder.toString();
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.stringHash(
                "abcd",
                2
        );
        sol.stringHash(
                "mxz",
                3
        );



    }
}
