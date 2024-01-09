package contests.contests2022.lc1224.mediumtwo;

import java.util.Arrays;

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;

        // Choose prices that are as spread out as possible


        return -42;




    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumTastiness(new int[]{13,5,1,8,21,2}, 3);
        sol.maximumTastiness(new int[]{1,3,1}, 2);
        sol.maximumTastiness(new int[]{7,7,7,7}, 2);
    }
}