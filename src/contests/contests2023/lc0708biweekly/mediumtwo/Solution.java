package contests.contests2023.lc0708biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumBeautifulSubstrings(String s) {
        if (s.charAt(0) == '0') {
            System.out.println("zero start impossible, return -1");
            return -1;
        }
        
        
        List<String> binaryFives = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int powFive = (int)Math.pow(5, i);
            String asBinary = Integer.toBinaryString(powFive);
            if (asBinary.length() > 15) {
                break;
            } else {
                binaryFives.add(asBinary);
            }
        }
        
        

        int numberOfBeautifulSubstrings = 0;
        StringBuilder currentSubstring = new StringBuilder();
        currentSubstring.append(s.charAt(0)); // append the first '1'
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '0') {
                currentSubstring.append('0');
            } else {
                numberOfBeautifulSubstrings++;
                currentSubstring = new StringBuilder();
                currentSubstring.append("1");
            }
        }
        if (currentSubstring.length() > 0) {
            numberOfBeautifulSubstrings++;
        }

        System.out.println("ans = " + numberOfBeautifulSubstrings);
        return numberOfBeautifulSubstrings;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumBeautifulSubstrings("1011");
        sol.minimumBeautifulSubstrings("111");
        sol.minimumBeautifulSubstrings("0");
    }
}