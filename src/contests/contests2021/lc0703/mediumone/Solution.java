package contests.contests2021.lc0703.mediumone;

import java.util.Arrays;
import java.util.PriorityQueue;

// accepted after 25 minutes (11:00 pm edt)
// Accepted after first try

// Cool priority queue problem. Determine which mosnter to kill. Greedy.

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {

        int numberOfMonsters = dist.length;
        double[] arrivalTime = new double[numberOfMonsters];

        for (int i = 0; i < numberOfMonsters; i++) {
            arrivalTime[i] = ((double) dist[i])/speed[i];
        }

        PriorityQueue<Double[]> arrivalPQ = new PriorityQueue<Double[]>((a,b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i = 0; i < numberOfMonsters; i++) {
            Double[] temp = new Double[2];
            temp[0] = arrivalTime[i];
            temp[1] = (double) i;
            arrivalPQ.add(temp);
        }

        int numberOfSlainMonsters = 0;
        int currentTime = 0;
        while (true) {
            Double[] monster = arrivalPQ.poll();
            double monsterArrivalTime = monster[0];

            if (monsterArrivalTime <= currentTime) {
                System.out.println("MONSTER KILLED CITY");
                System.out.println(Arrays.toString(monster));
                break;
            } else {
                numberOfSlainMonsters++;
                currentTime++;
            }


            if (arrivalPQ.size() == 0) {
                System.out.println("all monsters slain");
                break;
            }

        }


        System.out.println("FINAL ANS " + numberOfSlainMonsters);
        return numberOfSlainMonsters;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] firstDist = {1,3,4};
        int[] secondDist = {1,1,2,3};
        int[] thirdDist = {3,2,4};
//        int[] firstDist = {1,3,4};

        int[] firstSpeed = {1,1,1};
        int[] secondSpeed = {1,1,1,1};
        int[] thirdSpeed = {5,3,2};
//        int[] firstSpeed = {1,3,4};

        sol.eliminateMaximum(firstDist, firstSpeed);
        sol.eliminateMaximum(secondDist, secondSpeed);
        sol.eliminateMaximum(thirdDist, thirdSpeed);

    }
}
