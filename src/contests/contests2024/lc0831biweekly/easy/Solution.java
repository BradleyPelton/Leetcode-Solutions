package contests.contests2024.lc0831biweekly.easy;

// Accepted after 9 minute
// Accepted first try

// Fumbled Character.forDigit() investigate.

class Solution {
    public int generateKey(int num1, int num2, int num3) {

        StringBuilder num1AsString = new StringBuilder(String.valueOf(num1));
        StringBuilder num2AsString = new StringBuilder(String.valueOf(num2));
        StringBuilder num3AsString = new StringBuilder(String.valueOf(num3));

        while (num1AsString.length() < 4) {
            num1AsString.insert(0, '0');
        }
        while (num2AsString.length() < 4) {
            num2AsString.insert(0, '0');
        }
        while (num3AsString.length() < 4) {
            num3AsString.insert(0, '0');
        }

        String num1String = num1AsString.toString();
        String num2String = num2AsString.toString();
        String num3String = num3AsString.toString();

        StringBuilder ansBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int valOne = Integer.valueOf(String.valueOf(num1String.charAt(i)));
            int valTwo = Integer.valueOf(String.valueOf(num2String.charAt(i)));
            int valThree = Integer.valueOf(String.valueOf(num3String.charAt(i)));
            int localAns = Math.min(valOne, Math.min(valTwo, valThree));
            ansBuilder.append(localAns);
        }

        int ans = Integer.parseInt(ansBuilder.toString());
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateKey(
                1,
                10,
                1000
        );
        sol.generateKey(
                987,
                879,
                798
        );
        sol.generateKey(
                1,
                2,
                3
        );


    }
}