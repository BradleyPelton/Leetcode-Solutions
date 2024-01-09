package contests.contests2023.lc0304.easy;

// Accepted after 7 minutes
// trivial. Should be a much cleaner solution that exists though

class Solution {
    public int passThePillow(int n, int time) {

        time %= (n - 1)*2; // round trip;

        int currPos = 1;
        if (time > n - 1) {
            currPos = n;
            time -= n - 1;

            currPos = n - time;
        } else { // else time < n
            currPos += time;
        }

        System.out.println("ans = " + currPos);
        return currPos;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.passThePillow(4, 5);
        sol.passThePillow(3, 2);
    }
}
