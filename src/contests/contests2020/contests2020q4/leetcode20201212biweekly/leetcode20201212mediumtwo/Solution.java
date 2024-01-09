package contests.contests2020.contests2020q4.leetcode20201212biweekly.leetcode20201212mediumtwo;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Too many edge cases to sort out. Ran out of time
// This could have probably be done very easily by a priority queue.
// I should really learn how to use priority queues

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {

        int aliceAdvantage = 0;
        int n = aliceValues.length;
        int[][] alicePriority = new int[n][2];
        int[][] bobPriority = new int[n][2];

        // construct alicePriority
        for (int i=0; i<n; i++){
            int[] tempPair = new int[2];
            tempPair[0] = i;
            tempPair[1] = aliceValues[i];
            alicePriority[i] = tempPair;
        }

        // construct bobPriority
        for (int i=0; i<n; i++){
            int[] tempPair = new int[2];
            tempPair[0] = i;
            tempPair[1] = bobValues[i];
            bobPriority[i] = tempPair;
        }

        System.out.println(Arrays.deepToString(alicePriority));
        System.out.println(Arrays.deepToString(bobPriority));

        Arrays.sort(alicePriority, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(bobPriority, Comparator.comparingInt(o -> o[1]));
        Collections.reverse(Arrays.asList(alicePriority));
        Collections.reverse(Arrays.asList(bobPriority));

//        Collections.reverse();
        System.out.println(Arrays.deepToString(alicePriority));
        System.out.println(Arrays.deepToString(bobPriority));

        for (int i=0; i<n; i++){
            int aliceBestChoice = alicePriority[0][1];
            int bobBestChoice = bobPriority[0][1];
            int bobSecondChoice = bobPriority[1][1];
            int indexOfBobsFirstChoice = bobPriority[0][0];

            int bestChoiceNetGain = aliceBestChoice - bobBestChoice;
            int snubNetGain = alicePriority[indexOfBobsFirstChoice][1] - bobSecondChoice;

            if (bestChoiceNetGain > snubNetGain){
                aliceAdvantage += bestChoiceNetGain;

            } else {
                aliceAdvantage += snubNetGain;
            }
        }


        // ALICE BEST CHOICE
        // BOB BEST CHOICE

        // NET_GAIN = (ALICE_BEST_CHOICE) - (BOB_BEST_CHOICE)
        // SNUB_GAIN = (ALICE_TAKE_BOBS_BEST) - (BOBS_SECOND_BEST)

        // IF SNUB_GAIN > NET_GAIN
        // THEN SNUB

        // ELSE aliceLead += NET_GAIN



        return 12;

    }
}

class Tests{
    public static void main(String[] args){
        Solution sol = new Solution();

        int[] aliceOne = {1,3};
        int[] bobOne = {2,1};

        sol.stoneGameVI(aliceOne,bobOne);
    }
}