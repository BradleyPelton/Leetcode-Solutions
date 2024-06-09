package contests.contests2024.lc0601.hard;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        return -42;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumDifference(
                new int[]{1,2,4,5},
                3
        );
        sol.minimumDifference(
                new int[]{1,2,1,2},
                2
        );
        sol.minimumDifference(
                new int[]{1},
                10
        );




    }
}