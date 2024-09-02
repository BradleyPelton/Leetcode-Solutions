package contests.contests2024.lc0831biweekly.hardtwo;

import java.util.Comparator;
import java.util.PriorityQueue;

// First attempt wrong answer

class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        int dps = 0;
        int totalNumberOfTurns = 0;

        for (int i = 0; i < n; i++) {
            int numberOfTurnsToKill = (int)(Math.ceil((health[i] + 0.0) / power));
            totalNumberOfTurns += numberOfTurnsToKill;
        }

        PriorityQueue<double[]> enemyPQ = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[1]));
        for (int i = 0; i < n; i++) {
            dps += damage[i];

            int numberOfTurnsToKill = (int)(Math.ceil((health[i] + 0.0) / power));

//            double damageAvoided = ((damage[i]) + 0.0) / numberOfTurnsToKill;
//            double damageAvoided = ((totalNumberOfTurns - numberOfTurnsToKill + 0.0) * damage[i]) / numberOfTurnsToKill;
            double damageAvoided = ((totalNumberOfTurns - numberOfTurnsToKill + 0.0) * damage[i]);
            enemyPQ.add(new double[]{
                    i,
                    damageAvoided,
                    numberOfTurnsToKill,
            });
        }

        int damageTaken = 0;
        while (!enemyPQ.isEmpty()) {

            double[] enemy = enemyPQ.remove();
            damageTaken += (int) (enemy[2] * dps);
            dps -= damage[(int)enemy[0]];
        }

        System.out.println(damageTaken);
        return damageTaken;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minDamage(
                4,
                new int[]{1,2,3,4},
                new int[]{4,5,6,8}
        );
        sol.minDamage(
                1,
                new int[]{1,1,1,1},
                new int[]{1,2,3,4}
        );
        sol.minDamage(
                8,
                new int[]{40},
                new int[]{59}
        );
        sol.minDamage(
                10,
                new int[]{44,69},
                new int[]{57,88}
        ); // 1281


    }
}
