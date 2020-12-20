package leetcode20201114BiweeklyEasy;


import java.util.Arrays;

// Accepted after first Attempt
// Accepted after 16 minutes ( 9:46 am EDT)
// Pretty easy. I just had to remember FloorMOd vs module with %.
// Floormod is pretty handy

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] outputArr = new int[n];

        if(k>0){

            for(int i=0; i<n; i++){
                for(int j=1; j<=k; j++){
                    int rawIndex = i+j;
                    int newIndex = Math.floorMod(rawIndex, n);
//                    System.out.println("adding " + code[newIndex] + " to " + outputArr[i] + " at index " + i);
                    outputArr[i] += code[newIndex];
                }

            }
//            System.out.println(Arrays.toString(outputArr));

        } else if(k<0){
            int positiveK = Math.abs(k);

            for(int i=0; i<n; i++){
                for(int j=1; j<=positiveK; j++){
                    int rawIndex = i-j;
                    int newIndex = Math.floorMod(rawIndex, n);
//                    System.out.println("adding " + code[newIndex] + " to " + outputArr[i] + " at index " + i);
                    outputArr[i] += code[newIndex];
                }

            }
        } else if(k==0){;
        } else{
            System.out.println("k has unknown value");
        }

//        System.out.println(Arrays.toString(outputArr));
        return outputArr;
    }
}

class Tests{
    public static void main(String[] args) {
        int[] firstArr = {5,7,1,4};
        int[] secondArr = {1,2,3,4};
        int[] thirdArr = {2,4,9,3};

        Solution sol = new Solution();
        sol.decrypt(firstArr,3);
        sol.decrypt(secondArr,0);
        sol.decrypt(thirdArr,-2);
    }
}