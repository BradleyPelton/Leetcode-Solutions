package contests.contests2021.lc0724.mediumone;


// first attempt time limit exceeded
// second attempt wrong answer
// third attempt time limit exceeded


// fucking dumb
// Stringbuilder was faster than string concatenation.
// Spent 20 minutes over optimizing other parts of the code

import java.util.HashMap;

class Solution {
    public String maximumNumber(String num, int[] change) {


        String ansString = "";

        // Find index where we start
//        int startChange = -5;
//        for (int i = 0; i < num.length(); i++) {
//            int charVal = Integer.parseInt(Character.toString(num.charAt(i)));
//            int changeVal = change[charVal];
//
//            if (changeVal > charVal) {
//                startChange = i;
//                break;
//            }
//        }
//
//        if (startChange == -5) {
//            System.out.println("already max string, returning original");
//            System.out.println("final ans = " + num);
//            return num;
//        } else {
//
//            int endChange = Integer.MAX_VALUE;
//            for (int i = startChange; i < num.length(); i++) {
//                int charVal = Integer.parseInt(Character.toString(num.charAt(i)));
//                int changeVal = change[charVal];
//
//                if (changeVal < charVal) {
//                    endChange = i;
//                    break;
//                }
//            }
//
//            for (int i = 0; i < num.length(); i++) {
//                if (i >= startChange && i < endChange) {
//                    ansString += change[Integer.parseInt(Character.toString(num.charAt(i)))];
//                } else {
//                    ansString += num.charAt(i);
//                }
//            }
//        }

        HashMap<Character, Character> changeMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            changeMap.put((char) (i + 48), (char) (change[i] + 48));
        }

        boolean hasStarted = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char charVal = num.charAt(i);
            char changeVal = changeMap.get(num.charAt(i));

            if (changeVal > charVal) {
                sb.append(changeVal);
                hasStarted = true;
                continue;
            }

            if (hasStarted && changeVal < charVal) {
                sb.append(num.substring(i));
                break;
            } else {
                sb.append(charVal);
            }
        }

        ansString = sb.toString();

        if (ansString.equals("")) {
            ansString = num;
        }


//        System.out.println("final ans " + ansString);
        return ansString;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.maximumNumber("132", new int[]{9,8,5,0,3,6,4,2,6,8});
        sol.maximumNumber("021", new int[]{9,4,3,5,7,2,1,9,0,6});
        sol.maximumNumber("5", new int[]{1,4,7,5,3,2,5,6,9,4});
        sol.maximumNumber("330", new int[]{9,3,6,3,7,3,1,4,5,8});  //expected "339"

    }
}