package leetcode20201205mediumone;

import java.util.HashMap;
import java.util.Map;

// First submission rejected, wrong answer

// SEcond answer accepted after 50 minutes at 10:32 pm EST
// This took me WAYYYY to long... simple edge case handling where desired val = val.
// I knew hashing the number of occurences was the most time efficient method for completing this.

class Solution {
    public int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> occMap = new HashMap<Integer, Integer>();

        for (int n : nums){
            try {
                int currVal = occMap.get(n);
                occMap.put(n, currVal + 1);
            } catch (NullPointerException e){
                occMap.put(n, 1);
            }
        }

//        for (int i : occMap.keySet()){
//            System.out.println("Number of occurences of " + i + " is equal to " + occMap.get(i));
//        }


      int ans = 0;


      for (int i : occMap.keySet()){
          int numberOfIOccs = occMap.get(i);
          try {
            int desiredVal = k - i;
            if (desiredVal == i){
              int numberOfDesiredVals = occMap.get(desiredVal);
              int numberOfPairs = numberOfDesiredVals/2;
              ans += numberOfPairs;

              occMap.put(i, numberOfIOccs - numberOfPairs);
            } else {

            int numberOfDesiredVals = occMap.get(desiredVal);

            int numberOfPairs = Math.min(numberOfIOccs, numberOfDesiredVals);
            ans += numberOfPairs;

            occMap.put(i, numberOfIOccs - numberOfPairs);
            occMap.put(desiredVal, numberOfDesiredVals - numberOfPairs);
            }
            } catch (NullPointerException e){
                continue;
            }
        }


//        for (int j : nums){
//            int targetVal = k - j;
//            try {
//                int numberOfVals = intMap.get(targetVal);
//                if (targetVal == j && numberOfVals > 1){
//                  intMap.put(targetVal, numberOfVals - 2);
//                  ans += 1;
//                } else if (targetVal != j && numberOfVals > 0){
//                  intMap.put(targetVal, numberOfVals - 1);
//                  int numberOfJVals = intMap.get(j);
//                  intMap.put(j, numberOfJVals - 1);
//
//                  ans += 1;
//                }
//            } catch (NullPointerException e){
//                continue;
//            }
//        }

      System.out.println("final ans is " + ans);

      return ans;

    }
}

class Tests {
  public static void main(String[] args) {
    //

      int[] firstArr = {1,2,3,4};
      int[] secondArr = {3,1,3,4,3};

      int[] thirdArr = {2,2,2,3,1,1,4,1};

      Solution sol = new Solution();
    sol.maxOperations(firstArr, 5);
    sol.maxOperations(secondArr, 6);
    sol.maxOperations(thirdArr, 4);  // Expected 2
  }
}