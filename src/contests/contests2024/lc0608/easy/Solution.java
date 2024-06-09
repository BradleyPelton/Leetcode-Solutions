package contests.contests2024.lc0608.easy;

// Accepted first attempt
// Accepted after 3 minutes. Trivial.
// brute forced instead of handling indices

class Solution {
    public int numberOfChild(int n, int k) {


        int currPos = 1;
        boolean isForward = true;
        for (int i = 1; i < k; i++) {


            if (currPos == n - 1) {
                isForward = false;
            } else if (currPos == 0) {
                isForward = true;
            }

            if (isForward) {
                currPos++;
            } else {
                currPos--;
            }
        }

        System.out.println(currPos);
        return currPos;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfChild(
                3,
                5
        );
        sol.numberOfChild(
                5,
                6
        );
        sol.numberOfChild(
                4,
                2
        );





    }
}
