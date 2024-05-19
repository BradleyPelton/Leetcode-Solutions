package contests.contests2024.lc0518.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int waysToReachStair(int k) {


        int ans = 0;  // trivial, start at k + 1


        List<int[]> positions = new ArrayList<>();

        // WAYS TO GET TO k + 1
        for (int i = 0; i < 64; i++) {
            int pos = (k + 1) - (int) Math.pow(2, i);

            if (pos < 0) {
                break;
            }
            positions.add(new int[]{pos, i, 0}); // poss, last jump val, 1==last step was a step down
        }

        // WAYS TO GET TO k
        for (int i = 0; i < 64; i++) {
            int pos = k - (int) Math.pow(2, i);

            if (pos < 0) {
                break;
            }
            positions.add(new int[]{pos, i, 0}); // poss, last jump power, 1==last step was a step down
        }


        while (!positions.isEmpty()) {
            List<int[]> nextPositions = new ArrayList<>();

            for (int[] posArr : positions) {
                if (posArr[0] == k) {
                    ans++;
                } else if (posArr[0] == k + 1 && posArr[2] == 0) {
                    ans++;
                } else {
                    if (posArr[0] > k) {
                        continue;
                    } else if (posArr[1] == 0) {
                        continue;
                    } else {
                        if (posArr[2] == 0) {
                            nextPositions.add(new int[]{});
                        }


                        posArr[0] -= (int) Math.pow(2, posArr[1]);
                        posArr[1]--;
                        nextPositions.add(posArr);
                    }
                }
            }

            positions = nextPositions;
        }

        System.out.println(ans);
        return ans;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.waysToReachStair(0);
//        sol.waysToReachStair(1);


        sol.waysToReachStair(124);

    }
}
