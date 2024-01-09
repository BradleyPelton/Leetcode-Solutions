package contests.contests2022.lc0430.easy;

// Accepted after 9 minutes
// Struggled with string1.compareTo(string2) like always.

class Solution {
    public String removeDigit(String number, char digit) {


        String maxString = "";
        for (int i = 0; i < number.length(); i++) {
            char currDigit = number.charAt(i);
            if (currDigit == digit) {
                StringBuilder sb = new StringBuilder(number);
                sb.deleteCharAt(i);
                String valString = sb.toString();

                int val = valString.compareTo(maxString);

                if (val > 0) {
                    maxString = valString;
                }
            }
        }

//        System.out.println("final ans  = " + maxString);
        return maxString;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.removeDigit("123", '3');
        sol.removeDigit("1231", '1');
        sol.removeDigit("551", '5');
    }
}
