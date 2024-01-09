package contests.contests2023.lc0121.mediumone;

import java.util.Arrays;

// trivial 6 minutes
// literally one line solution. super weird to be a medium.
//

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {

        Arrays.sort(score, (a,b) -> Integer.compare(b[k], a[k]));
//        System.out.println(Arrays.deepToString(score));
        return score;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sortTheStudents(
                new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}},
        2
        );

        sol.sortTheStudents(
                new int[][]{{3,4},{5,6}},
                0
        );
    }
}