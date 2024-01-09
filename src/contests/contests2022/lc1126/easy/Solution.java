package contests.contests2022.lc1126.easy;

// Acceoted after 10 minutes
// Fumbeld with indices. implemented a hack fbecause f mod problems

class Solution {
    public boolean areSimilar(int[][] mat, int k) {

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int rowLength = row.length;
            if (i % 2 == 0) {
                for (int j = 0; j < row.length; j++) {
                    int shiftedIndex = (j - k + rowLength * 1000) % rowLength;
                    if (row[j] != row[shiftedIndex]) {
                        return false;
                    }
                }
            } else {
                for (int j = 0; j < row.length; j++) {
                    int shiftedIndex = (j + k + rowLength * 1000) % rowLength;
                    if (row[j] != row[shiftedIndex]) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 2));
        System.out.println(sol.areSimilar(new int[][]{{2,2},{2,2}}, 3));
        System.out.println(sol.areSimilar(new int[][]{{1,2}}, 1));




    }
}
