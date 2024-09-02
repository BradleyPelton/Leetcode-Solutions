package contests.contests2024.lc0831.easy;

// Accepted after 5 minutes
// Accepted after second attempt
// First attempt wrong answer: off by one.

// Tedious easy.

class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {

        int[][] grid = {
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1}
        };

        int coord1I = (int)(coordinate1.charAt(0) - 'a');
        int coord1J = Integer.parseInt(String.valueOf(coordinate1.charAt(1))) - 1;

        int coord2I = (int)(coordinate2.charAt(0) - 'a');
        int coord2J = Integer.parseInt(String.valueOf(coordinate2.charAt(1))) - 1;

        int coord1Value = grid[coord1I][coord1J];
        int coord2Value = grid[coord2I][coord2J];

        boolean ans = coord1Value == coord2Value;
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.checkTwoChessboards(
                "a1",
                "c3"
        );
        sol.checkTwoChessboards(
                "a1",
                "h3"
        );
        sol.checkTwoChessboards(
                "h7",
                "c8"
        );
    }
}
