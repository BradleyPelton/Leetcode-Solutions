package Leetcode20201031BiweeklyEasy;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

// Accepted after 1 hour and 20 minutes
// Accepted after first attempt

// This problem exposed some of my fundamental misunderstandings with with Streams
// In particular, I could have sorted a 2d array in python with a basic lambda function,
// but for some reason an hour of browsing Stakoverflow didnt yield any results. I ended up just brute forcing
// the final answer instead of trying to user a nice stream.

class Solution {
    public int[] frequencySort(int[] nums) {






        // Create freq Map
        Map<Integer, Long> freq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));


        ArrayList<int[]> freqAndOcc = new ArrayList<int[]>();

        for (int key : freq.keySet()) {
//            System.out.println(key + "  " + freq.get(key));
            int[] pair = new int[2];
            pair[0] = key;
            pair[1] = Math.toIntExact(freq.get(key));
            freqAndOcc.add(pair);
        }

//        System.out.println(Arrays.deepToString(freqAndOcc.toArray()));


        // NONE OF THIS SHIT WORKED
//        int[] sortedArr = Arrays.sort(freqAndOcc.toArray(), (a, b) -> Integer.compare(a, b));


//        int[] arr = freqAndOcc.stream().mapToInt(i -> i).toArray();

//        freqAndOcc.stream().sorted(Comparator.comparing().thenComparing(Person::getAge));


//        Collections.sort(freqAndOcc, );

        int[][] freqAndOccArr = new int[freqAndOcc.size()][2];
//        freqAndOccArr = freqAndOcc.toArray(); // Why does this not work
        for(int i=0; i<freqAndOcc.size(); i++){
            freqAndOccArr[i] = freqAndOcc.get(i);
        }

//        System.out.println(Arrays.deepToString(freqAndOccArr));


        // NONE OF THIS SHIT WORKED EITHER
//        Arrays.sort(freqAndOccArr, java.util.Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
//        System.out.println(Arrays.deepToString(freqAndOccArr));

//        Arrays.sort(freqAndOccArr, (a, b) -> a[0] - b[0]);
//        Arrays.sort(freqAndOccArr, (a, b) -> Double.compare(a[0], b[0]));
//        System.out.println(Arrays.deepToString(freqAndOccArr));

//        Arrays.sort(freqAndOccArr, java.util.Comparator.<int[]>comparingInt(a -> a[0])
//                .thenComparingInt(a -> a[1]));


        ArrayList<Integer> occs = new ArrayList<Integer>();

        for(int[] p: freqAndOccArr){
            occs.add(p[1]);
        }

        // REMOVING DUPLICATES
        Set<Integer> set = new HashSet<>(occs);
        occs.clear();
        occs.addAll(set);

        int[] occsArr = occs.stream().mapToInt(i -> i).sorted().toArray();


//        System.out.println("SORTED OCCS WITHOUT DUPLICATES");
//        System.out.println(Arrays.toString(occsArr));

















        ArrayList<Integer> outputArr = new ArrayList<>();

        for(int val: occsArr){
            ArrayList<int[]> tempArrList = new ArrayList<>();
            for(int[] pair: freqAndOccArr){
                if(pair[1] == val){
                    tempArrList.add(pair);
                }
            }

            //            System.out.println(Arrays.deepToString(tempArrList.toArray()));

            // convert tempArrList to Array
            int[][] tempArr = new int[tempArrList.size()][2];
            for(int i=0; i<tempArrList.size(); i++){
                tempArr[i] = tempArrList.get(i);
            }

//            System.out.println("TEMPARR BEFORE SORT");
//            System.out.println(Arrays.deepToString(tempArr));
//
            Arrays.sort(tempArr, Comparator.comparingInt(arr -> arr[0]));
//            System.out.println("TEMPARR AFTER SORT");
//            System.out.println(Arrays.deepToString(tempArr));

            for(int k=tempArr.length - 1; k >= 0; k--){
                int tPairVal = tempArr[k][0];
                int tPairOcc = tempArr[k][1];
                for(int j=0; j< tPairOcc; j++){
                    outputArr.add(tPairVal);
                }


            }

//            for(int[] tPair: tempArr){
//                int tPairVal = tPair[0];
//                int tPairOcc = tPair[1];
//                for(int j=0; j< tPairOcc; j++){
//                    outputArr.add(tPairVal);
//                }
//            }


//            System.out.println(Arrays.deepToString(tempArrList.toArray()));
        }

//        System.out.println("FINAL ANSWER");
//        System.out.println(Arrays.toString(outputArr.toArray()));

        int[] finalAnsArr = outputArr.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(finalAnsArr));
        return finalAnsArr;
    }
}

class Tests{
    public static void main(String[] args) {
        int[] firstArr = {1,1,2,2,2,3};
        int[] secondArr = {2,3,1,3,2};
        int[] thirdArr = {-1,1,-6,4,5,-6,1,4,1};

        Solution sol = new Solution();
        sol.frequencySort(firstArr);
        sol.frequencySort(secondArr);
        sol.frequencySort(thirdArr);
    }
}