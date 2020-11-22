package leetcode20201121MediumProblemOne;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// First attempt time limited exceeded
// Second attempt time limited ecdeeded. This is ridiculous

// Third attempt accepted
// Accepted at 10:22pm EDT( roughly 47 minutes)
// Frustrating time complexity constraints on this problem. Frustrating that Java DOESNT HAVE A WAY TO REPEAT STRINGS
// UNTIL JAVA 11???? HOW DID NO ONE THINK THAT THIS WASNT IMPORTANT...


class Solution {
    public String getSmallestString(int n, int k) {


        int[] intArr = new int[n];
        Arrays.fill(intArr, 1);
        k -= n;

        int numOfZees = k/25;
        k -= numOfZees*25;
//        System.out.println("number of zees is " + numOfZees);
//        Arrays.fill(intArr, 0,numOfZees, 26);


//        StringBuilder s = new StringBuilder();
//        s.append("z".repea)

        String zCopies = String.join("", Collections.nCopies(numOfZees, "z"));
//        System.out.println(zCopies);

        Map<Integer,String> charMap = new HashMap<>();
        int oneIndexed = 1;
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            charMap.put(oneIndexed, String.valueOf(ch));
            oneIndexed += 1;
        }
        int numOfAs;
        String aCopies;

        String extraChar;
        String ansString;
        if(k>0){
            extraChar = charMap.get(k+1);
            numOfAs = n - numOfZees -1;
            aCopies = String.join("", Collections.nCopies(numOfAs, "a"));
            ansString = aCopies + extraChar + zCopies;
        }else{
            numOfAs = n - numOfZees;
            aCopies = String.join("", Collections.nCopies(numOfAs, "a"));
            ansString = aCopies + zCopies;
        }


//        System.out.println(ansString);
        return ansString;




//        System.out.println(Arrays.toString(intArr));


        // FIRST ATTEMPT, TIME LIMITED EXCEEDED
//        for(int i=0; i<n; i++){
//            if(k>25){
//                intArr[i] = 26;
//                k -= 25;
//            } else if (k>0){
//                intArr[i] += k;
//                break;
//            } else{
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(intArr));

//        Map<Integer,String> charMap = new HashMap<>();
//        int oneIndexed = 1;
//        for (char ch = 'a'; ch <= 'z'; ++ch) {
//            charMap.put(oneIndexed, String.valueOf(ch));
//            oneIndexed += 1;
//        }
//
//        String[] stringArr = new String[n];
//        for(int i=0; i<n; i++){
//            stringArr[i] = charMap.get(intArr[i]);
//        }

//        System.out.println(Arrays.toString(stringArr));


//        for(int i=n-1; i>=0; i--){
//            ansString += stringArr[i];
//        }
//        String ansString = "";
//
//
//        System.out.println(ansString);
//        return ansString;

    }
}

class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.getSmallestString(3,27);
//        sol.getSmallestString(5,73);
        sol.getSmallestString(96014, 2095650);

//        sol.getSmallestString(10,10);

    }
}