package contests.contests2021.lc0918.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DetectSquares {

    Map<Integer, ArrayList<int[]>> xMap;
    Map<Integer, ArrayList<int[]>> yMap;

    public DetectSquares() {
        xMap = new HashMap<>();
        yMap = new HashMap<>();
    }

    public void add(int[] point) {
        int xCoord = point[0];
        int yCoord = point[1];

        ArrayList<int[]> currX = xMap.getOrDefault(xCoord, new ArrayList<>());
        ArrayList<int[]> currY = yMap.getOrDefault(yCoord, new ArrayList<>());

        currX.add(point);
        currY.add(point);

        xMap.put(xCoord, currX);
        yMap.put(yCoord, currY);
    }

    public int count(int[] point) {

        Map<Integer,Integer> numOfXPointsZDistanceAway = new HashMap<>();
        Map<Integer,Integer> numOfYPointsZDistanceAway = new HashMap<>();

        ArrayList<int[]> sameXCoord = xMap.getOrDefault(point[0], new ArrayList<>());
        ArrayList<int[]> sameYCoord = yMap.getOrDefault(point[1], new ArrayList<>());

//        for (int[] aPoint : sameXCoord) {
//            int distance = Math.abs(aPoint[1] - point[1]);
//            numOfXPointsZDistanceAway.put(distance, numOfXPointsZDistanceAway.getOrDefault(distance, 0)+1);
//        }
//
//        for (int[] aPoint : sameYCoord) {
//            int distance = Math.abs(aPoint[0] - point[0]);
//            numOfYPointsZDistanceAway.put(distance, numOfYPointsZDistanceAway.getOrDefault(distance, 0)+1);
//        }
//
//        int numberOfSquares = 0;
//        for (int d : numOfXPointsZDistanceAway.keySet()) {
//            int numsOfXs = numOfXPointsZDistanceAway.getOrDefault(d, 0);
//            int numsOfYs = numOfYPointsZDistanceAway.getOrDefault(d, 0);
//
//            numberOfSquares += (numsOfXs * numsOfYs);
//        }

        int numberOfSquares = 0;
        for (int[] xPoint : sameXCoord) {
            int xDistance = Math.abs(xPoint[1] - point[1]);
            for (int[] yPoint : sameYCoord) {
                int yDistance = Math.abs(yPoint[0] - point[0]);
                if (xDistance == yDistance
                        && !(xPoint[0] == yPoint[0] || xPoint[1] == yPoint[1])) {
                    numberOfSquares++;
                }
            }
        }


        System.out.println("final ans = " + numberOfSquares);
        return numberOfSquares;

    }
}

class Tests{
    public static void main(String[] args) {
        DetectSquares squares = new DetectSquares();

        String[] words = new String[]{"DetectSquares", "add",  "add",  "add",  "count",      "count",    "add",    "count"};
        int[][] points = new int[][]{{},             {3, 10}, {11, 2}, {3, 2}, {11, 10},      {14, 8},   {11, 2},   {11, 10}};
//
//        String[] words = new String[]{"DetectSquares","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add"};
//        int[][] points = new int[][]{{},{693,895},{693,724},{864,724},{864,895},{752,831},{752,562},{483,562},{483,831},{978,776},{268,776},{268,66},{978,66},{81,282},{10,211},{10,282},{81,211},{950,659},{757,659},{950,466},{757,466},{535,933},{535,518},{120,933},{120,518},{649,732},{19,102},{19,732},{649,102},{653,790},{690,790},{653,827},{690,827},{930,560},{550,940},{930,940},{550,560},{86,106},{86,960},{940,960},{940,106},{813,840},{177,840},{813,204},{177,204},{964,999},{11,46},{964,46},{11,999},{557,544},{631,544},{557,618},{631,618},{218,758},{218,838},{298,758},{298,838},{831,868},{262,299},{831,299},{262,868},{101,234},{525,658},{525,234},{101,658},{241,948},{715,948},{241,474},{715,474},{51,957},{987,21},{51,21},{987,957},{241,225},{139,225},{139,327},{241,327},{572,973},{572,415},{14,415},{14,973},{456,399},{724,667},{724,399},{456,667},{546,627},{546,798},{375,798},{375,627},{67,42},{994,969},{67,969}};
//
//        // EXPECTED
////        [,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,][,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,]

//        String[] words = new String[]{"DetectSquares","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add"};
//        int[][] points = new int[][]{{},{282,860},{954,860},{954,188},{282,188},{821,961},{20,961},{20,160},{821,160},{906,231},{906,602},{535,231},{535,602},{63,872},{918,872},{63,17},{918,17},{627,475},{418,475},{418,684},{627,684},{140,844},{984,844},{140,0},{984,0},{739,567},{373,933},{373,567},{739,933},{862,432},{765,432},{862,529},{765,529},{35,991},{993,33},{35,33},{993,991},{109,187},{824,187},{824,902},{109,902},{160,111},{219,170},{160,170},{219,111},{973,19},{5,987},{973,987},{5,19},{221,799},{221,114},{906,114},{906,799},{528,807},{528,574},{761,574},{761,807},{214,441},{214,15},{640,441},{640,15},{899,86},{294,691},{294,86},{899,691},{235,378},{235,758},{615,378},{615,758},{251,292},{920,961},{251,961},{920,292},{153,454},{544,454},{153,845},{544,845},{98,90},{98,764},{772,764},{772,90},{908,87},{360,635},{360,87},{908,635},{95,279},{781,965},{95,965},{781,279},{929,54},{929,982},{1,982},{1,54},{727,907},{817,907},{817,817},{727,817},{332,695},{956,695},{332,71},{956,71},{760,945},{760,187},{2,187},{2,945},{958,963},{958,28},{23,963},{23,28},{742,69},{742,636},{175,636},{175,69},{286,768},{835,219},{286,219},{835,768},{86,982},{992,982},{86,76},{992,76},{366,340},{505,201},{505,340},{366,201},{160,477},{160,816},{499,477},{499,816},{950,974},{20,974},{950,44},{20,44},{183,160},{183,952},{975,952},{975,160},{972,924},{50,924},{50,2},{972,2},{44,22},{887,865},{887,22},{44,865},{741,713},{43,713},{43,15},{741,15},{916,6},{73,849},{916,849},{73,6},{314,350},{484,350},{484,180},{314,180},{452,930},{291,769},{452,769},{291,930},{873,322},{873,979},{216,322}};

        // EXPECTED
//        [,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,][,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,]

        for (int i = 1; i < words.length; i++) {
            if (words[i].equals("add")) {
                squares.add(points[i]);
            } else {
                squares.count(points[i]);
            }
        }
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
