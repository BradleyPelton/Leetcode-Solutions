package contests.contests2024.lc0120.easy;

import java.util.Arrays;

// Accepted after 9 minutes
// Yips? Took way too long. Tedious problem

class Solution {
    public int minimumPushes(String word) {

        int[] charPressed = new int[26];

        for (char c : word.toCharArray()) {
            charPressed[c - 'a']++;
        }

        int[] pushes = new int[]{
                1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2,
                3, 3, 3, 3, 3, 3, 3, 3,
                4, 4
        };

        Arrays.sort(charPressed);

        int ans = 0;
        for (int i = charPressed.length - 1; i >= 0; i--) {
            int localPlus = charPressed[i] * pushes[26 - i - 1];
            ans += localPlus;
        }

        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumPushes("abcde");
        sol.minimumPushes("xycdefghij");
        sol.minimumPushes("abcde");


    }
}