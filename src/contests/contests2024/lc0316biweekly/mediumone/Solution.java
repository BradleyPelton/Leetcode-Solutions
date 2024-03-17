package contests.contests2024.lc0316biweekly.mediumone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Accepted after 12 minutes
// Trivially, but tedious

class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {

        int n = nums.length;
        boolean[] marked = new boolean[n];
        long currSum = 0L;

        PriorityQueue<int[]> minPQ = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> b[1]));
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            minPQ.add(new int[]{nums[i], i});
        }



        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int targetIndex = query[0];
            if (!marked[targetIndex]) {
                marked[targetIndex] = true;
                currSum -= nums[targetIndex];
            }

            int numberToMark = query[1];

            while (numberToMark > 0 && !minPQ.isEmpty()) {
                int[] val = minPQ.remove();
                if (!marked[val[1]]) {
                    numberToMark--;
                    marked[val[1]] = true;
                    currSum -= val[0];
                }
            }

            ans[i] = currSum;
        }

        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.unmarkedSumArray(
                new int[]{1,2,2,1,2,3,1},
                new int[][]{{1,2},{3,3},{4,2}}
        );
        sol.unmarkedSumArray(
                new int[]{1,4,2,3},
                new int[][]{{0,1}}
        );
    }
}
