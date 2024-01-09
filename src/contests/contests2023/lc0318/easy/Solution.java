package contests.contests2023.lc0318.easy;

// First attempt rejected. Forgot to iterate forwards

class Solution {
    public int[] evenOddBit(int n) {

        String nAsBinString = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();

        int even = 0;
        int odd = 0;
        for (int i = 0; i < nAsBinString.length(); i++) {
            char c = nAsBinString.charAt(i);
            if (c == '1') {
                if (i % 2 == 0) {
                    even++;
                } else if (i % 2 == 1) {
                    odd++;
                }
            }
        }

        int[] ans = {even, odd};
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.evenOddBit(17);
        sol.evenOddBit(2);
    }
}
