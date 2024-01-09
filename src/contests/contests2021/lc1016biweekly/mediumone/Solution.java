package contests.contests2021.lc1016biweekly.mediumone;

// Accepted after 11 minutes
// Pretty easy medium

class Solution {
    public boolean winnerOfGame(String colors) {

        String[] aSubStrings = colors.split("B");
        String[] bSubStrings = colors.split("A");

//        System.out.println(Arrays.toString(aSubStrings));
//        System.out.println(Arrays.toString(bSubStrings));

        int numOfAMoves = 0;
        for (String aSub : aSubStrings) {
            int aSubLen = aSub.length();
            if (aSubLen > 2) {
                numOfAMoves += aSubLen - 2;
            }
        }

        int numOfBMoves = 0;
        for (String bSub : bSubStrings) {
            int aSubLen = bSub.length();
            if (aSubLen > 2) {
                numOfBMoves += aSubLen - 2;
            }
        }

//        System.out.println("Alice has numOfMoves = " + numOfAMoves);
//        System.out.println("Bob has numOfMoves = " + numOfBMoves);

        if (numOfAMoves == 0) {
            System.out.println("No moves for Alice at the beginning");
            return false;
        } else if (numOfBMoves == 0) {
            System.out.println("No moves for Bob at the beginning");
            return true;
        } else {
            // Both numOfAMoves and numOfBMoves are greater than 0
            if (numOfAMoves <= numOfBMoves) {
                System.out.println("Bob wins");
                return false;
            } else {
                System.out.println("Alice wins");
                return true;
            }
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.winnerOfGame("AAABABB");
        sol.winnerOfGame("AA");
        sol.winnerOfGame("ABBBBBBBAAA");
    }
}