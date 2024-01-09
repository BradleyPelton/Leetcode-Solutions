package contests.contests2021.lc1016biweekly.easy;

import java.util.Arrays;

// Accepted after 8 minutes

// Took longer to understand the problem than to implement a solution

// Double sorting was clever, I wonder how many people will see this as the obvious answer
// Very Tricky Easy problem

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {

//        seats[i] is the position of the ith seat
//        students[j] is the position of the jth student

        // increment or decrement the posititon of the ith student by 1
        // students[i]++, students[i]--

        // STUDENTS MIGHT BE IN A POSITION THAT IS NOT SEAT

        Arrays.sort(seats);
        Arrays.sort(students);

        int numOfMoves = 0;
        for (int i = 0; i < students.length; i++) {
            int currPosition = students[i];
            int targetPosition = seats[i];

            numOfMoves += Math.abs(targetPosition - currPosition);
        }

        System.out.println("final ans = " + numOfMoves);
        return numOfMoves;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minMovesToSeat(new int[]{3,1,5}, new int[]{2,7,4});
        sol.minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6});
        sol.minMovesToSeat(new int[]{2,2,6,6}, new int[]{1,3,2,6});


    }
}
