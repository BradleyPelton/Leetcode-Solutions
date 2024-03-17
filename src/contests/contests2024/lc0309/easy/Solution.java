package contests.contests2024.lc0309.easy;

import java.util.Arrays;
import java.util.Comparator;

// Accepted after 4 minutes
// Tricky easy problem.

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        int numberOfBoxes = 0;
        int excessCapacity = 0;

        int capacityIndex = capacity.length - 1;
        for (int val : apple) {
            if (val <= excessCapacity) {
                excessCapacity -= val;
            } else {
                while (val > excessCapacity) {
                    excessCapacity += capacity[capacityIndex];
                    capacityIndex--;
                    numberOfBoxes++;
                }
                excessCapacity -= val;
            }
        }

        System.out.println(numberOfBoxes);
        return numberOfBoxes;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumBoxes(
                new int[]{1,3,2},
                new int[]{4,3,1,5,2}
        );
        sol.minimumBoxes(
                new int[]{5,5,5},
                new int[]{2,4,2,7}
        );




    }
}
