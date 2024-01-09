package contests2020q4.leetcode20201212biweekly.leetcode20201212mediumone;

import java.util.HashMap;
import java.util.Map;

// FIrst attempt rejected, time limited exceed.
// I knew the brute force was too long... I should have trusted my instincts.

// Accepted after second try
// Great optimization. Cache the sum so far
// SPent 20 minutes debugging "diffAfterI". Off by one error sigh
// Accepted at 10:20am EST

// I could sae a bunch of time by just using the debugger instead of so many print statements...
// I need to use the debugger until it is second nature and stop using sout



class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {


        int sumSoFar = 0;

        Map<Integer, Integer> sumSoFarMap = new HashMap<Integer, Integer>();

        for(int i=0; i< nums.length; i++){
            sumSoFar += nums[i];
            sumSoFarMap.put(i, sumSoFar);
        }

        int totalSum = sumSoFar;

//        for(int j: sumSoFarMap.keySet()){
//      System.out.println("index " + j + " has value " + sumSoFarMap.get(j));
//        }

        int[] outputArr = new int[nums.length];

        outputArr[0] = totalSum - (nums[0]*(nums.length));

        for (int i=1; i< nums.length; i++){
            // SUM (Math.abs( nums[i] - nums[j]) from j=0 to j=nums.length
            // IS EQUALIVENT TO
            // nums[i] * nums.length - (sum_of_values)
//            outputArr[i] = nums[i] * nums.length - sumSoFar - nums[i];

            int sumBeforeI = sumSoFarMap.get(i-1);
            int sumAfterI = totalSum - sumBeforeI - nums[i];
//            System.out.println("i is " + i);
//            System.out.println("sum before i is " + sumBeforeI);
//            System.out.println("sum after i is " + sumAfterI);

            int diffBeforeI = nums[i] * i - (sumBeforeI);
            int diffAfterI = sumAfterI - (nums.length - i-1) * nums[i];

//            nums[i] * i
//            since non-decreasing
//            sum(nums[i] - nums[j]) = nums[i]*n


//            System.out.println("diff before i is equal to " + diffBeforeI);
//            System.out.println("diff after i is equal to " + diffAfterI);

            outputArr[i] = diffBeforeI + diffAfterI;
        }


//        // BRUTE FORCE SOLUTION
//        int[] outputArr = new int[nums.length];
//
//        for (int i=0; i<nums.length; i++){
//            int diffSum = 0;
//            for (int j=0; j<nums.length; j++){
//                if (i != j){
//                    diffSum += Math.abs(nums[i] - nums[j]);
//                }
//            }
//            outputArr[i] = diffSum;
//        }

//    System.out.println(Arrays.toString(outputArr));

        return outputArr;
    }
}

class Test {
  public static void main(String[] args) {
    contests2020q4.leetcode20201212.leetcode20201212mediumone.Solution sol = new contests2020q4.leetcode20201212.leetcode20201212mediumone.Solution();

    int[] firstNums = {2,3,5};
    int[] secondNums = {1,4,6,8,10};

      sol.getSumAbsoluteDifferences(firstNums);
      sol.getSumAbsoluteDifferences(secondNums);
  }
}