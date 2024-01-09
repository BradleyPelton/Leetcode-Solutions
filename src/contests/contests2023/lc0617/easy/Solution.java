package contests.contests2023.lc0617.easy;


// Accepted after 3 minutes
// Trivial

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {

        int distance = 0;
        while (mainTank > 0) {
            if (mainTank >= 5) {
                mainTank -= 5;
                distance += 50;

                if (additionalTank > 0) {
                    additionalTank--;
                    mainTank++;
                }
            } else {
                distance += (mainTank * 10);
                mainTank = 0;
                break;
            }
        }

        System.out.println("ans = " + distance);
        return distance;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.distanceTraveled(5,10);
        sol.distanceTraveled(1,2);


    }
}
