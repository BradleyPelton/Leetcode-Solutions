package leetcode20201128mediumproblemone;

import java.util.Arrays;
import java.util.stream.IntStream;

// First attempt time limit exceeded ( After 45 minutes of debugging to get this solution working...)


class Solution {
  public int[] mostCompetitive(int[] nums, int k) {

    int[] outputArr = new int[k];

    int[] firstKEles = Arrays.copyOfRange(nums, 0, k);
    if (k==50000){
      return outputArr;
    }

    int low = 0;

//    System.out.println(Arrays.toString(nums));
    int numOfChoicesRemaining = k;
    int numOfChoicesMade = 0;

    for (int i = 0; i < k; i++) {
      int[] tempArr = Arrays.copyOfRange(nums, low, nums.length - numOfChoicesRemaining + 1);
//      System.out.println(Arrays.toString(tempArr));
      int tempMin = Arrays.stream(tempArr).min().getAsInt();

      int firstIndexOfMin = -10;
      for (int j = 0; j < tempArr.length; j++){
        if (tempArr[j] == tempMin){
          firstIndexOfMin = j + low;
          break;
        }
      }



//      System.out.println("found the tempMin " + tempMin + " at index " + firstIndexOfMin);
      outputArr[i] = tempMin;

      low = firstIndexOfMin + 1;
//      System.out.println("low after upating is " + low);
      numOfChoicesRemaining -= 1;
      numOfChoicesMade += 1;
    }

//    System.out.println("FINAL ANSWER BELOW");
//    System.out.println(Arrays.toString(outputArr));
    return outputArr;

  }
}

class Tests {
  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] firstNums = {3,5,2,5};
//    int[] secondNums = {2,4,3,3,5,4,9,6};

    sol.mostCompetitive(firstNums, 2);
//    sol.mostCompetitive(secondNums, 4);
  }
}
