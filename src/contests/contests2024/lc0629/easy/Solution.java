package contests.contests2024.lc0629.easy;

// Accepted after 6 minutes
// First answer wrong answer. Used wrong variable
// Weird new format
// relatively hard easy.

class Solution {
    public int maxHeightOfTriangle(int red, int blue) {

        int redCopy = red;
        int blueCopy = blue;

        //START WITH BLUE
        int numberOfRowsStartingWithBlue = 0;
        boolean isBlueTurn = true;
        while (true) {
            if (isBlueTurn) {
                if (blue > numberOfRowsStartingWithBlue) {
                    numberOfRowsStartingWithBlue++;
                    blue -= numberOfRowsStartingWithBlue;
                } else {
                    break;
                }
            } else {
                if (red > numberOfRowsStartingWithBlue) {
                    numberOfRowsStartingWithBlue++;
                    red -= numberOfRowsStartingWithBlue;
                } else {
                    break;
                }
            }

            isBlueTurn = !isBlueTurn;
        }

        //START WITH RED
        red = redCopy;
        blue = blueCopy;
        int numberOfRowsStartingWithRed = 0;
        isBlueTurn = false;
        while (true) {
            if (isBlueTurn) {
                if (blue > numberOfRowsStartingWithRed) {
                    numberOfRowsStartingWithRed++;
                    blue -= numberOfRowsStartingWithRed;
                } else {
                    break;
                }
            } else {
                if (red > numberOfRowsStartingWithRed) {
                    numberOfRowsStartingWithRed++;
                    red -= numberOfRowsStartingWithRed;
                } else {
                    break;
                }
            }

            isBlueTurn = !isBlueTurn;
        }

        int ans = Math.max(numberOfRowsStartingWithBlue, numberOfRowsStartingWithRed);
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxHeightOfTriangle(
                2,
                4
        );
        sol.maxHeightOfTriangle(
                2,
                1
        );
        sol.maxHeightOfTriangle(
                1,
                1
        );
        sol.maxHeightOfTriangle(
                10,
                1
        );


        sol.maxHeightOfTriangle(
                10,
                10
        ); // expected 5





    }
}
