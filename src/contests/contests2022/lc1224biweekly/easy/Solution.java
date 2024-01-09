package contests.contests2022.lc1224biweekly.easy;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int captureForts(int[] forts) {
        
        int maxNumberOfForts = 0;

        List<Integer> goodFortPositions = new ArrayList<>();
        List<Integer> emptySpots = new ArrayList<>();

        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                goodFortPositions.add(i);
            } else if (forts[i] == -1) {
                emptySpots.add(i);
            }
        }

        if (goodFortPositions.size()  == 0 || emptySpots.size() == 0) {
            System.out.println("Only one fort, returning 0");
            return 0;
        }

        for (int firstFort : goodFortPositions) {
            for (int emptySpot : emptySpots) {
                int numberOfCapturedForts = 0;

                if (firstFort < emptySpot) {
                    for (int i = firstFort + 1; i < emptySpot; i++) {
                        if (forts[i] == 0) {
                            numberOfCapturedForts += 1;
                        } else if (forts[i] == -1) {
                            numberOfCapturedForts = -1;
                            break;
                        } else if (forts[i] == 1) {
                            numberOfCapturedForts = -1;
                            break;
                        }
                    }
                } else if (firstFort > emptySpot) {
                    for (int i = firstFort -1; i > emptySpot; i--) {
                        if (forts[i] == 0) {
                            numberOfCapturedForts += 1;
                        } else if (forts[i] == -1) {
                            numberOfCapturedForts = -1;
                            break;
                        } else if (forts[i] == 1) {
                            numberOfCapturedForts = -1;
                            break;
                        }
                    }
                }


                if (numberOfCapturedForts > maxNumberOfForts) {
                    maxNumberOfForts = numberOfCapturedForts;
                }
            }
        }

        System.out.println("Max number of forts = " + maxNumberOfForts);
        return maxNumberOfForts;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.captureForts(new int[]{1,0,0,-1,0,0,0,0,1});  // 4
//        sol.captureForts(new int[]{0,0,1,-1});  // 0
//        sol.captureForts(new int[]{1,0,0,-1}); // 2
        sol.captureForts(new int[]{-1,0,-1,0,1,1,1,-1,-1,-1}); // 1

    }
}
