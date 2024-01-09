package contests.contests2024.lc0106biweekly.mediumtwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// BFS ACCEPTED FIRST TRY
// WOWOWOWOWOWOWO. PROGRESSSSSS
// I wonder why DP didnt work. Stackoverflow constantly. Debug later. Going to hard.

class Solution {
    Map<Integer, Integer> dp;
    Set<Integer> seen;
    int GLOBAL_MAX;
    public int minimumOperationsToMakeEqual(int x, int y) {
        GLOBAL_MAX = Math.max(x, y) + 60;
        dp = new HashMap<>();
        seen = new HashSet<>();

        int ans = minOps(x, y);
        System.out.println(ans);
        return ans;
    }

    private int minOps(int currVal, int target) {
        // Theory : DP doesnt work because a method will never be removed off the stack until all vals are checked between [0..max]
        // Average call stack max size is 9000 method calls. Input size is 10_000
        // This shouldn't prohibit me from solving (26,2) or (54,2) locally though

        // There seems to be a direct contradiction with DP and using a seen array. One wants to reuse cached values. One wants to prohibit


        // I couldn't make DP work after 1 hour. DP + seen is a novelty. I'm trying to keep two different caches
        // 1 cache for calculated values (DP)
        // 1 cache for values on the stack (seen)

        if (currVal == target) {
            return 0;
        }
        if (currVal > GLOBAL_MAX || currVal < target) {
            return Integer.MAX_VALUE;
        }

        if (dp.containsKey(currVal)) { // SEEN CACHED
            return dp.get(currVal);
        }
        if (seen.contains(currVal)) { // SEEN AND NOT CACHED
            return Integer.MAX_VALUE;
        }
        seen.add(currVal);

        int divideByEleven = Integer.MAX_VALUE;
        if (currVal % 11 == 0) {
            divideByEleven = minOps(currVal / 11, target);
        }

        int divideByFive = Integer.MAX_VALUE;
        if (currVal % 5 == 0) {
            divideByFive = minOps(currVal / 5, target);
        }

        int inc = Integer.MAX_VALUE;
        if (!seen.contains(currVal + 1)) {
            inc = minOps(currVal + 1, target);
        }

        int dec = Integer.MAX_VALUE;
        if (!seen.contains(currVal - 1)) {
            dec = minOps(currVal - 1, target);
        }


        int ans = Math.min(inc, Math.min(dec, Math.min(divideByEleven, divideByFive)));
        if (ans != Integer.MAX_VALUE) {
            ans++;
        }

        dp.put(currVal, ans);
        return ans;
    }

//    public int minimumOperationsToMakeEqual(int x, int y) { // BFS ACCEPTED. Returning to DP for edification
//        if (x == y) {
//            System.out.println("0, trivial same");
//            return 0;
//        }
//        seen = new HashSet<>();
//
//        // BFS LONGSHOT
//
//        Queue<Integer> nodesToSearch = new ArrayDeque<>();
//        nodesToSearch.add(x);
//
//        int numberOfOps = 0;
//        OUTER_LOOP:
//        while (!nodesToSearch.isEmpty()) {
//            numberOfOps++;
//            int size = nodesToSearch.size();
//            for (int i = 0; i < size; i++) {
//                int val = nodesToSearch.remove();
//
//                if (val + 1 == y) {
//                    break OUTER_LOOP;
//                }
//                if (!seen.contains(val + 1)) {
//                    seen.add(val + 1);
//                    nodesToSearch.add(val + 1);
//                }
//
//                if (val - 1 == y) {
//                    break OUTER_LOOP;
//                }
//                if (!seen.contains(val - 1)) {
//                    seen.add(val - 1);
//                    nodesToSearch.add(val - 1);
//                }
//
//                if (val % 5 == 0) {
//                    if (val / 5 == y) {
//                        break OUTER_LOOP;
//                    }
//                    if (!seen.contains(val / 5)) {
//                        seen.add(val / 5);
//                        nodesToSearch.add(val / 5);
//                    }
//                }
//
//                if (val % 11 == 0) {
//                    if (val / 11 == y) {
//                        break OUTER_LOOP;
//                    }
//                    if (!seen.contains(val / 11)) {
//                        seen.add(val / 11);
//                        nodesToSearch.add(val / 11);
//                    }
//                }
//
//            }
//        }
//
//        System.out.println(numberOfOps);
//        return numberOfOps;
//    }
}







class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumOperationsToMakeEqual(26, 1);
        sol.minimumOperationsToMakeEqual(54, 2);
        sol.minimumOperationsToMakeEqual(25, 30);






    }
}
