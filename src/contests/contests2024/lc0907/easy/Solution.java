package contests.contests2024.lc0907.easy;

// Accepted after 3 minutes
// Trivial. Had to remember dec -> bin.

class Solution {
    public String convertDateToBinary(String date) {

        String[] dateSplit = date.split("-");

        String ansString = "";

        for (int i = 0; i < 3; i++) {
            int devVal = Integer.parseInt(dateSplit[i]);
            String binVal = Integer.toBinaryString(devVal);
            ansString += binVal;
            ansString += "-";
        }

        ansString = ansString.substring(0, ansString.length() - 1);

        System.out.println(ansString);
        return ansString;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.convertDateToBinary("2080-02-29");
        sol.convertDateToBinary("1900-01-01");




    }
}
