package contests.contests2021.lc0717.mediumone;

// First attempt time limit exceeded

// Accepted at 10:54 pm
// Accepted after 4 attempts. Annoying edge case where. Had to recalculate distance to distance needed not distance from next rung

class Solution {
    public int addRungs(int[] rungs, int dist) {

        int currentHeight = 0;
        int numberOfAddedRungs = 0;

        for (int i = 0; i < rungs.length; i++) {
            int targetHeight = rungs[i];

            while (currentHeight < targetHeight) {
                // if runs are needed
                if (currentHeight + dist < targetHeight) {
                    int distanceNeeded = targetHeight - currentHeight - dist;
//                    int numberOfRungsNeeded = distanceNeeded/dist;
                    int numberOfRungsNeeded = (int) Math.ceil(((double)distanceNeeded)/dist);
                    numberOfAddedRungs+= numberOfRungsNeeded;
                    currentHeight += dist*numberOfRungsNeeded;
                } else {
                    currentHeight = targetHeight;
                }
            }
        }

        System.out.println("final ans " + numberOfAddedRungs);
        return numberOfAddedRungs;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.addRungs(new int[]{1,3,5,10}, 2); // expected = 2
        sol.addRungs(new int[]{3,6,8,10}, 3); // expected = 0
        sol.addRungs(new int[]{3,4,6,7}, 2); // expected = 1
        sol.addRungs(new int[]{5}, 10); // expected = 0


        sol.addRungs(new int[]{3}, 1); // expected = 2

    }
}