package contests.contests2021.lc0911.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 8 minutes
// Trivial occMap usage

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {

        Map<Double, Long> occMap = new HashMap<>();
        long ans = 0L;

        for (int[] rec : rectangles) {
           double ratio = ((double)rec[0])/rec[1];
           occMap.put(ratio, occMap.getOrDefault(ratio,0L)+1 );
        }

        for (Double d : occMap.keySet()) {
//            System.out.println(d + " occurs " + occMap.get(d));
            long occ =  occMap.get(d);
            ans += (Long) ((occ) * (occ - 1))/2;
        }

//        System.out.println("final ans is  " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.interchangeableRectangles(
                new int[][]{{4,8},{3,6},{10,20},{15,30}}
        );

        sol.interchangeableRectangles(
                new int[][]{{4,5},{7,8}}
        );
    }
}