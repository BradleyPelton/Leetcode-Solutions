package contests.contests2021.lc1120.easy;

// Accepted after 3 minutes, trivial

class Solution {
    public int maxDistance(int[] colors) {

        int furthestDistance = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i+1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    if (Math.abs(i - j) > furthestDistance) {
                        furthestDistance = Math.abs(i - j);
                    }
                }
            }
        }

        System.out.println("ans = " + furthestDistance);
        return furthestDistance;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.maxDistance(new int[]{1,1,1,6,1,1,1});
        sol.maxDistance(new int[]{1,8,3,8,3});
        sol.maxDistance(new int[]{0,1});
    }
}
