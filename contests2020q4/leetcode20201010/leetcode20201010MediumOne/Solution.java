package contests2020q4.leetcode20201010.leetcode20201010MediumOne;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[] roadCount = new int[n];

        for(int[] arr:roads){
            int leftCity = arr[0];
            int rightCity = arr[1];
            roadCount[leftCity] += 1;
            roadCount[rightCity] += 1;
        }

        System.out.println(Arrays.toString(roadCount));

        int[] roadCountCopy = roadCount.clone();
        Arrays.sort(roadCount);

        int greatestCity = roadCount[roadCount.length-1];
        int secondGreatestCity = -1;

        for (int i=0; i<n; i++){
            if(roadCount[i] > secondGreatestCity && roadCount[i] != greatestCity) {
                secondGreatestCity=roadCount[i];
            }

        }
        System.out.println("Greatest city count is " + greatestCity);
//        System.out.println("Second greatest city count is " + secondGreatestCity);

        ArrayList<Integer> greatestOccs = new ArrayList<Integer>();
        ArrayList<Integer> secondOccs = new ArrayList<Integer>();


        for(int j=0; j<n; j++){
            if(roadCount[j] == greatestCity){
                greatestOccs.add(j);
            } else if(roadCount[j] == secondGreatestCity){
                secondOccs.add(j);

            }
        }

        System.out.println("greatOccs is equal to " + Arrays.toString(greatestOccs.toArray()));
        System.out.println("secondOccs is equal to " + Arrays.toString(secondOccs.toArray()));



        // IF greatestOccs > 1,  we choose two greatest cities
        if(greatestOccs.size() > 1){
            firstfor:
            for(int great1: greatestOccs){
                secondfor:
                for(int great2: greatestOccs){
                    int[] oneTowardsTwo = {great1, great2};
                    int[] twoTowardsOne = {great2, great1};
                    thirdfor:
                    for(int[] arr: roads){
                        // IF THIS FOR LOOP FINISHES, WE FOUND A PAIR OF CITIES THAT DOESNT CONNECT
                        if (arr.equals(oneTowardsTwo) || arr.equals(twoTowardsOne)){
                            break secondfor;
                        }
                    }
                    System.out.println("Found two greats that don't share a road, returning val*2");
                    return greatestCity*2;
                }
            }
            System.out.println("Didnt find two greats that dontshare a road, returning val*2 -1");
            return greatestCity + greatestCity - 1;
        }





        // ELSE IF greatstOcs = 1 and secondOccs = 1, chose these two
        else if(greatestOccs.size()==1 && secondOccs.size()==1) {
            int[] oneTowardsTwo = {greatestCity, secondGreatestCity};
            int[] twoTowardsOne = {secondGreatestCity, greatestCity};
            for (int[] arr : roads) {
                if (arr.equals(oneTowardsTwo) || arr.equals(twoTowardsOne)) {
                    System.out.println("found a link between only greatest and only second");
                    return greatestCity + secondGreatestCity - 1;
                }
            }
            System.out.println("No link between only greatest and only second");
            return greatestCity + secondGreatestCity;
        }




        // ELSE IF greatestOcs = 1 and secondOccs > 1, choose the greatest and find out which secondGreatest to choose
        else if(greatestOccs.size()==1 && secondOccs.size()>1){
            for(int secondGreat: secondOccs){
                int[] oneTowardsTwo = {greatestCity, secondGreat};
                int[] twoTowardsOne = {secondGreat, greatestCity};

                for(int[] arr: roads){
                    // IF THIS FOR LOOP FINISHES, WE FOUND A great-secondgreat PAIR THAT DOESNT CONNECT
                    if (arr.equals(oneTowardsTwo) || arr.equals(twoTowardsOne)){
                        break;
                    }
                }
                System.out.println("Found a pair of one and one of the multiple two occs THAT DOESNT SHARE ROAD");
                return greatestCity + secondGreat;
            }
            System.out.println("Didnt find any one-two pairs that didnt connect");
            return greatestCity + secondGreatestCity - 1;

        }







        return 5;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] firstRoads = {{0,1},{0,3},{1,2},{1,3}};
        int[][] secondRoads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};


//        System.out.println("FINAL ANSWER IS " + sol.maximalNetworkRank(4, firstRoads));
        System.out.println("FINAL ANSWER IS " + sol.maximalNetworkRank(5, secondRoads));


    }
}