package contests.contests2023.lc0422.easy;


// Trivial beyond all trivial
// Accepted after 2 minutes


class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {

        int ans = (arrivalTime + delayedTime) % 24;
        System.out.println("ans = " + ans);
        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findDelayedArrivalTime(15,5);
        sol.findDelayedArrivalTime(13,11);
    }
}
