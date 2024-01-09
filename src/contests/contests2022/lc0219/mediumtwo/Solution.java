package contests.contests2022.lc0219.mediumtwo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// first attempt rejected
// second attempt accepted at 7:44pm

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        Map<Character, Integer> occMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if(occMap.containsKey(c)) {
                int currVal = occMap.get(c);

                occMap.put(c, ++currVal);
            } else {
                occMap.put(c, 1);
            }

        }


        PriorityQueue<int[]> charPQ = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] > b[0]) {
                return -1;
            } else {
                return 1;
            }
        });

        // populate PQ
        for (char c : occMap.keySet()) {
            int[] entry = new int[2];
            entry[0] = c;
            entry[1] = occMap.get(c);

            charPQ.add(entry);
        }


        StringBuilder sb = new StringBuilder();

        while (charPQ.size() != 0) {
            int[] largestCharAvailableArr = charPQ.poll();
            char largestChar = (char) largestCharAvailableArr[0];
            int occOfLargestChar = largestCharAvailableArr[1];
            String appendString = null;

            // IF LAST CHARACTER
            if (charPQ.size() == 0) {
                if (occOfLargestChar <= repeatLimit) {
                    appendString = String.join("", Collections.nCopies(occOfLargestChar, String.valueOf(largestChar)));
                    sb.append(appendString);
                } else {
                    appendString = String.join("", Collections.nCopies(repeatLimit, String.valueOf(largestChar)));
                    largestCharAvailableArr[1] -= repeatLimit;
                    charPQ.add(largestCharAvailableArr);
                    sb.append(appendString);
                    break;
                }
            } else {
                int[] nextLargestCharAvailableArr = charPQ.poll();
                char nextLargestCharAvailable = (char) nextLargestCharAvailableArr[0];
                int occOfNextLargestChar = nextLargestCharAvailableArr[1];
                String secondAppendString = null;


                if (occOfLargestChar <= repeatLimit) {
                    appendString = String.join("", Collections.nCopies(occOfLargestChar, String.valueOf(largestChar)));
                    charPQ.add(nextLargestCharAvailableArr);
                } else {
                    // append max number
                    appendString = String.join("", Collections.nCopies(repeatLimit, String.valueOf(largestChar)));
                    largestCharAvailableArr[1] -= repeatLimit;
                    charPQ.add(largestCharAvailableArr);

                    // append second character once
                    appendString +=  nextLargestCharAvailable;

                    // cleanup
                    if (occOfNextLargestChar != 1) { // add second back into PQ
                        nextLargestCharAvailableArr[1] -= 1;
                        charPQ.add(nextLargestCharAvailableArr);
                    }
                }
                sb.append(appendString);

            }

        }

        String ans = sb.toString();
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.repeatLimitedString("cczazcc", 3);
        sol.repeatLimitedString("aababab", 2);

    }
}