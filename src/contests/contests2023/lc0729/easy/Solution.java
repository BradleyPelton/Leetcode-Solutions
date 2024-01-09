package contests.contests2023.lc0729.easy;

// Accepted after 2 minutes
// Possibly the easiet easy ever

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        int totalEmployees = 0;

        for (int hour : hours) {
            if (hour >= target) {
                totalEmployees++;
            }
        }

        System.out.println("ans = " + totalEmployees);
        return totalEmployees;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfEmployeesWhoMetTarget(
                new int[]{0,1,2,3,4},
                2
        );
        sol.numberOfEmployeesWhoMetTarget(
                new int[]{5,1,4,2,2},
                6
        );





    }
}
