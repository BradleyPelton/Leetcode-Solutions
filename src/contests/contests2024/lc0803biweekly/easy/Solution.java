package contests.contests2024.lc0803biweekly.easy;

import java.util.HashMap;
import java.util.Map;

// Accepted first try
// Accepted after 6 minutes
// Long, tedious easy problem

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {

        Map<Integer, Map<Integer, Integer>> ballCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ballCount.put(i, new HashMap<>());
        }

        for (int[] localPick : pick) {
            int currCount = ballCount.get(localPick[0]).getOrDefault(localPick[1], 0);
            ballCount.get(localPick[0]).put(localPick[1], currCount + 1);
        }


        int numberOfWinners = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> choices = ballCount.get(i);
            for (int key : choices.keySet()) {
                int occ = choices.get(key);
                if (occ >= i + 1) {
                    numberOfWinners++;
                    break;
                }
            }
        }

        System.out.println(numberOfWinners);
        return numberOfWinners;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.winningPlayerCount(
                4,
                new int[][]{{0,0},{1,0},{1,0},{2,1},{2,1},{2,0}}
        );
        sol.winningPlayerCount(
                5,
                new int[][]{{1,1},{1,2},{1,3},{1,4}}
        );
        sol.winningPlayerCount(
                5,
                new int[][]{{1,1},{2,4},{2,4},{2,4}}
        );




    }
}
