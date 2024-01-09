package contests.contests2022.lc0212.mediumone;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// First attempt time limit exceeded

// Oof, that was not supposed to be that hard. So many edge cases to handle.

class Solution {
    public int minimumOperations(int[] nums) {

        if (nums.length == 1) {
            return 0;
        } if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }


        Map<Integer, Integer> occMapEvenIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i += 2) {
            int val = nums[i];
            if (occMapEvenIndex.containsKey(val)) {
                int occVal = occMapEvenIndex.get(val);
                occMapEvenIndex.put(val, occVal+1);
            } else {
                occMapEvenIndex.put(val, 1);
            }
        }

        Map<Integer, Integer> occMapOddIndex = new HashMap<>();
        for (int i = 1; i < nums.length; i += 2) {
            int val = nums[i];
            if (occMapOddIndex.containsKey(val)) {
                int occVal = occMapOddIndex.get(val);
                occMapOddIndex.put(val, occVal+1);
            } else {
                occMapOddIndex.put(val, 1);
            }
        }

        PriorityQueue<Integer> evenPQ = new PriorityQueue<Integer>((a, b) -> {
            if (occMapEvenIndex.get(a) > occMapEvenIndex.get(b)) {
                return -1;
            } else {
                return 1;
            }
        });
        evenPQ.addAll(occMapEvenIndex.keySet());

        PriorityQueue<Integer> oddPQ = new PriorityQueue<Integer>((a, b) -> {
            if (occMapOddIndex.get(a) > occMapOddIndex.get(b)) {
                return -1;
            } else {
                return 1;
            }
        });
        oddPQ.addAll(occMapOddIndex.keySet());


//        int evenChoiceVal = -12;
//        int evenChoiceOcc = -12;
//        int secondMostOccEvenVal = -12;
//        int secondMostOccEvenOcc = -12;
//        for(int val : occMapEvenIndex.keySet()) {
//            int occ = occMapEvenIndex.get(val);
//
//            if (occ == evenChoiceVal) {
//                evenChoice.add(val);
//            } else if (occ > evenChoiceVal) {
//                evenChoiceVal = occ;
//                evenChoice.clear();
//                evenChoice.add(val);
//            }
//        }


        // Choose the optimal even and odd
        int evenChoice = evenPQ.poll();
        int oddChoice = oddPQ.poll();
        if (evenChoice == oddChoice) {
            if (oddPQ.isEmpty() && evenPQ.isEmpty()) {
                System.out.println("changing exactly half = " + nums.length/2);
                return nums.length/2;
            } else if (oddPQ.isEmpty()) {
                evenChoice = evenPQ.poll();
            } else  if (evenPQ.isEmpty()) {
                oddChoice = oddPQ.poll();
            } else {
                int evensOccInOdds = occMapOddIndex.get(evenChoice);
                int oddsOccInEvens = occMapEvenIndex.get(oddChoice);

                // if even occurs more in odds, switch even, else switch odd
                if (evensOccInOdds > oddsOccInEvens) {
                    evenChoice = evenPQ.poll();
                } else {
                    oddChoice = oddPQ.poll();
                }
            }
        }

        int numOfOperations = 0;

        int numOfEvensTotal = -12;
        int numOfOddsTotal = -12;

        if (nums.length % 2 == 0) {
            numOfEvensTotal = nums.length/2;
            numOfOddsTotal = nums.length/2;
        } else {
            numOfEvensTotal = nums.length/2 + 1;
            numOfOddsTotal = nums.length/2;
        }

        // count even flips
        numOfOperations += numOfEvensTotal - occMapEvenIndex.get(evenChoice);

        // count odd flips
        numOfOperations += numOfOddsTotal - occMapOddIndex.get(oddChoice);

        System.out.println("final ans = " + numOfOperations);
        return numOfOperations;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.minimumOperations(new int[]{3,1,3,2,4,3});
//        sol.minimumOperations(new int[]{1,2,2,2,2});
//        sol.minimumOperations(new int[]{1});
//        sol.minimumOperations(new int[]{2,2,2,2});
        sol.minimumOperations(new int[]{1,7,3,7,3,7,3,7,3,7,3,7,3,7});
    }
}
