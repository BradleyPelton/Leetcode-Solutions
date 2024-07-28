package contests.contests2024.lc0727.hard;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int x;
    int y;
    boolean isAnswerFound = false;
    boolean ans = false;
    int[][] circles;
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        this.x = X;
        this.y = Y;
        this.circles = circles;

        // Sort circles based on left most coordinate
        Arrays.sort(circles, Comparator.comparingInt((int[] a) -> a[0] - a[2]));


        backtrack(0);
        System.out.println(ans);
        return ans;
    }


    private void backtrack(int index) {
        if (isAnswerFound) {
            return;
        }
        int[] currCircle = circles[index];


        if (!circleTouchesTop(currCircle)) {
            // Go up
        }

        if (!circleTouchesBottom(currCircle)) {
            // Go down
        }


    }

    public boolean circleTouchesTop(int[] circle) {
        if (circle[1] + circle[2] >= y) {
            return true;
        }
        return false;
    }

    public boolean circleTouchesBottom(int[] circle) {
        if (circle[1] - circle[2] <= 0) {
            return true;
        }
        return false;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canReachCorner(
                3,
                4,
                new int[][]{{2,1,1}}
        );
        sol.canReachCorner(
                3,
                3,
                new int[][]{{1,1,2}}
        );
        sol.canReachCorner(
                3,
                4,
                new int[][]{{2,1,1},{1,2,1}}
        );


    }
}
