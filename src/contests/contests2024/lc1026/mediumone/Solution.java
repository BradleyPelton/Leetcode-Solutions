package contests.contests2024.lc1026.mediumone;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

// Accepted at 9:57pm
// Accepted second attempt

// Attempt 1: wrong answer
// Sloppy overflow handling.

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] charOcc = new int[26];

        for (char c : s.toCharArray()) {
            charOcc[c - 'a']++;
        }

        final long rem = 1_000_000_007L;
        for (int i = 0; i < t; i++) {
            int[] nextOcc = new int[26];
            for (int j = 0; j < 25; j++) {
                nextOcc[j + 1] = charOcc[j];
            }

            nextOcc[0] = charOcc[25];
            nextOcc[1] = (int)((nextOcc[1] + charOcc[25]) % rem);

            charOcc = nextOcc;
        }

        int ans = 0;
        for (int val : charOcc) {
            ans = (int)((ans + val) % rem);
        }
//        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.lengthAfterTransformations(
//                "abcyy",
//                2
//        );
//        sol.lengthAfterTransformations(
//                "azbk",
//                1
//        );
        sol.lengthAfterTransformations(
                "jqktcurgdvlibczdsvnsg",
                7517
        );



    }
}
