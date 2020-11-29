package leetcode20201128easy;

import java.util.Arrays;

// Accepted after 8 minutes
// Accepted after first try

// Spent more time writing the test cases than writing the solution

// I'm sure there is a a one liner for this, but my solution spelled it out pretty well.

class Solution {
    public int maximumWealth(int[][] accounts) {

        int[] wealthArr = new int[accounts.length];

        for (int i=0; i<accounts.length; i++){
            int personWealth = 0;
            for (int j=0; j<accounts[0].length; j++){
                // J ARE BANKS
                personWealth += accounts[i][j];
            }

            wealthArr[i] = personWealth;
        }

//    System.out.println(Arrays.toString(wealthArr));


    int ans = Arrays.stream(wealthArr).max().getAsInt();
//    System.out.println(ans);

    return ans;
    }
}

class Tests {
  public static void main(String[] args) {
    //

      Solution sol = new Solution();
      int[][] firstArr = {{1,2,3},{3,2,1}};
      int[][] secondArr = {{1,5},{7,3},{3,5}};

      sol.maximumWealth(firstArr);
      sol.maximumWealth(secondArr);
  }
}