package contests.contests2023.lc0429.mediumtwo;

class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {

        int[][] adjMatrix = new int[2][];
        return -42;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumCost(
                new int[]{1,1},
                new int[]{4,5},
                new int[][]{{1,2,3,3,2},{3,4,4,5,1}}
        );
        sol.minimumCost(
                new int[]{3,2},
                new int[]{5,7},
                new int[][]{{3,2,3,4,4},{3,3,5,5,5},{3,4,5,6,6}}
        );
    }
}