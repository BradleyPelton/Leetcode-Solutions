package _Study.Problems.topKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description
 *
 *
 * // TODO - There are some interesting solutions involving heaps, special sorting algorithms, etc.
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occMap = new HashMap<>();

        for (int val :  nums) {
            occMap.put(val, occMap.getOrDefault(val, 0) + 1);
        }

        List<int[]> occList = new ArrayList<>();

        for (int key : occMap.keySet()) {
            occList.add(new int[]{key, occMap.get(key)});
        }
        Collections.sort(occList, Comparator.comparingInt(a -> -a[1]));

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = occList.get(i)[0];
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        sol.topKFrequent(new int[]{1}, 1);
        sol.topKFrequent(new int[]{-1,-1}, 1);
    }
}