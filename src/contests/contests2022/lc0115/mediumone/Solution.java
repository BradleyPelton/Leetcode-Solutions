package contests.contests2022.lc0115.mediumone;


// Accepted after 18 minutes (6:49 pm)
// Shorter question than the easy
// Trivial


class Solution {
    public int minMoves(int target, int maxDoubles) {

        int numOfMoves = 0;

//        System.out.println("original target = " + target);
//        if (target % 2 == 1) {
//            numOfMoves++;
//            target--;
////            System.out.println("target = " + target);
//        }

        while (target > 1 && maxDoubles > 0) {
            if (target % 2 == 1) {
                numOfMoves++;
                target--;
//                System.out.println("target = " + target);
            } else {
                target /= 2;
                numOfMoves++;
                maxDoubles--;
//                System.out.println("target = " + target);
            }
        }

        if (target > 1) {
            numOfMoves += target - 1;
        }

        System.out.println("ans = " + numOfMoves);
        return numOfMoves;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minMoves(5, 0);
        sol.minMoves(19, 2);
        sol.minMoves(10, 4);
    }
}