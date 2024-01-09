package contests2020q4.leetcode20201031.Leetcode20201031Easy;

import java.util.HashMap;

// Accepted after 34 minutes
// Accepted after first Attempt

// Clever solution in my not so humble opinion. Keeping track of the current index of each subgroup... masterful
// I wasted 10 minutes debuggin why I was getting a NUllpointerException. Today I learned that is the exception
// thrown when you try to lookup a hashmap with a key that doesnt exist. Adding a simple trycatch solved the issue.
// Onwards is the only way forward.

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        int[] piecePositions = new int[pieces.length];


        // MAP INTEGERS TO THEIR RESPECTIVE PIECE SUBARRAY
        HashMap<Integer, Integer> pieceMap = new HashMap<>();
        for(int i=0; i< pieces.length; i++){
            for(int j=0; j<pieces[i].length; j++){
                pieceMap.put(pieces[i][j], i);

            }
        }

//        for(int i: pieceMap.keySet()){
//            System.out.println("key is " + i + " and value is " + pieceMap.get(i));
//        }
//
        for(int k=0; k<arr.length; k++){
            int kaysSubArray;
            try {
                kaysSubArray = pieceMap.get(arr[k]);
            } catch (NullPointerException e){
                System.out.println("trycatch failure");
                return false;
            }
//            System.out.println(kaysSubArray);
//            int currentSubPos = piecePositions[kaysSubArray];
            int currentSubPos = piecePositions[kaysSubArray] % pieces[kaysSubArray].length;
//
//
            if (arr[k] != pieces[kaysSubArray][currentSubPos]){
                System.out.println("proble at k= " + k);
                return false;
            } else{
//                System.out.println("everythin was fine with k= " + k);
                piecePositions[kaysSubArray] += 1;
            }
        }

        System.out.println("Nothing broke, returning true");
        return true;
    }
}

class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] firstArr = {85};
        int[] secondArr = {15,88};
        int[] thirdArr = {49,18,16};
        int[] fourthArr = {91,4,64,78};
        int[] fifthArr = {1,3,5,7};

        int[][] firstPieces = {{85}};
        int[][] secondPieces = {{88},{15}};
        int[][] thirdPieces = {{16,18,49}};
        int[][] fourthPieces = {{78},{4,64},{91}};
        int[][] fifthPieces = {{2,4,6,8}};

//        sol.canFormArray(firstArr, firstPieces);
//        sol.canFormArray(secondArr, secondPieces);
//        sol.canFormArray(thirdArr, thirdPieces);
//        sol.canFormArray(fourthArr, fourthPieces);
        sol.canFormArray(fifthArr, fifthPieces);
    }
}
