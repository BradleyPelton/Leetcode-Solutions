package leetcode20201219.easy;

// Accepeted after first try
// Accepted after 14 minutes

// A little sloppy edge case handling took a few extra minutes. I didnt have to look anything up though.
// Only 1500 people were faster, so apparently other people were having problems with this problem as well.

class Solution {
    public String reformatNumber(String number) {

        String unformattedString = "";

        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == ' ' || number.charAt(i) == '-'){
                ;
            } else {
                unformattedString += Character.toString(number.charAt(i));
            }
        }

//        System.out.println(unformattedString);

        String ansString = "";

        for (int i = 0; i<10000; i++) {
            if (unformattedString.length() > 4){
                ansString += unformattedString.substring(0,3) + "-";
                unformattedString = unformattedString.substring(3);
            } else {
                break;
            }
        }
//        System.out.println("ans string after three blocks is " + ansString);

        if (unformattedString.length() == 4){
            ansString += unformattedString.substring(0,2) + "-" + unformattedString.substring(2);
        } else if (unformattedString.length() == 3){
            ansString += unformattedString;
        } else if (unformattedString.length() == 2){
            ansString += unformattedString;
        }
//        System.out.println("ans string after end is " + ansString);

//        System.out.println(ansString);
        return ansString;
//        int numberOfNums = unformattedString.length();
//
//        int numberOfThreeBlocks = numberOfNums/3;
//        int remainder = numberOfNums - (numberOfThreeBlocks * 3);
//
//        if (remainder == 1) {
//            remainder = 4;
//            numberOfThreeBlocks -= 1;
//        } else if (remainder == 0) {
//            remainder = 3;
//            numberOfThreeBlocks -= 1;
//        } // else remainder is 2



    }
}
class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();

        String firstString = "1-23-45 6";
        String secondString = "123 4-567";
        String thirdString = "123 4-5678";
        String fourthString = "12";
        String fifthString = "--17-5 229 35-39475";
        sol.reformatNumber(firstString);
        sol.reformatNumber(secondString);
        sol.reformatNumber(thirdString);
        sol.reformatNumber(fourthString);
        sol.reformatNumber(fifthString);

    }
}
