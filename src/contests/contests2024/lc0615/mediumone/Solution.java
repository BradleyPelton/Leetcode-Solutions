package contests.contests2024.lc0615.mediumone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 8 minutes
// Cool hashmap problem
// Accepted first attempt

class Solution {
    public long countCompleteDayPairs(int[] hours) {

        Map<Integer, Integer> occMap = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < hours.length; i++) {
            int modifiedHours = hours[i] % 24;

            int complement = (24 - modifiedHours) % 24;
            if (occMap.containsKey(complement)) {
                int complementOcc = occMap.get(complement);
                ans += complementOcc;
            }

            occMap.put(modifiedHours, occMap.getOrDefault(modifiedHours, 0) + 1);

        }

        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countCompleteDayPairs(
                new int[]{12,12,30,24,24}
        );
        sol.countCompleteDayPairs(
                new int[]{72,48,24,3}
        );




    }
}
