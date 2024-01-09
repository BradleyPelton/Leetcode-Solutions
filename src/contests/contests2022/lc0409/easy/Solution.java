package contests.contests2022.lc0409.easy;

import java.util.PriorityQueue;

// Accepted after 11 minutes
// Interesting problem for an easy. Two priority queues was probably way overkill, but it's what I thought of first
// Took more time to write the code than to come up with the idea.

class Solution {
    public int largestInteger(int num) {

        String numString = String.valueOf(num);

        PriorityQueue<Character> evenPQ = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else if (a.equals(b)) {
                return 0;
            } else {
                return 1;
            }
        });

        PriorityQueue<Character> oddPQ = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else if (a.equals(b)) {
                return 0;
            } else {
                return 1;
            }
        });

        for (int i = 0; i < numString.length(); i++) {
            char nextChar = numString.charAt(i);
//            int charAsInt = Integer.valueOf(nextChar);

            if (nextChar == '0' || nextChar == '2' || nextChar == '4' || nextChar == '6' || nextChar == '8') {
                evenPQ.add(nextChar);
            } else {
                oddPQ.add(nextChar);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numString.length(); i++) {
            char nextChar = numString.charAt(i);
            int charAsInt = Integer.valueOf(nextChar);

            if (nextChar == '0' || nextChar == '2' || nextChar == '4' || nextChar == '6' || nextChar == '8') {
                char poppedEven = evenPQ.poll();
                sb.append(poppedEven);
            } else {
                char poppedOdd = oddPQ.poll();
                sb.append(poppedOdd);
            }
        }

        String ansString = sb.toString();
        int ans = Integer.valueOf(ansString);

//        System.out.println("final ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.largestInteger(1234);
        sol.largestInteger(65875);
    }
}
