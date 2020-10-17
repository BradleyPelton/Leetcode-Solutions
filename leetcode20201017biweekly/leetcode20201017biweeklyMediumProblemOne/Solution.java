package leetcode20201017biweeklyMediumProblemOne;

import java.util.ArrayList;
import java.util.Arrays;


// Accepted after 82 minutes
// Accepted after second attempt. First attempt I forgot to exclude towers greater than radius distance away

// Pretty proud of this solution I'm sure it could be much cleaner, and a non bruteforce solution exists,
// but I like how I split this into smaller problems and how it all came together.


class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {

        int maxNetworkQuality = 0;
        int[] maxNetworkQualityPoint = {0,0};
        ArrayList<int[]> maxPoints = new ArrayList<>();



        for (int x=0; x<51; x++){
            for(int y=0; y<51; y++){
                int[] currPoint = {x,y};
                int networkQuality = 0;

                for(int[] tow: towers){
                    networkQuality +=  networkQualityForOneTower(currPoint, tow, radius);
                }
                if(networkQuality > maxNetworkQuality){
                    maxPoints.clear();
                    maxPoints.add(currPoint);

                    maxNetworkQuality = networkQuality;
                } else if (networkQuality == maxNetworkQuality){
                    maxPoints.add(currPoint);
                }
            }
        }

        System.out.println(Arrays.deepToString(maxPoints.toArray()));

        int[] lexOrderPoint = {100,100};
        for(int[] p: maxPoints){
            if(p[0] < lexOrderPoint[0]){
                lexOrderPoint = p;
            } else if(p[0] == lexOrderPoint[0]){
                if(p[1] < lexOrderPoint[1]){
                    lexOrderPoint = p;
                }
            }
        }

        System.out.println("final point is " + Arrays.toString(lexOrderPoint));
        return lexOrderPoint;

    }
    public double eucDistance(int[] pointA, int[] pointB){
        double xDelta = pointB[0] - pointA[0];
        double yDelta = pointB[1] - pointA[1];
        double ans = Math.sqrt(xDelta*xDelta  + yDelta*yDelta);
        return ans;
    }

    public double networkQualityForOneTower(int[] inputPoint, int aTower[], int r){
        double towerDistance = eucDistance(inputPoint, aTower);
        if(towerDistance > r){
            return 0.0;
        }

        double ans = Math.floor(   (aTower[2] / (1 + towerDistance))    );
//        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        int[][] firstTowers = {{1,2,5},{2,1,7},{3,1,9}};
        int[][] secondTowers = {{23,11,21}};
        int[][] thirdTowers = {{1,2,13},{2,1,7},{0,1,9}};
        int[][] fourthTowers = {{2,1,9},{0,1,9}};

        int[][] fifthTowers = {{32,36,27},{17,22,43},{8,11,41},{46,28,7},{22,4,35},{41,8,33},{32,29,4},{44,32,16},{33,20,16},{3,38,35},{17,47,23},{33,0,29},{29,19,6},{4,50,46},{19,47,6},{48,6,41},{20,26,35}};



        Solution sol = new Solution();
        sol.bestCoordinate(firstTowers, 2);
        sol.bestCoordinate(secondTowers, 9);
        sol.bestCoordinate(thirdTowers, 2);
        sol.bestCoordinate(fourthTowers, 2);
        sol.bestCoordinate(fifthTowers, 4);

    }
}