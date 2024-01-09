package contests.contests2023.lc0318biweekly.mediumtwo;

import java.util.*;
import java.util.stream.Collectors;

// Pretty simple problem.
// Solved after 14 minutes

// Accepted after second attempt. Fumbled with comparator values

// Trifecta: easy + mediumOne + mediumTwo

class Solution {
    public long findScore(int[] nums) {

        List<Integer> remainingNums = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Map<Integer, Boolean> indexIsMarked = new HashMap<>();
        Queue<int[]> nextSmallest = new PriorityQueue<>((a,b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                if (a[1] > b[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < nums.length; i++) {
            int[] temp = {nums[i], i};
            nextSmallest.add(temp);
            indexIsMarked.put(i, false);
        }

        long score = 0;
        while (!nextSmallest.isEmpty()) {
            int[] smallest = nextSmallest.poll();
            if (indexIsMarked.get(smallest[1])) {
                continue;
            } else {
                score += smallest[0];
                indexIsMarked.put(smallest[1], true);
                indexIsMarked.put(smallest[1] + 1, true);
                indexIsMarked.put(smallest[1] - 1, true);
            }
        }


        System.out.println("ans = " + score);
        return score;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findScore(new int[]{2,1,3,4,5,2}); // expected 7
        sol.findScore(new int[]{2,3,5,1,3,2}); // expected 5
        sol.findScore(new int[]{5,1,1,7,2,4}); // expected 3
    }
}