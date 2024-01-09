package contests.contests2021.lc1002.easy;

// accepted after 7 minutes
// accepted after second attempt. Forget to fix return

class Solution {
    public int minimumMoves(String s) {

        char[] charArr = s.toCharArray();

        char[] copyArr = charArr.clone();

        int numSwaps = 0;
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] == 'X' && copyArr[i] != 'O') {
                try {
                    numSwaps++;
                    copyArr[i] = 'O';
                    copyArr[i + 1] = 'O';
                    copyArr[i + 2] = 'O';
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        System.out.println("final ans = " + numSwaps);
        return numSwaps;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumMoves("XXX");
        sol.minimumMoves("XXOX");
        sol.minimumMoves("OOOO");
    }
}