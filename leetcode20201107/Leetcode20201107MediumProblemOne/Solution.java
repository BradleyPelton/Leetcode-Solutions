package Leetcode20201107MediumProblemOne;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Accepted after 43 minutes (10:25 EST)
// Accepted after third attempt

// Sloppy edge case handling here. When I was decrementing a value, I didnt consider that the new value would be less
// than the value to the right of it. Sloppy.

class Solution {
    public int minDeletions(String s) {

        Map<Character,Integer> frequenciesMap = new HashMap<>();
        for (char ch : s.toCharArray())
            frequenciesMap.put(ch, frequenciesMap.getOrDefault(ch, 0) + 1);


        int[] freqArr = new int[frequenciesMap.keySet().size()];

        int i = 0;
        for (char c: frequenciesMap.keySet()){
//            System.out.println("Char: " + c + " Value: " + frequenciesMap.get(c));
            freqArr[i] = frequenciesMap.get(c);

            i++;
        }

//        System.out.println(Arrays.toString(freqArr));
        Arrays.sort(freqArr);
//        System.out.println(Arrays.toString(freqArr));

        int[] revFreqArr = new int[freqArr.length];

        for (int j=0; j<freqArr.length; j++){
            revFreqArr[j] = freqArr[freqArr.length - 1 - j];
        }
//        System.out.println(Arrays.toString(revFreqArr));


        int ans = 0;
        boolean neededCorrection = true;
        outerWhile:
        while (neededCorrection){
            for (int k=0; k<revFreqArr.length-1; k++){
                if(revFreqArr[k]==0 && revFreqArr[k+1]==0){
                    continue;
                }
                if (revFreqArr[k] <= revFreqArr[k+1]){
                    ans += 1;
                    revFreqArr[k+1] -= 1;
                    continue outerWhile;
                }
            }
            neededCorrection = false;
        }


        System.out.println("final ans is " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String firstString = "aab";
        String secondString = "aaabbbcc";
        String thirdString = "ceabaacb";

        String fourthString = "abcabc";  // expected 3
        String fifthString = "bbcebab"; // expected 2

        sol.minDeletions(firstString);
        sol.minDeletions(secondString);
        sol.minDeletions(thirdString);
        sol.minDeletions(fourthString);
        sol.minDeletions(fifthString);
    }
}