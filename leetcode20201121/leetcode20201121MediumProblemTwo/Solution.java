package leetcode20201121MediumProblemTwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int waysToMakeFair(int[] nums) {

        int evenSumSoFar = 0;
        int oddSumSoFar = 0;

        Map<Integer, int[]> soFarMap = new HashMap<Integer, int[]>();

        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                evenSumSoFar += nums[i];
            }else{
                oddSumSoFar += nums[i];
            }

            soFarMap.put(i,new int[] {evenSumSoFar, oddSumSoFar});
        }


//        for(int j: soFarMap.keySet()){
//            System.out.println(j + " " + Arrays.toString(soFarMap.get(j)));
//        }


        int totalNumOfAnswers = 0;
        for(int i=0; i<nums.length; i++){
            // {0,1,2,3,4,5 ... , n, ...., 10, 11, 12 }
            // {0,1,2,3,4,5,6,7,8}

            int evensBeforeI, oddsBeforeI;
            if(i%2==0){
                // e.g. i = 4 , nums[i] = 4;
                evensBeforeI = soFarMap.get(i)[0] - nums[i]; // 2
                oddsBeforeI = soFarMap.get(i)[1]; // 4

            } else{
                // e.g. i = 4 , nums[i] = 4;
                evensBeforeI = soFarMap.get(i)[0]; // 2
                oddsBeforeI = soFarMap.get(i)[1] - nums[i]; // 4

            }

            int evensAfterI = evenSumSoFar - evensBeforeI;
            int oddsAfterI = oddSumSoFar - oddsBeforeI;

            int oddsAfterRemoval = oddsBeforeI + evensAfterI;
            int evensAfterRemoval = evensBeforeI + oddsAfterI;
            System.out.println(evensAfterRemoval + " " + oddsAfterRemoval);
            if(evensAfterRemoval==oddsAfterRemoval){
                totalNumOfAnswers += 1;
            }

        }
        System.out.println("final ans is" + totalNumOfAnswers);
        return 5;
    }
}

class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] firstArr = {2,1,6,4};
        sol.waysToMakeFair(firstArr);
    }
}