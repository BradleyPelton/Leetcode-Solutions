package contests.contests2023.lc1225.mediumone;

// Accepeted after 24 minutes
// Easy problem that I fumbled around with coordinates for 30 minutes
// I need to learn to use the Point class

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {

        int currXCoord = startPos[1];
        int currYCoord = startPos[0];

        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String instructions = s.substring(i);
            int numberOfSteps = 0;

            for(char c : instructions.toCharArray()) {
                if (c == 'L') {
                    if (currXCoord <= 0) {
                        break;
                    } else {
                        currXCoord -= 1;
                        numberOfSteps++;
                    }
                } else if (c == 'R') {
                    if (currXCoord >= n - 1) {
                        break;
                    } else {
                        currXCoord += 1;
                        numberOfSteps++;
                    }
                } else if (c == 'U') {
                    if (currYCoord <= 0) {
                        break;
                    } else {
                        currYCoord -= 1;
                        numberOfSteps++;
                    }

                } else if (c == 'D') {
                    if (currYCoord >= n - 1) {
                        break;
                    } else {
                        currYCoord += 1;
                        numberOfSteps++;
                    }
                }
            }

            ans[i] = numberOfSteps;
            currXCoord = startPos[1];
            currYCoord = startPos[0];

        }

//        System.out.println(Arrays.toString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.executeInstructions(
                3,
                new int[]{0,1},
                "RRDDLU"
        );

        sol.executeInstructions(
                2,
                new int[]{1,1},
                "LURD"
        );

        sol.executeInstructions(
                1,
                new int[]{0,0},
                "LRUD"
        );
    }
}