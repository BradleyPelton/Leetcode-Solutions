package contests.contests2022.lc0423.mediumone;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// First Attempt wrong answer

class Solution {
    public int countLatticePoints(int[][] circles) {


        Map<Integer, HashSet<Integer>> uniquePoints = new HashMap<>();

        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];

            ArrayList<Point> pointsForThisCircle = pointsInsideCircle(circle[0], circle[1], circle[2]);
//            System.out.println(pointsForThisCircle);

            for (Point aPoint : pointsForThisCircle) {
                int xCoord = aPoint.x;
                int yCoord = aPoint.y;

                if (uniquePoints.containsKey(xCoord)) {
                    HashSet<Integer> currVals = uniquePoints.get(xCoord);
                    currVals.add(yCoord);
                    uniquePoints.put(xCoord, currVals);
                } else {
                    HashSet<Integer> singleSet = new HashSet<>();
                    singleSet.add(yCoord);
                    uniquePoints.put(xCoord, singleSet);
                }
            }
        }

        int ans = 0;
        for (int intKey : uniquePoints.keySet()) {
            HashSet<Integer> vals = uniquePoints.get(intKey);
            ans += vals.size();
        }
        System.out.println("final ans = " + ans);
        return ans;
    }

    private ArrayList<Point> pointsInsideCircle(int x, int y, int r) {

        ArrayList<Point> points = new ArrayList<>();

        // BOUNDARY
        Point bottomPoint = new Point(x, y - r);
        Point topPoint = new Point(x, y + r);
        Point leftPoint = new Point(x - r, y);
        Point rightPoint = new Point(x + r, y);

        points.add(leftPoint);

        // LEFT HEMISPHERE
        for (int i = 0; i < r + 1; i++) {
            int newXCoord = leftPoint.x + i;
            for (int j = 1; j < i + 1; j++) {
                int positiveY = leftPoint.y + j;
                int negativeY = leftPoint.y - j;

                for (int newYCoord = negativeY; newYCoord < positiveY + 1; newYCoord++) {
                    points.add(new Point(newXCoord, newYCoord));
                }
            }
        }

        points.add(rightPoint);

        // RIGHT HEMISPHERE
        for (int i = 1; i < r; i++) {
            int newXCoord = (leftPoint.x + r) + i;

            for (int j = 1; j < i + 1; j++) {
                int positiveY = leftPoint.y + (r - j);
                int negativeY = leftPoint.y - (r - j);

                for (int newYCoord = negativeY; newYCoord < positiveY + 1; newYCoord++) {
                    points.add(new Point(newXCoord, newYCoord));
                }
            }
        }

        return points;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.countLatticePoints(new int[][]{{2,2,1}}); // expected 5
//        sol.countLatticePoints(new int[][]{{2,2,2},{3,4,1}}); // expected 16
        sol.countLatticePoints(new int[][]{{8,9,6},{9,8,4},{4,1,1},{8,5,1},{7,1,1},{6,7,5},{7,1,1},{7,1,1},{5,5,3}});
    }
}