package contests.contests2024.lc0720biweekly.easy;

// Accepted first attempt
// Accepted after 2 minutes
// Trivial

class Solution {
    public String losingPlayer(int x, int y) {

        boolean isAliceTurn = true;

        while (true) {
            if (x < 1 || y < 4) {
                break;
            }
            x -= 1;
            y -= 4;
            isAliceTurn = !isAliceTurn;
        }

        String ans = "no";
        if (isAliceTurn) {
            ans = "Bob";
        } else {
            ans = "Alice";
        }
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.losingPlayer(
                2,
                7
        );
        sol.losingPlayer(
                4,
                11
        );


    }
}