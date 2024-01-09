package contests.contests2023.lc0429.mediumone;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

// Accepted after 12 minutes
// Cool problem. I wonder how efficient my solution is

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int[] maxRow = new int[mat.length];
        int[] maxColumn = new int[mat[0].length];

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = indexMap.get(mat[i][j]);
                maxRow[i] = Math.max(maxRow[i], mat[i][j]);
                maxColumn[j] = Math.max(maxColumn[j], mat[i][j]);
            }
        }

        int smallestRow = IntStream.of(maxRow).min().getAsInt();
        int smallestColumn = IntStream.of(maxColumn).min().getAsInt();

        int ans = Math.min(smallestRow, smallestColumn);
        System.out.println("ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.firstCompleteIndex(
                new int[]{1,3,4,2},
                new int[][]{{1,4},{2,3}}
        );
        sol.firstCompleteIndex(
                new int[]{2,8,7,4,1,3,5,6,9},
                new int[][]{{3,2,5},{1,4,6},{8,7,9}}
        );
    }
}