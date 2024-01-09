package contests.contests2020.lc0815biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First attempt wrong answer
// Second attempt TLE. Tried brute force as a yolo.


class Solution {
    public int minimumSeconds(List<Integer> nums) {




        // The problem can be simplified to:
        // Return the number that has the shortest distance between all elements

        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (indexMap.containsKey(num)) {
                indexMap.get(num).add(i);
            } else {
                indexMap.put(num, new ArrayList<>(List.of(i)));
            }
        }

        int minDistance = Integer.MAX_VALUE;
        int bestPlacedValue = -42;

        for (int num : indexMap.keySet()) {
            List<Integer> indexes = indexMap.get(num);
            int maxDistanceBetweenIndexes = Integer.MIN_VALUE;
            if (indexes.size() == 1) {
                continue;
            }

            for (int i = 0; i < indexes.size(); i++) {
                int leftVal = indexes.get((i - 1 + indexes.size()) % indexes.size());
                int rightVal = indexes.get((i + 1) % indexes.size());
                int leftDiff = Math.abs(leftVal - i);
                int rightDiff = Math.abs(rightVal - i);
                int minDiff = Math.min(leftDiff, rightDiff);
                maxDistanceBetweenIndexes = Math.max(maxDistanceBetweenIndexes, minDiff);
            }

            if (maxDistanceBetweenIndexes < minDistance) {
                minDistance = maxDistanceBetweenIndexes;
                bestPlacedValue = num;
            }
        }

        int ans = getMinStepsNeededWithNum(bestPlacedValue, indexMap.get(bestPlacedValue).size(), nums);

        System.out.println("ans = " + ans);
        return ans;





















        // Theory: Greedy won't work. Choosing the most frequent element won't work.
        // We need to measure which element has the largest "spread" in the array

        // [1,1,1,1,1,1,2,2,2,2,2] is worst case scenario.
        // We would need a maximum number of steps to reach the center of the "1"s

        // trying greedy anyways, yolo

//        Map<Integer, Integer> freqMap = new HashMap<>();
//        for (int num : nums) {
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//        }
//
//
//        // If nums have the same frequency, one of the nums may have a better performance ("better distributed")
//
//        int minSteps = Integer.MAX_VALUE;
//        for (int num : freqMap.keySet()) {
//            int numFreq = freqMap.get(num);
//            int stepsRequired = getMinStepsNeededWithNum(num, numFreq, nums);
//            minSteps = Math.min(minSteps, stepsRequired);
//        }


    }

    private int getMinStepsNeededWithNum(int mostCommonNum, int mostCommonNumFrequency, List<Integer> listOfNums) {
        int numOfSteps = 0;
        int n = listOfNums.size();
        List<Integer> listCopy = new ArrayList<>(listOfNums);

        while (mostCommonNumFrequency != n) {
            numOfSteps++;

            List<Integer> changeCopy = new ArrayList<>(listCopy);

            for (int i = 0; i < listCopy.size(); i++) {

                if (listCopy.get(i) == mostCommonNum) {
                    continue;
                }
                int leftNum = listCopy.get((i - 1 + n) % n);
                int rightNum = listCopy.get((i + 1) % n);
                if (leftNum == mostCommonNum || rightNum == mostCommonNum) {
                    changeCopy.set(i, mostCommonNum);
                    mostCommonNumFrequency++;
                }
            }

            listCopy = changeCopy;
        }

        return numOfSteps;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.minimumSeconds(new ArrayList<>(List.of(1,2,1,2)));
//        sol.minimumSeconds(new ArrayList<>(List.of(2,1,3,3,2)));
//        sol.minimumSeconds(new ArrayList<>(List.of(5,5,5,5)));
        sol.minimumSeconds(new ArrayList<>(List.of(1,11,11,11,19,12,8,7,19))); // expected 2
    }
}