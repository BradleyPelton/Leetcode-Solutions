package contests.contests2024.lc0106.easy;


// Accepted after 4 minutes
// Trivial

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxAreaOfDiag = 0; // area is always an integer due to the closure of Z+
        for (int[] dim : dimensions) {
            double diag = Math.hypot(dim[0], dim[1]);
            int area = dim[0] * dim[1];
            if (diag == maxDiagonal) {
                if (area > maxAreaOfDiag) {
                    maxAreaOfDiag = area;
                    maxDiagonal = diag;
                }
            } else if (diag > maxDiagonal) {
                maxAreaOfDiag = area;
                maxDiagonal = diag;
            }
        }
        System.out.println(maxAreaOfDiag);
        return maxAreaOfDiag;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.areaOfMaxDiagonal(new int[][]{{9,3},{8,6}});
        sol.areaOfMaxDiagonal(new int[][]{{3,4},{4,3}});




    }
}
