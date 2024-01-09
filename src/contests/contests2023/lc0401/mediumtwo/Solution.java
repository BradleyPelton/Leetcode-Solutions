package contests.contests2023.lc0401.mediumtwo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// First two attempts rejected wrong answer
// Third atempt rejected TLE. You gotta be kidding me

// Fourth attempt accepted. Removed redundant for loop.

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {


        PriorityQueue<int[]> mostValuableCheeseForMouseOne = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));

        for (int i = 0; i < reward1.length; i++) {
            // if cheese is worth x_1 for mouse 1
            // and          worth x_2 for mouse 2
            // To maximize the sum for both mice,
            int[] mouseOneArr = {1, i, reward1[i] - reward2[i]};
            mostValuableCheeseForMouseOne.offer(mouseOneArr);
        }

        int ans = 0;

        List<Integer> seenCheese = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int[] nextCheese = mostValuableCheeseForMouseOne.poll();
            ans += reward1[nextCheese[1]];
        }

        while(!mostValuableCheeseForMouseOne.isEmpty()) {
            int[] nextCheese = mostValuableCheeseForMouseOne.poll();
            ans += reward2[nextCheese[1]];
        }



        System.out.println("ans = " + ans);
        return ans;

//        while(!mostValuableCheeseForMouseOne.isEmpty()) {
//            int[] nextCheese = mostValuableCheeseForMouseOne.poll();
//            if (seenCheese.contains(nextCheese[1])) {
//                continue;
//            } else {
//                seenCheese.add(nextCheese[1]);
//            }
//            int preferredMouse = nextCheese[0];
//            if (preferredMouse == 1 && numberOfCheeseTypesMiceOne < k) {
//                ans += nextCheese[2];
//                numberOfCheeseTypesMiceOne++;
//            } else if (preferredMouse == 1 && numberOfCheeseTypesMiceOne == k) {
//                int cheeseIndex = nextCheese[1];
//                int mouseTwoValue = reward2[cheeseIndex];
//                ans += mouseTwoValue;
//                numberOfCheeseTypesMiceTwo++;
//            }
//
//            if (preferredMouse == 2) {
//                if (numberOfCheeseTypesMiceTwo == reward1.length - k) {
//                    // Overflow. give the rest of the cheese to mouse 1.
//                    int cheeseIndex = nextCheese[1];
//                    int mouseOneValue = reward1[cheeseIndex];
//                    ans += mouseOneValue;
//                    numberOfCheeseTypesMiceOne++;
//                } else {
//                    ans += nextCheese[2];
//                    numberOfCheeseTypesMiceTwo++;
//                }
//            }
//        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.miceAndCheese(
                new int[]{1,1,3,4},
                new int[]{4,4,1,1},
                2
        );
        sol.miceAndCheese(
                new int[]{1,1},
                new int[]{1,1},
                2
        );
        sol.miceAndCheese(
                new int[]{1,4,4,6,4},
                new int[]{6,5,3,6,1},
                1
        ); // expected 24
        sol.miceAndCheese(
                new int[]{1,2,2},
                new int[]{2,1,2},
                2
        ); // expected 6





    }
}