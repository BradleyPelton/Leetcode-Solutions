package _Study.GrantStreet;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 *
 *
 *
 *
 */
class Solution {
    int n;
    int[] A;
    Map<Integer, Map<Integer, Integer>> memoization;
    public int solution(int[] A) {
        this.A = A;
        n = A.length;
        memoization = new HashMap<>();
        // edge cases: overflow
        // max[A] <= 1 billion, thus targetSum <= max[A] * 2 < Integer.MAX_VALUE. thus no integer overflow

        // Current Approach: Top Down Dynamic Programming (aka "Memoization"). Recursion + caching.
        // HIGHLY inefficient :(  . Big O(2**n) runtime complexity. Worst case the sum is always different.
        // This DP solution is effectively brute force with a lot of caching. Still significantly better than brute force on average.
        int ans = numberOfNonOverlappingSegments(0, -1);
        //System.out.println(ans);
        return ans;
    }

    private int numberOfNonOverlappingSegments(int index, int targetSum) {
        if (index >= n - 1) { // Nothing to do on the last index (n - 1). Previous index would already account for sum
            return 0;
        }

        // Slight optimization: We could cache the largestNumberOfNonOverlappingSegments seen already
        // , then prune any current targetSum where the remaining number of elements divided by 2 can't every achieve the already cached largest

        if (memoization.containsKey(targetSum)) {
            if (memoization.get(targetSum).containsKey(index)) {
                return memoization.get(targetSum).get(index);
            }
        }
        int currentAns;
        if (targetSum == -1) { // if targetSum == -1, we haven't chosen a targetSum yet,
            int useCurrentPairSum = numberOfNonOverlappingSegments(index + 2, A[index] + A[index + 1])
                    + 1; // plus the leading pair that we are using

            // do nothing and choose a targetSum later in the array
            int doNothing = numberOfNonOverlappingSegments(index + 1, -1);

            currentAns = Math.max(useCurrentPairSum, doNothing);
        } else { // else targetSum was already chosen. We are just counting.
            if (A[index] + A[index + 1] == targetSum) {
                currentAns = numberOfNonOverlappingSegments(index + 2, targetSum) + 1;
            } else {
                currentAns = numberOfNonOverlappingSegments(index + 1, targetSum);
            }
        }

        if (!memoization.containsKey(targetSum)) {
            memoization.put(targetSum, new HashMap<>());
        }
        memoization.get(targetSum).put(index, currentAns);
        return currentAns;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{10,1,3,1,2,2,1,0,4});  // 3
        sol.solution(new int[]{5,3,1,3,2,3});  // 1
        sol.solution(new int[]{9,9,9,9,9});     // 2
        sol.solution(new int[]{1,5,2,4,3,3});   // 3

    }
}

