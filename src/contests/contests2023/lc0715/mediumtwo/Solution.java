package contests.contests2023.lc0715.mediumtwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int totalDominantVal = 0;
        int totalDominantFreq = 0;

        Map<Integer, Integer> totalFreq = new HashMap<>();
        for (int num : nums) {
            int newFrequencyOfCurrVal = totalFreq.getOrDefault(num, 0) + 1;
            totalFreq.put(num, newFrequencyOfCurrVal);

            if (newFrequencyOfCurrVal > totalDominantFreq) {
                totalDominantFreq = newFrequencyOfCurrVal;
                totalDominantVal = num;
            }
        }

        int leftDominantVal = 0;
        int leftDominantFreq = 0;

        Map<Integer, Integer> frequencySoFar = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int currVal = nums.get(i);
            int newFrequencyOfCurrVal = frequencySoFar.getOrDefault(currVal, 0) + 1;
            frequencySoFar.put(currVal, newFrequencyOfCurrVal);

            if (newFrequencyOfCurrVal > leftDominantFreq) {
                leftDominantVal = currVal;
                leftDominantFreq = newFrequencyOfCurrVal;

                if (leftDominantVal == totalDominantVal) {
                    System.out.println("solution found at i = " + i);
                    return i;
                }
            }
        }
        System.out.println("no solution found, return -1");
        return -1;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.minimumIndex(List.of(1,2,2,2));
        sol.minimumIndex(List.of(2,1,3,1,1,1,7,1,2,1));
//        sol.minimumIndex(List.of(3,3,3,3,7,2,2));
    }
}
