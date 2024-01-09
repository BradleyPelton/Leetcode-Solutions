package contests.contests2023.lc1225.mediumtwo;

import java.util.*;

// First attempt, TLE
// Second attempt, TLE

class Solution {
    public long[] getDistances(int[] arr) {

        Map<Integer, ArrayList<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (indexMap.containsKey(val)) {
                indexMap.get(val).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                indexMap.put(val, temp);
            }
        }

        long[] ans = new long[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            int val = arr[i];
//            ArrayList<Integer> occs = indexMap.get(val);
//
//            Long intervalSum = 0L;
//
//            int centerIndex = Collections.binarySearch(occs, i);
//
//            long lessThanSum = 0L;
//            for (int j = 0; j < centerIndex; j++) {
//                lessThanSum += occs.get(j);
//            }
//            long lessThanVal = (centerIndex * i) - lessThanSum;
//
//            long greaterThanSum = 0L;
//            for (int j = centerIndex + 1; j < occs.size(); j++) {
//                greaterThanSum += occs.get(j);
//            }
//            long greaterThanVal = greaterThanSum - ((occs.size() - 1 - centerIndex) * i);
//
//            ans[i] = lessThanVal + greaterThanVal;
//        }

        for (Integer val : indexMap.keySet()) {
            ArrayList<Integer> occs = indexMap.get(val);

            // <2,5,6>
//            2 - 2
//            2 - 5
//            2 - 6

//            5 - 2
//            5 - 5
//            5 - 6

            long indexSum = occs.stream()
                    .mapToInt(a -> a)
                    .sum();
            ans[occs.get(0)] = indexSum - (occs.size() * occs.get(0));

            long sumBefore = 0;
            long sumAfter = indexSum;

            for (int i = 1; i < occs.size(); i++) {
                sumBefore += occs.get(i - 1);
                sumAfter -= occs.get(i - 1);

            }
        }

        System.out.println(Arrays.toString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.getDistances(new int[]{2,1,3,1,2,3,3});
//        sol.getDistances(new int[]{10,5,10,10});
//        sol.getDistances(new int[]{1,1,1,1,1});

        // |0 - 2| + |1 - 2| + || + |3 - 2| + |4 - 2|


    }
}