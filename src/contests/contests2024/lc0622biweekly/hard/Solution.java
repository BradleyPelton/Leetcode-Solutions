package contests.contests2024.lc0622biweekly.hard;

class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        final long rem = 1_000_000_007L;
        return -42;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfPermutations(
                3,
                new int[][]{{2,2},{0,0}}
        );
        sol.numberOfPermutations(
                3,
                new int[][]{{2,2},{1,1},{0,0}}
        );
        sol.numberOfPermutations(
                2,
                new int[][]{{0,0},{1,0}}
        );




    }
}