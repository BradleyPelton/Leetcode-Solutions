package contests.contests2024.lc0914biweekly.hardtwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxPathLength(int[][] coordinates, int k) {
        int[] centerCoord = coordinates[k];
        List<int[]> beforeCoords = new ArrayList<>();
        List<int[]> afterCoords = new ArrayList<>();

        for (int i = 0; i < coordinates.length; i++) {
            if (i == k) {
                continue;
            }
            int[] coord = coordinates[i];
            // 4 quadrants, ignore quadrant 2 and 4
//            if (coord[0] <= centerCoord[0] && coord[1] >= centerCoord[1]) { //QUAD 2
//                continue;
//            } else if (coord[0] >= centerCoord[0] && coord[1] <= centerCoord[1]) { // QUAD 4
//                continue;
//            } else

            if (coord[0] > centerCoord[0] && coord[1] > centerCoord[1]) {
                afterCoords.add(coord);
            } else if (coord[0] < centerCoord[0] && coord[1] < centerCoord[1]){
                beforeCoords.add(coord);
            }
        }

        beforeCoords.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> b[1]));
        afterCoords.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> b[1]));

        int longestBefore = longestIncreasing(beforeCoords);
        int longestAfter = longestIncreasing(afterCoords);

        int ans = longestBefore + 1 + longestAfter;
        System.out.println(ans);
        return ans;
    }


    List<int[]> coords;
    Map<Integer, Map<Integer, Integer>> nextValidIndex;
    int n;
    Integer[] dp;
    private int longestIncreasing(List<int[]> coords) {
        this.coords = coords;
        if (coords.size() <= 1) {
            return coords.size();
        }
        nextValidIndex = new HashMap<>();
        n = coords.size();
        dp = new Integer[n];

        for (int startingIndex = 0; startingIndex < n; startingIndex++) {
            int[] startingCoord = coords.get(startingIndex);
            nextValidIndex.computeIfAbsent(startingCoord[0], a -> new HashMap<>());

            int localNextValidIndex = n;
            for (int i = startingIndex + 1; i < n; i++) {
                int[] nextCoord = coords.get(i);
                if (startingCoord[0] < nextCoord[0] && startingCoord[1] < nextCoord[1]) {
                    localNextValidIndex = i;
                    break;
                }
            }
            nextValidIndex.get(startingCoord[0]).put(startingCoord[1], localNextValidIndex);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int localAns = topDown(i) + 1;
            ans = Math.max(ans, localAns);
        }
        return ans;
    }

    private int topDown(int index) {
        if (index >= n) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int[] currCoord = coords.get(index);
        int ans = 0;
        int startIndex = nextValidIndex.get(currCoord[0]).get(currCoord[1]);

        for (int i = startIndex; i < n; i++) {
            int localAns = topDown(i) + 1;
            ans = Math.max(ans, localAns);
        }

        dp[index] = ans;
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxPathLength(
                new int[][]{{3,1},{2,2},{4,1},{0,0},{5,3}},
                1
        ); // 3
        sol.maxPathLength(
                new int[][]{{2,1},{7,0},{5,6}},
                2
        ); // 2
        sol.maxPathLength(
                new int[][]{{0,3},{8,5},{6,8}},
                0
        ); // 2????
        sol.maxPathLength(
                new int[][]{{7,6},{5,8},{4,6},{4,3},{6,4}},
                3
        ); // 3
        sol.maxPathLength(
                new int[][]{{0,1},{1,0},{8,4},{3,6},{4,6},{9,7},{4,8}},
                1
        ); // 3




    }
}
