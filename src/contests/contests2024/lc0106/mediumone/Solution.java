package contests.contests2024.lc0106.mediumone;



// Accepted after 21 minutes
// Accepted after 2 attempts. First attempt wrong answer.
// Nightmare handling edge cases. This was a tidious . I finished at pos 615 out of 6000 submissions

class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int[] rookPos = {a,b};
        int[] bishopPos = {c,d};
        int[] queenPos = {e,f};
        int rookDiag = rookPos[0] - rookPos[1];
        int queenDiag = queenPos[0] - queenPos[1];
        int bishopDiag = bishopPos[0] - bishopPos[1];

        int rookAntiDiag = rookPos[0] + rookPos[1];
        int queenAntiDiag = queenPos[0] + queenPos[1];
        int bishopAntiDiag = bishopPos[0] + bishopPos[1];

        if (queenDiag == bishopDiag) {
            if (rookDiag != bishopDiag) {  // rook is not in the wey
                return 1;
            } else { // rook is in the same diagonal
                if (bishopPos[0] < rookPos[0] && rookPos[0] < queenPos[0]) { // Rook is in the way (B..R..Q)
                    return 2;
                } else if (queenPos[0] < rookPos[0] && rookPos[0] < bishopPos[0]) { // Rook is in the way (Q..R..B)
                    return 2;
                } else { // rook is not in the way
                    return 1;
                }
            }
        } else if (queenAntiDiag == bishopAntiDiag) {
            if (rookAntiDiag != bishopAntiDiag) {  // rook is not in the wey
                return 1;
            } else { // rook is in the way
                if (bishopPos[0] < rookPos[0] && rookPos[0] < queenPos[0]) { // B..R..Q
                    return 2;
                } else if (queenPos[0] < rookPos[0] && rookPos[0] < bishopPos[0]) { // Q..R..B
                    return 2;
                } else { // rook is not in the way
                    return 1;
                }
            }
        } else if (rookPos[0] == queenPos[0]) {
            if (bishopPos[0] != rookPos[0]) { // bishop is not in the way
                return 1;
            } else { // bishop is in the way
                if (rookPos[1] < bishopPos[1] && bishopPos[1] < queenPos[1]) { // R..B..Q
                    return 2;
                } else if (queenPos[1] < bishopPos[1] && bishopPos[1] < rookPos[1]) { // Q..B..R
                    return 2;
                } else { // bishop is in the same row, but not between the Queen and Rook
                    return 1;
                }
            }
        } else if (rookPos[1] == queenPos[1]) {
            if (bishopPos[1] != rookPos[1]) { // bishop is not in the way
                return 1;
            } else { // bishop is in the way
                if (rookPos[0] < bishopPos[0] && bishopPos[0] < queenPos[0]) { // R..B..Q
                    return 2;
                } else if (queenPos[0] < bishopPos[0] && bishopPos[0] < rookPos[0]) { // Q..B..R
                    return 2;
                } else { // bishop is in the same row, but not between the Queen and Rook
                    return 1;
                }
            }
        } else {
            // The Queen is not in the same diagonal or antiDiagonal as the Bishop
            // The Queen is not in the same row(rank) or column(file) as the Rook
            return 2; // the rook is guaranteed to have a two-move pair to attack the queen, regardless of the bishop position
        }
    }
}







class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minMovesToCaptureTheQueen(1, 1, 8, 8, 2, 3)); // 2
        System.out.println(sol.minMovesToCaptureTheQueen(5, 3, 3, 4, 5, 2)); // 1
        System.out.println(sol.minMovesToCaptureTheQueen(1,1,1,4,1,8)); // 2



    }
}
