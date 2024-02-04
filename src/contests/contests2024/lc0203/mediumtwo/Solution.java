package contests.contests2024.lc0203.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted at 7:48pm
// Accepted second attempt

// Painful problem. 4 nested loops.
// Question wording was vague and spent 15 minutes debugging.

class Solution {

    int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;
    public int[][] resultGrid(int[][] image, int threshold) {
        m  = image.length;
        n = image[0].length;

        Map<Integer, Map<Integer, List<Integer>>> regionMap = new HashMap<>(); // WHAT REGION DOES EACH COORDINATE BELONG TO
        for (int i = 0; i < m; i++) {
            regionMap.put(i, new HashMap<>());
            for (int j = 0; j < n; j++) {
                regionMap.get(i).put(j, new ArrayList<>());
            }
        }

        Map<Integer, Integer> regionValueMap = new HashMap<>();

        int regionIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i + 2 >= m || j + 2 >= n) {
                    continue; // Not a whole 3x3 grid
                }
                boolean allPixelsAreValid = true;
                int totalIntensityOfRegion = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        int[] currCoord = new int[] {k, l};
                        for (int[] dir : DIRS) {
                            int[] updatedCoord = {currCoord[0] + dir[0], currCoord[1] + dir[1]};
                            if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                                if (updatedCoord[0] >= i && updatedCoord[0] <= i + 2) {
                                    if (updatedCoord[1] >= j && updatedCoord[1] <= j + 2) {
                                        int diff = Math.abs(image[currCoord[0]][currCoord[1]] - image[updatedCoord[0]][updatedCoord[1]]);
                                        if (diff > threshold) {
                                            allPixelsAreValid = false;
                                        }
                                    }
                                }
                            }
                        }
                        if (allPixelsAreValid) {
                            totalIntensityOfRegion += image[k][l];
                        }
                    }
                }

                if (allPixelsAreValid) {
                    int regionIntensity = (int)Math.floor(totalIntensityOfRegion / 9.0);
                    regionValueMap.put(regionIndex, regionIntensity);
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            regionMap.get(k).get(l).add(regionIndex);
                        }
                    }
                    regionIndex++;
                }
            }
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> regions = regionMap.get(i).get(j);
                if (regions.isEmpty()) {
                    result[i][j] = image[i][j];
                } else {
                    double totalRegionSum = 0.0;
                    for (int region : regions) {
                        totalRegionSum += regionValueMap.get(region);
                    }
                    int localAns = (int) Math.floor(totalRegionSum / regions.size());
                    result[i][j] = localAns;
                }
            }
        }

        System.out.println(Arrays.deepToString(result));
        return result;
    }

    private boolean isValidCoordinate(int i, int j) {
        return i < m && i >= 0 && j >= 0 && j < n;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();
        sol.resultGrid(
                new int[][]{{5,6,7,10},{8,9,10,10},{11,12,13,10}},
                3
        );
        sol.resultGrid(
                new int[][]{{10,20,30},{15,25,35},{20,30,40},{25,35,45}},
                12
        );
        sol.resultGrid(
                new int[][]{{5,6,7},{8,9,10},{11,12,13}},
                1
        );
        sol.resultGrid(
                new int[][]{{1,1,4,1},{10,8,13,17},{2,12,1,16}},
                14
        ); // [[5,5,5,1],[5,5,5,17],[5,5,5,16]]

        // OUTPUT [[1,1,4,1],[10,8,13,17],[2,12,1,16]]


    }
}