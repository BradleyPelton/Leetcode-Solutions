package contests.contests2023.lc0225.mediumone;

// First Attempt TLE. Worth a shot, BigInt


// Second attempt accepted.
// Math trick. a*k + c = b*k + c mod m;

class Solution {
    public int[] divisibilityArray(String word, int m) {


        // a = b mod c
        // a * 10 + d = b + d mod c

        // 101 = 1 mod 10;
        // 101 * 10 = 1 * 10 mod 10


        // previous * 10 + char = prevMod * 10  + char






        int[] ans = new int[word.length()];
        long currentRemainder = 0;
        for (int i = 0; i < word.length(); i++) {

            currentRemainder = (currentRemainder * 10 + Integer.parseInt(String.valueOf(word.charAt(i)))) % m;
            if (currentRemainder == 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }

        }

        //System.out.println(Arrays.toString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.divisibilityArray("998244353", 3);
        sol.divisibilityArray("1010", 10);

    }
}