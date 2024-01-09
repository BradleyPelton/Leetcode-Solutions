package contests.contests2021.lc0821.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {

        HashMap<Integer, Integer> smallestValMap = new HashMap<>();

        int totalSmallestSum = 0;
        for (int i = 0; i < mat.length; i++) {
            int smallest = Arrays.stream(mat[i]).min().getAsInt();
            totalSmallestSum += smallest;
            smallestValMap.put(i, smallest);
        }
        target -= totalSmallestSum;

        if (target <= 0) {
            System.out.println("trivial, all smallest");
            System.out.println("returning " + target);
            return target;
        }


        int[][] diffMatrix = mat.clone();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                diffMatrix[i][j] -= smallestValMap.get(i);
            }
        }


        return 0;





    }
}