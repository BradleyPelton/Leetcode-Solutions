package contests.contests2021.lc0918biweekly.mediumone;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// rejected first attempt, missed a continue statement for 0 edge case
// Accepted second attempt

// COol problem. I thought sorting was the original answer, but an occMap worked wonders

class Solution {
    public int[] findOriginalArray(int[] changed) {

        Arrays.sort(changed);

        if (changed.length % 2 == 1) {
            System.out.println("odd number of elements, impossible");
            return new int[]{};
        }

        Map<Integer,Integer> occMap = new ConcurrentHashMap<>();

        for (int i = 0; i < changed.length; i++) {
            occMap.put(changed[i], occMap.getOrDefault(changed[i], 0)+1);
        }


        // CONSTRUCT ORIGINAL ARR
        List<Integer> originalArr = new ArrayList<>();
        for (Integer key : occMap.keySet()) {
            int keyOcc = occMap.get(key);
            int doubleKey = key * 2;
            int doubleKeyOcc = occMap.getOrDefault(doubleKey, 0);

            if (key == 0) {
                if (keyOcc % 2 == 1) {
                    System.out.println("impssible ZERO KEY SCENARIO");
                    return new int[]{};
                } else {
                    for (int i = 0; i < keyOcc / 2; i++) {
                        originalArr.add(key);
                    }
                }
                occMap.put(key, 0);
                continue;
            }

            if (doubleKeyOcc >= keyOcc) {
                for (int i = 0; i < keyOcc; i++) {
                    originalArr.add(key);
                }

                occMap.put(key, 0);
                occMap.put(doubleKey, doubleKeyOcc - keyOcc);
            } else {        // else if (doubleKeyOcc < keyOcc) {
                for (int i = 0; i < doubleKeyOcc; i++) {
                    originalArr.add(key);
                }

                occMap.put(key, keyOcc - doubleKeyOcc);
                occMap.put(doubleKey, 0);
            }
        }

        System.out.println("original arr below");
        System.out.println(originalArr);


        int[] ansArr = originalArr.stream().mapToInt(i -> i).toArray();


        if (originalArr.size() == changed.length/2) {
            System.out.println("EXACTLY HALF THE SIZE, RETURNING ORIGINALARR");
//            System.out.println("returning  " + Arrays.toString(ansArr));
            return ansArr;
        } else {
            System.out.println("originalArr not big enough");
            return new int[]{};
        }



//        // TEST IF ANYTHING IS LEFT AFTER CONSTRUCTING
//        for (Integer key : occMap.keySet()) {
//            if (occMap.get(key) != 0) {
//                System.out.println("occMap.get( " + key + " still has results");
//            }
//        }

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.findOriginalArray(new int[]{1,3,4,2,6,8});
//        sol.findOriginalArray(new int[]{6,3,0,1});
//        sol.findOriginalArray(new int[]{1});
        sol.findOriginalArray(new int[]{0,0,0,0});

    }
}