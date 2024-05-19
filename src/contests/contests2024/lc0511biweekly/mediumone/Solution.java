package contests.contests2024.lc0511biweekly.mediumone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Accepted after 21 minutes
// Tricky medium Problem. accepted after second attempt
// Probably overcomplicated it by using a priority queue
// Only 1100 people finished before me. Tricky medium apparently

class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        Map<Integer, ArrayList<Character>> distanceMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int distance = Math.max(Math.abs(point[0]), Math.abs(point[1]));
            if (!distanceMap.containsKey(distance)) {
                distanceMap.put(distance, new ArrayList<>());
            }
            distanceMap.get(distance).add(s.charAt(i));
        }


        int ans = 0;
        Set<Character> seenChars = new HashSet<>();

        List<Integer> uniqueDistances = new ArrayList<>(distanceMap.keySet());
        Collections.sort(uniqueDistances); // O(n log n)
        OUTER_LOOP:
        for (int distance : uniqueDistances) {
            List<Character> charsForThisDistance = distanceMap.get(distance);
            for (char c : charsForThisDistance) {
                if (!seenChars.add(c)) {
                    break OUTER_LOOP;
                }
            }
            ans += charsForThisDistance.size();
        }

        //System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxPointsInsideSquare(
                new int[][]{{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}},
                "abdca"
        ); // 2
        sol.maxPointsInsideSquare(
                new int[][]{{1,1},{-2,-2},{-2,2}},
                "abb"
        ); // 1
        sol.maxPointsInsideSquare(
                new int[][]{{1,1},{-1,-1},{2,-2}},
                "ccd"
        ); // 0
        sol.maxPointsInsideSquare(
                new int[][]{{1,-1}},
                "a"
        ); // 1






    }
}
