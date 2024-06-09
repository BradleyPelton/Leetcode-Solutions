package contests.contests2024.lc0608biweekly.mediumone;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

// First attempt TLE
// Accepted second attempt
// Accepted after 15 minutes
// Sloppy handling. I thought it was a simulation problem, but numberOfRounds could be 10**9

class Solution {
    public int findWinningPlayer(int[] skills, int k) {

        Map<Integer, Integer> skillMap = new HashMap<>();

        int n = skills.length;
        int maxSkill = Integer.MIN_VALUE;
        int playerWithMaxSkill = -1;
        for (int i = 0; i < n; i++) {
            skillMap.put(i, skills[i]);
            if (skills[i] > maxSkill) {
                maxSkill = skills[i];
                playerWithMaxSkill = i;
            }
        }


        if (k > (n * 2)) {
            System.out.println(playerWithMaxSkill);
            return playerWithMaxSkill;
        }



        ArrayDeque<Integer> currentDeque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            currentDeque.addLast(i);
        }


        int numberOfRoundsWon = 0;
        int ansPlayer = -1;
        OUTER_LOOP:
        while (true) {
            int leadingPlayer = currentDeque.pollFirst();
            int leadPlayerSkill = skillMap.get(leadingPlayer);

            while (true) {
                int nextPlayer = currentDeque.pollFirst();
                int nextPlayerSkill = skillMap.get(nextPlayer);
                if (leadPlayerSkill > nextPlayerSkill) {
                    currentDeque.addLast(nextPlayer);
                    numberOfRoundsWon++;

                    if (numberOfRoundsWon == k) {
                        ansPlayer = leadingPlayer;
                        break OUTER_LOOP;
                    }
                } else {
                    currentDeque.addLast(leadingPlayer);
                    currentDeque.addFirst(nextPlayer);
                    numberOfRoundsWon = 1;


                    if (numberOfRoundsWon == k) {
                        ansPlayer = nextPlayer;
                        break OUTER_LOOP;
                    }

                    continue OUTER_LOOP;
                }
            }
        }

        System.out.println(ansPlayer);
        return ansPlayer;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findWinningPlayer(
                new int[]{4,2,6,3,9},
                2
        );
        sol.findWinningPlayer(
                new int[]{2,5,4},
                3
        );
        sol.findWinningPlayer(
                new int[]{16,4,7,17},
                562084119
        );







    }
}
