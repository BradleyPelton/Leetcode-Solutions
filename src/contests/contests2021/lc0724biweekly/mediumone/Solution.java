package contests.contests2021.lc0724biweekly.mediumone;

import java.util.ArrayList;
import java.util.PriorityQueue;

// First attempt : Time limit exceeded
// Second attempt : Time limit exceeded

// Third attempt, accepted

// Switching to a priority queue to remember which chair is next available was clever
// Brute forcing which chair was available was a dumb mistake. I should know better.


class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[][] sortedTimes = new int[times.length][3];

        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            int[] tempTime = new int[]{time[0],time[1],i};
            sortedTimes[i] = tempTime;
        }


        // sort on arrival time(unique)
        java.util.Arrays.sort(sortedTimes, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
//        System.out.println(Arrays.deepToString(sortedTimes));

        ArrayList<Integer> currentChairs = new ArrayList<>();

        ArrayList<int[]> chairReopeningArray = new ArrayList<>();

        int lastArrivalTime = sortedTimes[sortedTimes.length - 1][0];
        int globalTime = 0;

        PriorityQueue<Integer> chairPQ = new PriorityQueue<Integer>((a, b) -> {return(Integer.compare(a,b));});

        for (int i = 0; i < sortedTimes.length; i++) {
            globalTime = sortedTimes[i][0];

            int[] nextPerson = sortedTimes[i];
            int nextPersonArrivalTime = nextPerson[0];
            int nextPersonDepartureTime = nextPerson[1];
            int nextPersonIndex =  nextPerson[2];


            // CLEANUP CHAIRS
            ArrayList<int[]> newChairReopeningArray = new ArrayList<>();
            for (int[] chairReop : chairReopeningArray) {
                if (chairReop[1] <= globalTime) {
                    currentChairs.set(chairReop[0], 0);
                    chairPQ.add(chairReop[0]);
                } else {
                    newChairReopeningArray.add(chairReop);
                }
            }
            chairReopeningArray = newChairReopeningArray;

            // FIND PERSON A CHAIR
            if (nextPerson[0] == globalTime) {
                int nextChair = -5;
                int realNextChair = -5;

                if (chairPQ.isEmpty()) {
                    // add a new chair
                    currentChairs.add(1);
                    realNextChair = currentChairs.size() - 1;
                } else {
                    // else mark chair as occupied
                    nextChair = chairPQ.poll();
                    currentChairs.set(nextChair,1);
                    realNextChair = nextChair;
                }

                chairReopeningArray.add(new int[]{realNextChair,nextPersonDepartureTime});


                if (nextPersonIndex == targetFriend) {
                    System.out.println("target friend should sit at " + realNextChair);
                    return realNextChair;
                }
            }
        }
        return -5;  // should never happen
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();




        int[][] timesOne = {{1,4},{2,3},{4,6}};
        int[][] timesTwo = {{3,10},{1,5},{2,6}};


        sol.smallestChair(timesOne, 1);
        sol.smallestChair(timesTwo, 0);
    }
}