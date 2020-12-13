package leetcode20201212mediumtwo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// Neither of my theories for how Greedy algorithm could be applied here work
// I don't think it's a matter of a bug... I think there is just a complicated strategy here.

// Ran out of time

class Solution {
    public int stoneGameVII(int[] stones) {
        // Theory: Alice always removes the lesser of the two stones
        // Theory: Bob always removes the greater of the two stones

        // SECOND THEORY: IF SIZE %2, optimal play is to remove the lesser
        // else remove the greater


        int aliceScore = 0;
        int bobScore = 0;

        int currSum = Arrays.stream(stones).sum(); // currSUm starts as the total sum

        Deque<Integer> stoneDeque = new ArrayDeque<Integer>();
        for (int i: stones){
            stoneDeque.add(i);
        }


        int currentDequeSize = stoneDeque.size();
        boolean aliceTurn = true;
        for (int i = 0; i< stones.length; i++){
            int firstEle = stoneDeque.getFirst();
            int lastEle = stoneDeque.getLast();

            if (aliceTurn){
                if (stoneDeque.size() == 2){
                    if (firstEle <= lastEle){
                        stoneDeque.removeFirst();
                        currSum -= firstEle;
                        aliceScore += currSum;
                    } else {
                        stoneDeque.removeLast();
                        currSum -= lastEle;
                        aliceScore += currSum;
                    }
                } else if (currentDequeSize % 2 == 1){
                    // %2 == 1, remove the lesser
                    if (firstEle <= lastEle){
                        stoneDeque.removeFirst();
                        currSum -= firstEle;
                        aliceScore += currSum;
                    } else {
                        stoneDeque.removeLast();
                        currSum -= lastEle;
                        aliceScore += currSum;
                    }
                } else {
                    // % 2 == 0 , remove the greater
                    if (firstEle <= lastEle){
                        stoneDeque.removeLast();
                        currSum -= lastEle;
                        aliceScore += currSum;
                    } else {
                        stoneDeque.removeFirst();
                        currSum -= firstEle;
                        aliceScore += currSum;
                    }
                }
                aliceTurn = false;
            } else { // bob's turn
                if (stoneDeque.size() == 2){
                    if (firstEle <= lastEle){
                        stoneDeque.removeFirst();
                        currSum -= firstEle;
                        bobScore += currSum;
                    } else {
                        stoneDeque.removeLast();
                        currSum -= lastEle;
                        bobScore += currSum;
                    }
                } else if (currentDequeSize % 2 == 1){
                    // %2 == 1, remove the lesser
                    if (firstEle <= lastEle){
                        stoneDeque.removeFirst();
                        currSum -= firstEle;
                        bobScore += currSum;
                    } else {
                        stoneDeque.removeLast();
                        currSum -= lastEle;
                        bobScore += currSum;
                    }
                } else {
                    // % 2 == 0 , remove the greater
                    if (firstEle <= lastEle){
                        stoneDeque.removeLast();
                        currSum -= lastEle;
                        bobScore += currSum;
                    } else {
                        stoneDeque.removeFirst();
                        currSum -= firstEle;
                        bobScore += currSum;
                    }
                }
                aliceTurn = true;
            }
//                int firstEle = stoneDeque.getFirst();
//                int lastEle = stoneDeque.getLast();
//                if (firstEle <= lastEle){
//                    stoneDeque.removeFirst();
//                    currSum -= firstEle;
//                    aliceScore += currSum;
//                } else {
//                    stoneDeque.removeLast();
//                    currSum -= lastEle;
//                    aliceScore += currSum;
//                }
//                aliceTurn = false;
//            } else {
//                int firstEle = stoneDeque.getFirst();
//                int lastEle = stoneDeque.getLast();
//
//                if (stoneDeque.size() == 2){
//                    if (firstEle <= lastEle){
//                        stoneDeque.removeFirst();
//                        currSum -= firstEle;
//                        bobScore += currSum;
//                    } else {
//                        stoneDeque.removeLast();
//                        currSum -= lastEle;
//                        bobScore += currSum;
//                    }
//                } else {
//                    if (firstEle <= lastEle){
//                        stoneDeque.removeLast();
//                        currSum -= lastEle;
//                        bobScore += currSum;
//                    } else {
//                        stoneDeque.removeFirst();
//                        currSum -= firstEle;
//                        bobScore += currSum;
//                    }
//                    aliceTurn = true;
//                }
//            }
        }

        System.out.println(" final score for Alice is " + aliceScore);
        System.out.println(" final score for Bob is " + bobScore);
        return 5;

    }
}

class Tests{
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] firstStones = {5,3,1,4,2};
    int[] secondStones = {7,90,5,1,100,10,10,2};

//      sol.stoneGameVII(firstStones);
      sol.stoneGameVII(secondStones);
  }
}