package contests.contests2022.lc1126biweekly.mediumone;

import java.util.Arrays;

// Accepted after second attempt
// Forgot to sort first time
// accepted after 20 minutes
// Cool problem. Took 5 minutes debugging a misunderstanding in the question

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

//        List<Integer> hBarsRemaining = Arrays.stream(hBars).boxed().collect(Collectors.toList());
//        List<Integer> vBarsRemaining = Arrays.stream(vBars).boxed().collect(Collectors.toList());

        int maxArea = 1;
        for (int i = 0; i < hBars.length; i++) {
            // current column plus removed column
            int height = 2;
            while (i < hBars.length - 1 && hBars[i + 1] == hBars[i] + 1) {
                height++;
                i++;
            }

            for (int j = 0; j < vBars.length; j++) {
                int width = 2;

                while (j < vBars.length - 1 && vBars[j + 1] == vBars[j] + 1) {
                    width++;
                    j++;
                }

                int minSideLength = Math.min(height, width);
                int area = minSideLength * minSideLength;
                maxArea = Math.max(maxArea, area);
            }
        }
        System.out.println(maxArea);
        return maxArea;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximizeSquareHoleArea(
                2,
                1,
                new int[]{2,3},
                new int[]{2}
        );
        sol.maximizeSquareHoleArea(
                1,
                1,
                new int[]{2},
                new int[]{2}
        );
        sol.maximizeSquareHoleArea(
                2,
                3,
                new int[]{2,3},
                new int[]{2,3,4}
        );
        sol.maximizeSquareHoleArea(
                3,
                2,
                new int[]{3,2,4},
                new int[]{3,2}
        );  // 9


    }
}
