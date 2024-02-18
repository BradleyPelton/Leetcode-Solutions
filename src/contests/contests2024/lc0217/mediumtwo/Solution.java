package contests.contests2024.lc0217.mediumtwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// Accepted after first Attempt
// Accepted after 25 minutes
// Very tedious problem. 3 different nested methods.

class Solution {
    int[][] mat;
    int m;
    int n;
    Map<String, Integer> occMap;

    int[][] EIGHT_DIRS = {
            {1,0},
            {1,1},
            {1,-1},
            {0,1},
            {0, -1},
            {-1, 1},
            {-1, -1},
            {-1 , 0}
    };

    public int mostFrequentPrime(int[][] mat) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        occMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                buildStrings(i, j);
            }
        }

        int[][] valAndOcc = new int[occMap.size()][2];
        int i = 0;
        for (String key : occMap.keySet()) {
            valAndOcc[i] = new int[] {Integer.parseInt(key), occMap.get(key)};
            i++;
        }

        Arrays.sort(valAndOcc, Comparator.comparingInt(a -> -a[1])); // .thenComparing would have simplified next 20 lines
        int ans = -1;
        int ansOcc = 0;
        for (int j = 0; j < valAndOcc.length; j++) {
            if (valAndOcc[j][1] < ansOcc) {
                break;
            }
            if (valAndOcc[j][0] > 10) {
                if (isPrime(valAndOcc[j][0])) {
                    if (valAndOcc[j][1] > ansOcc) {
                        ans = valAndOcc[j][0];
                        ansOcc = valAndOcc[j][1];
                    } else if (valAndOcc[j][1] == ansOcc) {
                        if (valAndOcc[j][0] > ans) {
                            ans = valAndOcc[j][0];
                            ansOcc = valAndOcc[j][1];
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    private void buildStrings(int startI, int startJ) {
        String trivialString = String.valueOf(mat[startI][startJ]);
        occMap.put(trivialString, occMap.getOrDefault(trivialString, 0) + 1);

        for (int[] dir : EIGHT_DIRS) {
            int[] currCoord = new int[] {startI, startJ};
            StringBuilder sb = new StringBuilder();
            sb.append(mat[startI][startJ]);
            while (true) {
                currCoord[0] += dir[0];
                currCoord[1] += dir[1];
                if (isValidCoordinate(currCoord[0], currCoord[1])) {
                    sb.append(mat[currCoord[0]][currCoord[1]]);
                    String currString = sb.toString();
                    occMap.put(currString, occMap.getOrDefault(currString, 0) + 1);
                } else {
                    break;
                }
            }
        }
    }

    private boolean isValidCoordinate(int i, int j) {
        return i < m && i >= 0 && j >= 0 && j < n;
    }

    private boolean isPrime(int e) {
        if (e == 0 || e == 1) {
            return false;
        }

        for(int i=2;i<=e/2;i++) {
            int temp=e % i;
            if(temp==0) {
                return false;
            }
        }
        return true;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.mostFrequentPrime(
                new int[][]{{1,1},{9,9},{1,1}}
        ); // 19
        sol.mostFrequentPrime(
                new int[][]{{7}}
        ); // -1
        sol.mostFrequentPrime(
                new int[][]{{9,7,8},{4,6,5},{2,8,6}}
        ); // 97




    }
}
