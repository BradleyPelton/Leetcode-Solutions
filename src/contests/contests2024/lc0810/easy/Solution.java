package contests.contests2024.lc0810.easy;

import java.util.List;

// Accepted after 5 minutes
// WRong answer twice. Mispelled string.... sigh


class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {

        int currI = 0;
        int currJ = 0;
        for (String command : commands) {
            if (command.equals("RIGHT")) {
                currJ++;
            } else if (command.equals("LEFT")) {
                currJ--;
            } else if (command.equals("UP")) {
                currI--;
            } else { // DOWN
                currI++;
            }
        }

        int ans = (currI * n)  + currJ;
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.finalPositionOfSnake(
                2,
                List.of("RIGHT","DOWN")
        );
        sol.finalPositionOfSnake(
                3,
                List.of("DOWN","RIGHT","UP")
        );
        sol.finalPositionOfSnake(
                2,
                List.of("RIGHT","LEFT")
        ); // 0



    }
}