package contests.contests2023.lc0708.easy;

// Accepted first attempt
// Accepted after 3 minutes
// Easiest problem I think I have ever seen.

class Solution {
    public int theMaximumAchievableX(int num, int t) {

        int ans = num + 2 * t;
        System.out.println("ans = " + ans);
        return ans;



    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.theMaximumAchievableX(4, 1);
        sol.theMaximumAchievableX(3, 2);






    }
}
