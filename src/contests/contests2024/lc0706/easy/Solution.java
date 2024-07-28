package contests.contests2024.lc0706.easy;

class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        StringBuilder ansBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ansBuilder.append(s.charAt((i + k) % n));
        }
        String ans = ansBuilder.toString();
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getEncryptedString(
                "dart",
                3
        );
        sol.getEncryptedString(
                "aaa",
                1
        );



    }
}
