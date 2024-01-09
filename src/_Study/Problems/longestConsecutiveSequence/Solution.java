package _Study.Problems.longestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * // TODO - UNION FIND
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> startingToEnding = new HashMap<>();
        Map<Integer, Integer> endingToStarting = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        for (int val : nums) {
            if (seen.add(val)) { // repeat values don't change any intervals
                int start;
                int end;
                if (endingToStarting.containsKey(val - 1)) {
                    if (startingToEnding.containsKey(val + 1)) { // val connects two existing intervals ::: {1,2} + VAL + {4,5}
                        start = endingToStarting.get(val - 1);
                        end = startingToEnding.get(val + 1);
                        endingToStarting.remove(val - 1);
                        startingToEnding.remove(start);
                    } else {                                    // val appends to the end of an existing interval
                        start = endingToStarting.get(val - 1);
                        end = val;
                        endingToStarting.remove(val - 1);
                    }
                } else if (startingToEnding.containsKey(val + 1)) { // val prepends to the beginning of an existing interval
                    start = val;
                    end = startingToEnding.get(val + 1);
                    startingToEnding.remove(val + 1);
                } else {                                            // val starts a new trivial interval from [val,val]
                    start = val;
                    end = val;
                }
                endingToStarting.put(end, start);
                startingToEnding.put(start, end);
            }
        }

        int longest = 0;
        for (int start : startingToEnding.keySet()) {
            longest = Math.max(longest, startingToEnding.get(start) - start + 1);
        }
        System.out.println(longest); //
        return longest;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.longestConsecutive(new int[]{100,4,200,1,3,2});
//        sol.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        sol.longestConsecutive(new int[]{-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7});
    }
}
