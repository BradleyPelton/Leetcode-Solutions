package contests.contests2022.lc0319biweekly.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

// Accepted after 5 minutes
// Trivial

class Solution {
    public boolean divideArray(int[] nums) {

        Map<Integer, Integer> occMap  = Arrays.stream(nums).boxed().collect(
                Collectors.groupingBy(
                        x -> x,
                        Collectors.summingInt(x -> 1)
                )
        );

        for (int e : occMap.keySet()) {
            int occ = occMap.get(e);
            if (occ % 2 == 1) {
                System.out.println("found a problem with e = " + e);
                return false;
            }
        }
        System.out.println("returning true");
        return true;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();

        sol.divideArray(new int[]{3,2,3,2,2,2});
        sol.divideArray(new int[]{1,2,3,4});

    }
}