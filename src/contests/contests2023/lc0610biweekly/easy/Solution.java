package contests.contests2023.lc0610biweekly.easy;

// Accepted second attempt
// trivial
// Missed the edge case of "uniqueness"

class Solution {
    public boolean isFascinating(int n) {

        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.append(n * 2);
        sb.append(n*3);
        String appendedString = sb.toString();
//        System.out.println(appendedString);

        boolean ans = true;
        for (int i = 1; i < 10; i++) {
            if (!appendedString.contains(String.valueOf(i))) {
                ans = false;
                break;
            }
        }

        if (appendedString.contains("0")) {
            ans = false;
        }

        if (appendedString.length() != 9) {
            ans = false;
        }

        System.out.println("ans = " + ans);
        return ans;


    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.isFascinating(192);
//        sol.isFascinating(100);
        sol.isFascinating(783);

    }
}
