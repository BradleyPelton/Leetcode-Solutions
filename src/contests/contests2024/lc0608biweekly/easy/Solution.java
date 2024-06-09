package contests.contests2024.lc0608biweekly.easy;


// Accepted after 6 minutes
// Tricky easy problems. Brute force

class Solution {
    public String clearDigits(String s) {

        StringBuilder ansBuilder = new StringBuilder(s);

        OUTER_LOOP:
        while (true) {
            boolean deletionMade = false;

            for (int i = 0; i < ansBuilder.length(); i++) {
                char currChar = ansBuilder.charAt(i);
                if (Character.isDigit(currChar)) {
                    for (int j = i - 1; j >= 0; j--) {
                        char prevChar = ansBuilder.charAt(j);
                        if (!Character.isDigit(prevChar)) {
                            ansBuilder.deleteCharAt(i);
                            ansBuilder.deleteCharAt(j);
                            deletionMade = true;
                            continue OUTER_LOOP;
                        }
                    }
                } else {
                    continue;
                }
            }
            if (!deletionMade) {
                break;
            }
        }

        String ans = ansBuilder.toString();
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.clearDigits("abc");
        sol.clearDigits("cb34");





    }
}
