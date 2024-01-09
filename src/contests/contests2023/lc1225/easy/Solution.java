package contests.contests2023.lc1225.easy;

// Accepted after 4 minutes, trivial

class Solution {
    public boolean isSameAfterReversals(int num) {

        String numAsString = String.valueOf(num);
        String reversed1 = new StringBuilder(numAsString).reverse().toString();

        int r1Int = Integer.valueOf(reversed1);

        String reversed2 = new StringBuilder(String.valueOf(r1Int)).reverse().toString();
        int r2Int = Integer.valueOf(reversed2);

        boolean ans = r2Int == num;
        System.out.println("ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.isSameAfterReversals(526);
        sol.isSameAfterReversals(1800);
        sol.isSameAfterReversals(0);
    }
}

