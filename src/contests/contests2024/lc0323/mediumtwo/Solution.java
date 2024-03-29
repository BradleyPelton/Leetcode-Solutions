package contests.contests2024.lc0323.mediumtwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Accepted after 23 minutes
// Saw the solution immediately. Similar pattern of using a "version number" with a heap.
// Fumbled indices for a second (literally only two indices, sigh)

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        Map<Long, Long> frequencyMap = new HashMap<>();
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>(Comparator.comparingLong(a -> -a[1]));

        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long currNum = nums[i];
            long updatedFreq = frequencyMap.getOrDefault(currNum, 0L) + freq[i];
            long[] updatedArr = new long[]{currNum, updatedFreq}; // num, freq
            frequencyMap.put(currNum, updatedFreq);
            maxHeap.add(updatedArr);

            while (!maxHeap.isEmpty()) { // clean up the heap.
                long[] top = maxHeap.peek();
                long currOcc = frequencyMap.get(top[0]);
                if (top[1] <= 0) {
                    maxHeap.remove();
                } else if (currOcc != top[1]) {
                    maxHeap.remove();
                } else {
                    break;
                }
            }
            if (maxHeap.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = maxHeap.peek()[1];
            }
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.mostFrequentIDs(
                new int[]{2,3,2,1},
                new int[]{3,2,-3,1}
        );
        sol.mostFrequentIDs(
                new int[]{5,5,3},
                new int[]{2,-2,1}
        );




    }
}
