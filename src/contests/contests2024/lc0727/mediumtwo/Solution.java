package contests.contests2024.lc0727.mediumtwo;

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] zeroPrefix = new int[n];
        int[] onePrefix = new int[n];

        int numberOfZeroes = 0;
        int numberOfOnes = 0;
        if (s.charAt(0) == '0') {
            numberOfZeroes++;
        } else {
            numberOfOnes++;
        }

        zeroPrefix[0] = numberOfZeroes;
        onePrefix[0] = numberOfOnes;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(0) == '0') {
                numberOfZeroes++;
            } else {
                numberOfOnes++;
            }
            zeroPrefix[i] = numberOfZeroes;
            onePrefix[i] = numberOfOnes;
        }


        int left = 0;
        return -42;

    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfSubstrings("00011");
        sol.numberOfSubstrings("101101");



    }
}
