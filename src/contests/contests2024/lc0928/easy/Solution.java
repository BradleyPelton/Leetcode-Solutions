package contests.contests2024.lc0928.easy;

// Accepted after 3 minutes
// Trivial

class Solution {
    public char kthCharacter(int k) {

        String ansString = "a";

        while (ansString.length() < k) {
            String stringBefore = ansString;
            StringBuilder builder = new StringBuilder(stringBefore);
            for (char c : stringBefore.toCharArray()) {
                builder.append((char)(c + 1));
            }
            ansString = builder.toString();
        }

        char ansChar = ansString.charAt(k - 1);
//        System.out.println(ansChar);
        return ansChar;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.kthCharacter(5);
        sol.kthCharacter(10);




    }
}
