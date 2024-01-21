package contests.contests2024.lc0120.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted in 2 minutes
// Same solution as Easy.
// I implemented the optimized solution for the easy problem
// Copy pasted and it worked flawlessly with zero edits.


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
        sol.minimumPushes("xyzxyzxyzxyz");
        sol.minimumPushes("aabbccddeeffgghhiiiiii");



    }
}