package contests.contests2024.lc0504.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 6 minutes
// Accepted first try

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        
        Map<String, Integer> occMap = new HashMap<>();

        int n = word.length();
        for (int i = 0; i < n; i++) {
            String subString = word.substring(k* i, k * (i + 1));
            occMap.put(subString, occMap.getOrDefault(subString, 0) + 1);

            if (k * (i + 1) == n) {
                break;
            }
        }


        int ans = Integer.MAX_VALUE;
        int numberOfPeriods = n / k;
        for (String key : occMap.keySet()) {
            ans = Math.min(ans, numberOfPeriods - occMap.get(key));
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumOperationsToMakeKPeriodic(
                "leetcodeleet"
                , 4
        );
        sol.minimumOperationsToMakeKPeriodic(
                "leetcoleet"
                , 2
        );



    }
}
