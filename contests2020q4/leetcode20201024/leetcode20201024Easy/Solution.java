package contests2020q4.leetcode20201024.leetcode20201024Easy;

import java.util.ArrayList;
import java.util.Arrays;

// Accepted after 17 minutes.
// Accepted after first try

// NOTES: A little slow this evening. There was a nasty edge case were multiple values have the same duration
// Which took 10 minutes and 20 lines to cross out
// NOTES: I'm still using very sloppy handling of basic Array operations. Using Stream sort for example
// I need to perfect using these simple methods because I will be using them for decades.

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int[] durations = new int[releaseTimes.length];

        durations[0] = releaseTimes[0];
        for(int i=1; i<releaseTimes.length; i++){
            durations[i] = releaseTimes[i] - releaseTimes[i-1];
        }

//        System.out.println(Arrays.toString(durations));

        int maxVal = Arrays.stream(durations).max().getAsInt();
//        System.out.println("max value is " + maxVal);

        ArrayList<Integer> longestIndecies = new ArrayList<>();

        for (int j=0; j<durations.length; j++){
            if (durations[j]==maxVal){
                longestIndecies.add(j);
            }
        }

//        System.out.println(Arrays.toString(longestIndecies.toArray()));

        char[] ansChars = new char[longestIndecies.size()];
        for (int k=0; k<longestIndecies.size(); k++){
            ansChars[k] = keysPressed.charAt(longestIndecies.get(k));
        }

//        System.out.println(Arrays.toString(ansChars));

        Arrays.sort(ansChars);

//        System.out.println(Arrays.toString(ansChars));

        char finalAns = ansChars[ansChars.length -1];
        System.out.println("final answer is " + finalAns);

        return finalAns;
    }
}

class Tests{
    public static void main(String[] args) {
        int[] firstReleases = {9,29,49,50};
        int[] secondReleases = {12,23,36,46,62};
        String firstKeys = "cbcd";
        String secondKeys = "spuda";

        Solution sol = new Solution();
        sol.slowestKey(firstReleases, firstKeys);
        sol.slowestKey(secondReleases, secondKeys);
    }
}