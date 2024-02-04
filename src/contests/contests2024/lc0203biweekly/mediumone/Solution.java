package contests.contests2024.lc0203biweekly.mediumone;



// Accepted after second attempt
// Frustrating stupid question
// Tons of edge cases
// Accepted at 7:05 am

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        if (n == 2) {
        }

        int ans = 0;
        OUTER_LOOP:
        for (int i = 0; i < n; i++) {
            int[] bottomRightCorner = points[i];

            INNER_LOOP:
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int[] topLeftCorner = points[j];

                if (bottomRightCorner[0] < topLeftCorner[0] || bottomRightCorner[1] > topLeftCorner[1]) {
                    continue;
                }

                int validPoints = 0;
                int invalidPoints = 0;

                POINT_LOOP:
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    // Determine if k is in the square formed.
                    int[] currPoint = points[k];
                    if (currPoint[0] < topLeftCorner[0]) {
                        validPoints++;
                    } else if (currPoint[0] > bottomRightCorner[0]) {
                        validPoints++;
                    } else if (currPoint[1] < bottomRightCorner[1]) {
                        validPoints++;
                    } else if (currPoint[1] > topLeftCorner[1]) {
                        validPoints++;
                    } else {
                        boolean insideX = currPoint[0] >= topLeftCorner[0] && currPoint[0] <= bottomRightCorner[0];
                        boolean insideY = currPoint[1] >= bottomRightCorner[1] && currPoint[1] <= topLeftCorner[1];
                        if (insideX && insideY) {
                            invalidPoints++;
                            break POINT_LOOP;
                        } else {
                            validPoints++;
                        }
                    }
                }
                if (invalidPoints == 0) {
                    ans++;
                }
            }

        }
        System.out.println(ans);
        return ans;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfPairs(
                new int[][]{{1,1},{2,2},{3,3}}
        ); // 0
        sol.numberOfPairs(
                new int[][]{{6,2},{4,4},{2,6}}
        ); // 2
        sol.numberOfPairs(
                new int[][]{{3,1},{1,3},{1,1}}
        ); // 2
        sol.numberOfPairs(
                new int[][]{{0,0},{0,3}}
        ); // 1






    }
}
