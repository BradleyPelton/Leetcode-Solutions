package contests.contests2024.lc0622.mediumone;

// Accepted after 5 minutes
// Trivial

class Solution {
    public int minimumArea(int[][] grid) {

        int topI = Integer.MAX_VALUE;
        int bottomI = Integer.MIN_VALUE;
        
        int leftJ = Integer.MAX_VALUE;
        int rightJ = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    topI = Math.min(topI, i);
                    bottomI = Math.max(bottomI, i);

                    leftJ = Math.min(leftJ, j);
                    rightJ = Math.max(rightJ, j);
                }

            }
        }

        int ans = (bottomI - topI + 1) * (rightJ - leftJ + 1);
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumArea(
                new int[][]{{0,1,0},{1,0,1}}
        );
        sol.minimumArea(
                new int[][]{{0,0},{1,0}}
        );





    }
}
