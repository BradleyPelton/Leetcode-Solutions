package contests.contests2023.lc0429.easy;


// Accepted after 15 minutes
// Two wrong answer
// Totally misread the problem  twice. Need to slow down

class Solution {
    public int isWinner(int[] player1, int[] player2) {

        int player1Score = 0;
        int player2Score = 0;


        for (int i = 0; i < player1.length; i++) {
            if (i == 0) {
                player1Score += player1[i];
                player2Score += player2[i];
            } else if (i == 1) {
                if (player1[i - 1] == 10) {
                    player1Score += 2 * player1[i];
                } else {
                    player1Score += player1[i];
                }

                if (player2[i - 1] == 10) {
                    player2Score += 2 * player2[i];
                } else {
                    player2Score += player2[i];
                }
            } else {
                if (player1[i - 2] == 10 || player1[i - 1] == 10) {
                    player1Score += 2 * player1[i];
                } else {
                    player1Score += player1[i];
                }

                if (player2[i - 2] == 10 || player2[i - 1] == 10) {
                    player2Score += 2 * player2[i];
                } else {
                    player2Score += player2[i];
                }
            }
        }

        int ans;
        if (player1Score > player2Score) {
            ans = 1;
        } else if (player1Score < player2Score) {
            ans = 2;
        } else {
            ans = 0;
        }
        System.out.println("ans = " + ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isWinner(
                new int[]{4,10,7,9},
                new int[]{6,5,2,3}
        );
        sol.isWinner(
                new int[]{3,5,7,6},
                new int[]{8,10,10,2}
        );
        sol.isWinner(
                new int[]{2,3},
                new int[]{4,1}
        );
        sol.isWinner(
                new int[]{10,2,2,3},
                new int[]{3,8,4,5}
        ); // expected 1
        sol.isWinner(
                new int[]{9, 7, 10, 7},
                new int[]{10, 2, 4, 10}
        ); // expected 1
    }
}