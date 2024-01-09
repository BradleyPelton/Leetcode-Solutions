package contests.contests2021.lc1120.mediumtwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// First attempt wrong answer (forgot nullpointer exception)
// Second attempt

class RangeFreqQuery {

    Map<Integer, ArrayList<Integer>> occLocations;

    public RangeFreqQuery(int[] arr) {

        occLocations = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (occLocations.containsKey(val)) {
                occLocations.get(val).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                occLocations.put(val, temp);
            }
        }
    }

    public int query(int left, int right, int value) {

        ArrayList<Integer> occs;
        if (occLocations.containsKey(value) == false) {
            return 0;
        } else {
            occs = occLocations.get(value);
        }

        int leftBinary = Collections.binarySearch(occs, left);
        int rightBinary = Collections.binarySearch(occs, right);

        if (leftBinary == -1) {
            leftBinary = 0;
        } else {
            leftBinary = Math.abs(leftBinary);
        }
        if (rightBinary == -1) {
            rightBinary = 0;
        } else {
            rightBinary = Math.abs(rightBinary);
        }
        int ans = rightBinary - leftBinary + 1;


//        int ans = 0;
//        for (int i = 0; i < occs.size(); i++) {
//            if (occs.get(i) >= left) {
//                if (occs.get(i) <= right) {
//                    ans++;
//                } else {
//                    return ans;
//                }
//            }
//        }
        System.out.println("ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {

        RangeFreqQuery rfq = new RangeFreqQuery(new int[]{1,1,1,1,2,2,2,4,4,4,4,4,4,4,4,4,4,4,4,4});
        rfq.query(1, 13, 1);

//
//        RangeFreqQuery rfq = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
//        rfq.query(1, 2, 4);
//        rfq.query(0, 11, 33);

//        RangeFreqQuery rfq = new RangeFreqQuery(new int[]{8,4,2,5,4,5,8,6,2,3});
//        rfq.query(0,3,5);
//        rfq.query(5,6,2);
//        rfq.query(6,8,4);
//        rfq.query(2,8,3);
//        rfq.query(4,5,1);
//        rfq.query(2,4,2);
//        rfq.query(0, 11, 33);


    }
}