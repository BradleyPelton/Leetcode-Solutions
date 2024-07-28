package contests.contests2024.lc0720.mediumtwo;


// Extreme Yips, worst in months.


// First attempt wrong answer
// Accepted at 10:58
// Accepted after 58 minutes
// I don't know why I was so nervous here. I kept restarting the problem
// it was a simple two pointer. I kept trying to change the logic.

// 10,000 people accepted before me. Worst content rating in months. It happens.

class Solution {
    public int maxOperations(String s) {
//        int numberOfOperations = 0;
//
//        StringBuilder ansBuilder = new StringBuilder(s);
//
//        int left = s.length() - 1;
//
//        while (left > 0) {
//            // MOVE ALL ONES TO THE RIGHT
//            if (s.charAt(left) == '0') {
//                left--;
//                continue;
//            }
//
//            // else s.charAt(left) == '1'
//            int numberOfZeroesBeforeNextOne = 0;
//            for (int i = left - 1; i >= 0; i++) {
//
//            }
//
//            if ()
//        }

        int ans = 0;
        int numberOfOnesToTheLeft = 0;

        int left = 0;
        while (left < s.length()) {
            if (s.charAt(left) == '1') {
                numberOfOnesToTheLeft++;
                left++;
                continue;
            }

            // OBJECTIVE::: Move all ones to the right



            int currIndex = left;
            while (currIndex < s.length()) {
                if (s.charAt(currIndex) == '0') {
                    currIndex++;
                } else {
                    break;
                }
            }

            // curIndex is now a '1'

            ans += numberOfOnesToTheLeft;
            left = currIndex;


        }


        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxOperations("1001101");
        sol.maxOperations("00111");
        sol.maxOperations("110"); // 2




    }
}
