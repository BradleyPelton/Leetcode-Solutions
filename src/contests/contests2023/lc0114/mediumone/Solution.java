package contests.contests2023.lc0114.mediumone;

// trivial 8 minutes
// just remembering columns/rows

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] numberArray = new int[n][n];

        for(int[] query : queries) {
            //query[i] = [row1i, col1i, row2i, col2i]

            int firstRow = query[0];
            int lastRow = query[2];
            int firstColumn = query[1];
            int lastColumn = query[3];

            for (int i = firstRow ; i < lastRow + 1 ; i++) {
                for (int j = firstColumn; j < lastColumn + 1; j++) {
                    numberArray[i][j]++;
                }
            }
        }

//        System.out.println(Arrays.deepToString(numberArray));
        return numberArray;

    }
}

class Tests {
    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.rangeAddQueries(3,
                new int[][]{{1,1,2,2},{0,0,1,1}});
        sol.rangeAddQueries(2,
                new int[][]{{0,0,1,1}});
    }
}