package contests.contests2022.lc0416.mediumone;

import java.util.HashMap;
import java.util.Map;

// First attempt wrong answer
// Second attempt accepted at 8:04pm
// Sloppy solution. I ended up just hardcoding the results for 1,2,3,4 to submit faster

class Solution {
    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> occMap = new HashMap<>();
        for (int e : tasks) {
            if (occMap.containsKey(e)) {
                int currOcc = occMap.get(e);
                occMap.put(e, ++currOcc);
            } else {
                occMap.put(e, 1);
            }
        }

        int numberOfRounds = 0;
        for(int e : occMap.keySet()) {
            int totalOcc = occMap.get(e);

            if (totalOcc == 1) {
                System.out.println("1 from the start");
                return -1;
            } else if (totalOcc == 2) {
                numberOfRounds++;
                continue;
            } else if (totalOcc == 3) {
                numberOfRounds++;
                continue;
            } else if (totalOcc == 4) {
                numberOfRounds++;
                numberOfRounds++;
                continue;
            }


            // FIRST ROUND
            int numberOfThrees = totalOcc/3;
            numberOfRounds += numberOfThrees;
            totalOcc -= (numberOfThrees * 3);

            if (totalOcc == 0) {
                continue;
            } else if (totalOcc == 2) {
                numberOfRounds++;
            } else if(totalOcc == 1) {
                // UNDO
                numberOfRounds -= numberOfThrees;

                // restart, but with assuming at least 1 group of "2" tasks
                totalOcc = occMap.get(e);
                if (totalOcc > 3) {
                    // start with the assumption at least one group of 2
                    totalOcc -= 2;
                    numberOfRounds++;

                    numberOfThrees = totalOcc/3;
                    numberOfRounds += numberOfThrees;
                    totalOcc -= (numberOfThrees * 3);

                    if (totalOcc == 2) {
                        numberOfRounds++;
                    } else if (totalOcc == 0) {
                        continue;
                    } else if (totalOcc == 1) {
                        System.out.println("STILL 1 AFTER SECOND ATTEMPT, e = " + e);
                        return -1;
                    }
                }
            }
        }


        System.out.println("final ans = " + numberOfRounds);
        return numberOfRounds;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4});
        sol.minimumRounds(new int[]{2,3,3});
        sol.minimumRounds(new int[]{5,5,5,5}); // expected 2
    }
}
