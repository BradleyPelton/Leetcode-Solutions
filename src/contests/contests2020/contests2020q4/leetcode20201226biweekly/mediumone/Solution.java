package leetcode20201216biweekly.mediumone;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Cool problem, but I had to stop the competition early.
// I figured out the solution, but the implementation is a little challenging

class Solution {
    public double averageWaitingTime(int[][] customers) {


        List<int[]> customerList = Arrays.asList(customers);
        ArrayDeque<int[]> customerDeq = new ArrayDeque<>(customerList);

        ArrayDeque<int[]> currentlyWaiting = new ArrayDeque<int[]>();

        int currentTime = 0;
        int totalTimeWaited = 0;

        for (int i=0; i<10000; i++) {
            // Serve the customers as they come in. First in First out.

            if (currentlyWaiting.size() == 0) {
                currentlyWaiting.add(customerDeq.pop());
                currentTime = currentlyWaiting.getFirst()[0];
            }

            for (int[] subArr : customerDeq) {
                if (subArr[0] == currentTime) {  // SAME ARRIVE TIME EDGE CASE
                    currentlyWaiting.add(customerDeq.pop());
                } else {
                    break;
                }
            }

            currentlyWaiting.getFirst()[1] -= 1;

            if (currentlyWaiting.getFirst()[1] == 0) {
                currentlyWaiting.pop();
            }


            totalTimeWaited += currentlyWaiting.size();
        }





        return (double) totalTimeWaited/customers.length;

    }
}