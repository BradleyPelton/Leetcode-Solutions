package contests.contests2021.lc0918.easy;

// Accepted after 3 minutes
// Trivial

class Solution {
    public int finalValueAfterOperations(String[] operations) {

        int x = 0;
        for (String op : operations) {
            if (op.equals("--X") || op.equals("X--")) {
                x--;
            } else if (op.equals("++X") || op.equals("X++")) {
                x++;
            }
        }

//        System.out.println("final val of x " + x);
        return x;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.finalValueAfterOperations(new String[]{"--X","X++","X++"});
        sol.finalValueAfterOperations(new String[]{"++X","++X","X++"});
        sol.finalValueAfterOperations(new String[]{"X++","++X","--X","X--"});
    }
}
