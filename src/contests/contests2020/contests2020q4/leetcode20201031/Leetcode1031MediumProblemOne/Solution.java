package contests2020q4.leetcode20201031.Leetcode1031MediumProblemOne;

import java.util.Arrays;

// FUmbled around with the cool math instead of implementing a solution. Whoops :D


class Solution {
    static String[] createStrings (String[] inputStrings){
        String[] outputStrings = Arrays.copyOf(inputStrings, inputStrings.length);
        for(String s: inputStrings){
            if(s.charAt(0) =='a'){

            }
        }
        return null;

    }
    public int countVowelStrings(int n) {

        String[] vowels = {"a","e","i","o","u"};


        return 5;
        // {aaa, aae, aai, aao, aau, aee}

//        [0,0,0,0,0,..., n]
        // [5,5,5,5

//        [5,5]
        // [1,4]

        // [5,5,5]
        // [1,4,4]
        // [1,1,3]
//
//        int[] nArr = new int[n];
//        Arrays.fill(nArr, 5);
//
//        int totalAns = 0;
//        for(int i=0; i<n; i++){
//            totalAns += Arrays.stream(nArr).sum();
//
//            nArr =
//
//        }



        // RECURSIONS

        // if {a,e,i,o,u} is n=1
        // n=2 is (a + {n=1} +
        //          JUST n + 4/5 n + 3/5n + 2/5n +1/5n



        // f(n)  = 3(f(n-1))

    }
}