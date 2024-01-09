package contests.contests2021.lc0807biweekly.easy;

// Accepted after 8 minutes
// Trivial String manipulation

class Solution {
    public String makeFancyString(String s) {

        int numberOfDeletions = 0;

        if (s.length()== 1 || s.length()==2) {
            System.out.println("1 and 2 edge case");
            return s;
        }

        StringBuilder sb = new StringBuilder();

        char previousSquared = '?';
        char previous = '?';
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (previousSquared == previous && previous == currChar) {
//                System.out.println("found triplicate at index i = " + i);
                continue;
            } else {
                sb.append(currChar);

                previousSquared = previous;
                previous = currChar;
            }
        }

        String ansString = sb.toString();
//        System.out.println("final answer = " + ansString);


        return ansString;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.makeFancyString("leeetcode");
        sol.makeFancyString("aaabaaaa");
        sol.makeFancyString("aab");
        sol.makeFancyString("aaa");
    }
}