package contests.contests2024.lc0727.easy;


// Accepted asfter 2 minutes
// Trivial

class Solution {
    public boolean canAliceWin(int[] nums) {

        int singleDigitSUm = 0;
        int doubleDigitSUm = 0;

        for (int val : nums) {
            if (val >= 0 && val <= 9) {
                singleDigitSUm += val;
            } else {
                doubleDigitSUm += val;
            }
        }

        if (singleDigitSUm != doubleDigitSUm) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canAliceWin(
                new int[]{1,2,3,4,10}
        );
        sol.canAliceWin(
                new int[]{1,2,3,4,5,14}
        );
        sol.canAliceWin(
                new int[]{5,5,5,25}
        );




    }
}
