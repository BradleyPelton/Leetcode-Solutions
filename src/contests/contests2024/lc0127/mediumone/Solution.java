package contests.contests2024.lc0127.mediumone;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;



// First attempt TLE. Bad while loop;

// Accepted after 14 minutes
// Cool problem. TreeMap usage

//  I wonder if there is a Big O(n) solution.

class Solution {
    public int maximumLength(int[] nums) {

        Map<Integer, Integer> occMap = new TreeMap<>();
        for(int val : nums) {
            occMap.put(val, occMap.getOrDefault(val, 0) + 1);
        }

        int numberOfOnes = occMap.getOrDefault(1, 0);
        occMap.remove(1);

        int maxLength = 1;
        if (numberOfOnes > 1) {
            if (numberOfOnes % 2 == 1) {
                maxLength = numberOfOnes;
            } else {
                maxLength = numberOfOnes - 1;
            }
        }


        for (int key : occMap.keySet()) {

            if (occMap.get(key) == 1) {
                continue;
            }
            int currLen = 2;
            int currVal = key;
            while (true) {
                currVal *= currVal;
                int currValOcc = occMap.getOrDefault(currVal, 0);
                if (currValOcc == 0) {
                    // we have to remove the last currVal and reduce length
                    currLen--;
                    break;
                } else if (currValOcc == 1) {
                    // has to be center
                    currLen++;
                    break;
                } else {
                    // extend by two
                    currLen += 2;
                }
            }

            maxLength = Math.max(maxLength, currLen);
        }

        System.out.println(maxLength);
        return maxLength;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumLength(
                new int[]{5,4,1,2,2}
        );
        sol.maximumLength(
                new int[]{1,3,2,4}
        );
        sol.maximumLength(
                new int[]{1,1}
        );





    }
}