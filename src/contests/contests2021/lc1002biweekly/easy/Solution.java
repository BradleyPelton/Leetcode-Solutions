package contests.contests2021.lc1002biweekly.easy;

// Accepted after 6 minutes
// Cool problem for an easy

// My solution is sloppy. I handled the same edge case probably 3 different ways. Better safe than sorry

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {

        int[][] ans = new int[m][n];

        if (original.length != m * n) {
            System.out.println("size mismatch");
            return new int[][]{};
        }

        int currIndex = 0;
        try {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[i][j] = original[currIndex];
                    currIndex++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array index error");
            return new int[][]{};
        }

        if (currIndex < original.length - 1) {
            System.out.println("Array size didnt match");
            return new int[][]{};
        }

//        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.construct2DArray(new int[]{1,2,3,4}, 2, 2);
        sol.construct2DArray(new int[]{1,2,3}, 1, 3);
        sol.construct2DArray(new int[]{1,2}, 1, 1);
        sol.construct2DArray(new int[]{3}, 1, 2);


    }
}