package contests.contests2023.lc0708biweekly.mediumone;

import java.util.*;
import java.util.stream.Collectors;

// Accepted first attempt
// Server was down for the first 28 minutes of the competition. Sigh. not going to count

class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {

        Set<Integer> positionSet = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for (int initPosition : nums) {
            positionSet.add(initPosition);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            int fromPos = moveFrom[i];
            int toPos = moveTo[i];
            if (positionSet.contains(fromPos)) {
                positionSet.remove(fromPos);
                positionSet.add(toPos);
            }
        }

        List<Integer> ans = new ArrayList<>(positionSet);
        Collections.sort(ans);
//        System.out.println("ans = " + positionSet);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.relocateMarbles(
                new int[]{1,6,7,8},
                new int[]{1,7,2},
                new int[]{2,9,5}
        );

        sol.relocateMarbles(
                new int[]{1,1,3,3},
                new int[]{1,3},
                new int[]{2,2}
        );
    }
}
