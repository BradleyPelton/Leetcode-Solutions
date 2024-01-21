package contests.contests2024.lc0120biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int minimumArrayLength(int[] nums) {
        int zeroCount = 0;
        Map<Integer, Integer> occMap = new HashMap<>();
        for (int val : nums) {
            if (val == 0) {
                zeroCount++;
            } else {
                occMap.put(val, occMap.getOrDefault(val, 0) + 1);
            }
        }
        PriorityQueue<int[]> numPQ = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        for (int key : occMap.keySet()) {
            numPQ.add(new int[]{key, occMap.get(key)});
        }

        while (!numPQ.isEmpty()) {
            int[] largest = numPQ.remove();
            if (numPQ.isEmpty()) {
                if (largest[1] % 2 == 0) {
                    zeroCount += largest[1]/2;
                } else {
                    zeroCount += (largest[1] + 1)/2;
                }
                break;
            }
            int[] secondLargest = numPQ.remove();

            if (largest[0] == secondLargest[0]) {
                numPQ.add(new int[]{largest[0], largest[1] + secondLargest[1]});
                continue;
            }

            int minOcc = Math.min(largest[1], secondLargest[1]);

            int remVal = secondLargest[0] % largest[0];
            if (remVal == 0) {
                zeroCount += minOcc;
            } else {
                numPQ.add(new int[]{remVal, minOcc});
            }

            largest[1] -= minOcc;
            secondLargest[1] -= minOcc;
            if (largest[1] != 0) {
                numPQ.add(largest);
            }
            if (secondLargest[1] != 0) {
                numPQ.add(secondLargest);
            }
        }

        System.out.println(zeroCount);
        return zeroCount;

    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.minimumArrayLength(
//                new int[]{1,4,3,1}
//        ); // 1
//        sol.minimumArrayLength(
//                new int[]{5,5,5,10,5}
//        ); // 2
//        sol.minimumArrayLength(
//                new int[]{2,3,4}
//        ); // 1
//        sol.minimumArrayLength(
//                new int[]{1}
//        ); // 1
//        sol.minimumArrayLength(
//                new int[]{3,3,1}
//        ); // 1
//        sol.minimumArrayLength(
//                new int[]{4,4,4}
//        ); // 2
//        sol.minimumArrayLength(
//                new int[]{1,2,3,2}
//        ); // 1

        sol.minimumArrayLength(
                new int[]{5,2,2,2,9,10}
        ); // 1






    }
}