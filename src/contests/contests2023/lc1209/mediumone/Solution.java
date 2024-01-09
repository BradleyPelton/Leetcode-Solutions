package contests.contests2023.lc1209.mediumone;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Accepted after 13 minutes
// 3 attempts rejected. Nasty overflow issues
// Resulted to BigInteger. STudy.

class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {

        List<Integer> goodIndices = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] vars = variables[i];

            // int, long, double
            // Likely a overflow issue
            BigInteger first = new BigInteger(String.valueOf(vars[0])).pow(vars[1]);
            BigInteger second = first.mod(new BigInteger("10"));
            BigInteger third = second.pow(vars[2]);
            BigInteger fourth = third.mod(new BigInteger(String.valueOf(vars[3])));
            int ans = fourth.intValue();
//            long first = (long) Math.pow(vars[0], vars[1]);
//            long second = first % 10;
//            long third = (long) Math.pow(second, vars[2]);
//            long fourth = third % vars[3];
            if (ans == target) {
                goodIndices.add(i);
            }
        }

        System.out.println(goodIndices);
        return goodIndices;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getGoodIndices(
                new int[][]{{2,3,3,10},{3,3,3,1},{6,1,1,4}},
                2
        );
        sol.getGoodIndices(
                new int[][]{{39,3,1000,1000}},
                17
        );




    }
}