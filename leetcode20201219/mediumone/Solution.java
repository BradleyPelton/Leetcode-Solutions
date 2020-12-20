package leetcode20201219.mediumone;

import java.util.ArrayList;
//import java.util.Arrays;

// First attempt rejected. Edge case, length = 1;
// Second attempt rejected, time limit exceeded;
// Third attempt rejected, time limit exceeded;
// Fourth attempt rejected, time limit exceeded; I'm obviously not improving the time complexity enough
// Fifth attempt rejected, time limit exceeded. Frustrating.



class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        // Sliding window

        if (nums.length == 1) {
            return nums[0];
        }
        int greatestSum = 0;

        ArrayList<Integer> currArr = new ArrayList<Integer>();
        currArr.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int chopIndex = currArr.indexOf(nums[i]);
//            System.out.println(chopIndex);
            if (chopIndex != -1) {
//                System.out.println("found a duplicate, chop index is equal to " + chopIndex);
                currArr.add(nums[i]);
                for (int j = 0; j < chopIndex + 1; j++){
                    currArr.remove(0);
                }
            } else {
                currArr.add(nums[i]);
            }

//            System.out.println(Arrays.toString(currArr.toArray()));

            int currSum = 0;
            currSum = currArr.stream().mapToInt(a -> a).sum();

            if (currSum > greatestSum) {
                greatestSum = currSum;
            }
        }

//        System.out.println("greatest sum at the end is " + greatestSum);

        return greatestSum;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] firstArr = {4,2,4,5,6};
        int[] secondArr = {5,2,1,2,5,2,1,2,5};
        int[] thirdArr = {10000};



        sol.maximumUniqueSubarray(firstArr);
        sol.maximumUniqueSubarray(secondArr);
        System.out.println(sol.maximumUniqueSubarray(thirdArr));
    }
}