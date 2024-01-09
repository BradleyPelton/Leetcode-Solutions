package contests.contests2023.lc0527.easy;

// Accepted after 3 minutes, trivial

class Solution {
    public String removeTrailingZeros(String num) {

        StringBuilder sb = new StringBuilder(num);

        for (int i = num.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
            }
        }

        String ans = sb.toString();
        System.out.println("ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.removeTrailingZeros("51230100");
        sol.removeTrailingZeros("123");

    }
}
