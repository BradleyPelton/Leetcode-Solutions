package contests.contests2024.lc0914biweekly.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// Accepted after 32 minutes
// Accepted after 2 attempts
// First attempt: Wrong answer (Vague wording, starting position counts)
// Cool "Shortest Path" problem.

class Solution {

    int m;
    int n;
    int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][][] seen;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();
        seen = new boolean[m][n][health + 1];

        PriorityQueue<int[]> coordPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int startingHealth = grid.get(0).get(0) == 1 ? health - 1 : health;
        coordPQ.add(new int[]{0, 0, startingHealth});

        while (!coordPQ.isEmpty()) {
            int[] currCoord = coordPQ.remove();

            if (currCoord[0] == m - 1 && currCoord[1] == n - 1) {
                System.out.println("true");
                return true;
            }

            for (int[] dir : DIRS) {
                int nextI = currCoord[0] + dir[0];
                int nextJ = currCoord[1] + dir[1];
                if (isValidCoordinate(nextI, nextJ)) {
                    int updatedHealth;
                    if (grid.get(nextI).get(nextJ) == 1) {
                        updatedHealth = currCoord[2] - 1;
                    } else {
                        updatedHealth = currCoord[2];
                    }

                    if (updatedHealth <= 0) {
                        continue;
                    }

                    if (seen[nextI][nextJ][updatedHealth]) {
                        continue;
                    }
                    seen[nextI][nextJ][updatedHealth] = true;
                    coordPQ.add(new int[] {nextI, nextJ, updatedHealth});
                }
            }
        }

        System.out.println("false, PQ is empty");
        return false;
    }

    private boolean isValidCoordinate(int i, int j) {
        return i < m && i >= 0 && j >= 0 && j < n;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.findSafeWalk(
//                Arrays.stream(new int[][]{{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}})
//                        .map(i -> Arrays.stream(i)
//                                .boxed()
//                                .collect(Collectors.toList()))
//                        .collect(Collectors.toList()),
//                1
//        ); // true
//        sol.findSafeWalk(
//                Arrays.stream(new int[][]{{0,1,1,0,0,0},{1,0,1,0,0,0},{0,1,1,1,0,1},{0,0,1,0,1,0}})
//                        .map(i -> Arrays.stream(i)
//                                .boxed()
//                                .collect(Collectors.toList()))
//                        .collect(Collectors.toList()),
//                3
//        ); // false
//        sol.findSafeWalk(
//                Arrays.stream(new int[][]{{1,1,1},{1,0,1},{1,1,1}})
//                        .map(i -> Arrays.stream(i)
//                                .boxed()
//                                .collect(Collectors.toList()))
//                        .collect(Collectors.toList()),
//                5
//        ); // true
        sol.findSafeWalk(
                Arrays.stream(new int[][]{{1,1,1,1}})
                        .map(i -> Arrays.stream(i)
                                .boxed()
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList()),
                4
        ); // false





    }
}
