package contests.contests2024.lc0127.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minOrAfterOperations(int[] nums, int k) {
        int n = nums.length;
        // minimize the eventual bitwise OR ( | ) value at the end
        // Thus, minimize the number of unique bits set for all vals in arr


        // XOR
        // arr[i] ^ arr[i + 1] would return the number of different bits
        //


        Map<Integer, List<Integer>> bitSetMap = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            bitSetMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    bitSetMap.get(j).add(i);
                }
            }
        }

        List<List<Integer>> bitSetOcc = new ArrayList<>();
        for(int i =  0; i < 32; i++) {
            int occ = bitSetMap.get(i).size();
            if (occ > 0 || occ > k) {
                bitSetOcc.add(List.of(i, occ));
            }
        }

        Collections.sort(bitSetOcc, Comparator.comparingInt((List<Integer> b) -> -b.get(0)));



        System.out.println(bitSetMap);



        return -42;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOrAfterOperations(
                new int[]{3,5,3,2,7},
                2
        );
        sol.minOrAfterOperations(
                new int[]{7,3,15,14,2,8},
                4
        );
        sol.minOrAfterOperations(
                new int[]{10,7,10,3,9,14,9,4},
                1
        );
    }
}
