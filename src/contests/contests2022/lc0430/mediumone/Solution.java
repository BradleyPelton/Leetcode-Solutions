package contests.contests2022.lc0430.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 14 minutes
// Cool problem. Thought for 5 minutes, then came with a super simple solution

class Solution {
    public int minimumCardPickup(int[] cards) {

        Map<Integer, Integer> lastOccMap = new HashMap<>();


        int leastDistance = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int val = cards[i];

            if (lastOccMap.containsKey(val)) {
                int lastOccVal = lastOccMap.get(val);
                int diff = i - lastOccVal;
                if (diff < leastDistance) {
                    leastDistance = diff;
                }
            }
            lastOccMap.put(val, i);
        }


        int ans;
        if (leastDistance == Integer.MAX_VALUE) {
            ans = -1;
        } else {
            ans = leastDistance + 1;
        }

        System.out.println("final ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minimumCardPickup(new int[]{3,4,2,3,4,7});
        sol.minimumCardPickup(new int[]{1,0,5,3});
    }
}