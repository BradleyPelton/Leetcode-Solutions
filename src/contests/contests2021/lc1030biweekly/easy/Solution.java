package contests.contests2021.lc1030biweekly.easy;

import java.util.HashMap;
import java.util.Map;

// Accepted after 4 minutes
// Trivial

class Solution {
    public String kthDistinct(String[] arr, int k) {

        Map<String, Integer> occMap = new HashMap<>();

        for (String s : arr) {
            if (occMap.containsKey(s)) {
                int currVal = occMap.get(s);
                occMap.put(s, currVal+1);
            } else {
                occMap.put(s, 1);
            }
        }

        String ans = "";
        int numOfDistinctStringsSoFar = 0;
        for (String s : arr) {
            int occCount = occMap.get(s);
            if (occCount == 1) {
                numOfDistinctStringsSoFar++;
            }

            if (numOfDistinctStringsSoFar == k) {
                ans = s;
                break;
            }
        }

        System.out.println("final ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.kthDistinct(new String[]{"d","b","c","b","c","a"}, 2);
        sol.kthDistinct(new String[]{"aaa","aa","a"}, 1);
        sol.kthDistinct(new String[]{"a","b","a"}, 3);



    }
}
