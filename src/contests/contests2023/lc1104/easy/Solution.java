package contests.contests2023.lc1104.easy;

import java.util.Arrays;

// Accepted after 5 minutes
// Trivial search
// Big O (n**2) time complexity. traversing entire nxn grid

class Solution {
    public int findChampion(int[][] grid) {

        int strongTeam = Integer.MAX_VALUE;
        int strongTeamWeaknesses = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            int[] team = grid[i];
            int teamWeakness = Arrays.stream(team).sum();
            if (teamWeakness > strongTeamWeaknesses) {
                strongTeam = i;
                strongTeamWeaknesses = teamWeakness;
            }
        }

        System.out.println("ans = " + strongTeam);
        return strongTeam;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findChampion(new int[][] {{0,1},{0,0}});
        sol.findChampion(new int[][] {{0,0,1},{1,0,1},{0,0,0}});
    }
}
