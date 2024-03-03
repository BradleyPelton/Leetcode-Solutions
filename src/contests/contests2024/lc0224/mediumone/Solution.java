package contests.contests2024.lc0224.mediumone;


// Accepted first attempt
// Tedious boring problem
//

class Solution {
    int[][] bottomLeft;
    int[][] topRight;
    int n;
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        n = bottomLeft.length;

        long maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long localArea = getIntersectionArea(i, j);
                maxArea = Math.max(maxArea, localArea);
            }
        }

        System.out.println(maxArea);
        return maxArea;
    }

    private long getIntersectionArea(int indexOne, int indexTwo) {
//        if (bottomLeft[indexOne][1] >= topRight[indexTwo][1]) {
//            return 0;
//        } else if (bottomLeft[indexOne][1] >= topRight[indexTwo][1]) {
//            return 0;
//        }
//
//        // NO INTERSECTION
//        if (topRight[indexTwo][1] < bottomLeft[indexTwo][1]) {
//            return 0;
//        }


        long intersectionBottomX = Math.max(bottomLeft[indexOne][0], bottomLeft[indexTwo][0]);
        long intersectionBottomY = Math.max(bottomLeft[indexOne][1], bottomLeft[indexTwo][1]);

        long intersectionTopX = Math.min(topRight[indexOne][0], topRight[indexTwo][0]);
        long intersectionTopY = Math.min(topRight[indexOne][1], topRight[indexTwo][1]);
        if (intersectionTopX - intersectionBottomX <= 0) {
            return 0;
        } else if (intersectionTopY - intersectionBottomY <= 0) {
            return 0;
        }

        long smallestSide = Math.min(intersectionTopX - intersectionBottomX, intersectionTopY - intersectionBottomY);

        long area = smallestSide * smallestSide;
        return area;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.largestSquareArea(
                new int[][]{{1,1},{2,2},{3,1}},
                new int[][]{{3,3},{4,4},{6,6}}
        ); // 1
        sol.largestSquareArea(
                new int[][]{{1,1},{2,2},{1,2}},
                new int[][]{{3,3},{4,4},{3,4}}
        ); // 1
        sol.largestSquareArea(
                new int[][]{{1,1},{3,3},{3,1}},
                new int[][]{{2,2},{4,4},{4,2}}
        ); // 0




    }
}
