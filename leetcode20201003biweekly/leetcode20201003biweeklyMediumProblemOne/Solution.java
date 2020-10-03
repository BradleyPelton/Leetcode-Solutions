package leetcode20201003biweeklyMediumProblemOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// I could write this in python in 10 lines.
// But java has to make EVERYTHING DIFFICULT
// BECAUSE APPARENTLY OCCURENCE ISNT COMMON ENOUGH TO BE IN THE STANDARD LIBRARY???
// I don't understand why I have to make everything from scratch. The same things over and over and over again

// I am well aware my solution is horrible. If I had a python-DefaultDict, this would be a joke.
// But Java likes to make things difficult.

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {

        // Clean Solution would use a list of lists, but I don't have the time

        ArrayList<String> uniqueNames = new ArrayList<String>();
        for(String name: keyName){
            if(!uniqueNames.contains(name)){
                uniqueNames.add(name);
            }
        }
        System.out.println("unique names are" + uniqueNames.toString());

        ArrayList<String> alertNames = new ArrayList<String>();

        ArrayList<String> zeroArr = new ArrayList<String>();
        ArrayList<String> oneArr = new ArrayList<String>();
        ArrayList<String> twoArr = new ArrayList<String>();
        ArrayList<String> threeArr = new ArrayList<String>();
        ArrayList<String> fourArr = new ArrayList<String>();
        ArrayList<String> fiveArr = new ArrayList<String>();
        ArrayList<String> sixArr = new ArrayList<String>();
        ArrayList<String> sevenArr = new ArrayList<String>();
        ArrayList<String> eightArr = new ArrayList<String>();
        ArrayList<String> nineArr = new ArrayList<String>();
        ArrayList<String> tenArr = new ArrayList<String>();
        ArrayList<String> elevenArr = new ArrayList<String>();
        ArrayList<String> twelveArr = new ArrayList<String>();
        ArrayList<String> thirteenArr = new ArrayList<String>();
        ArrayList<String> fourteenArr= new ArrayList<String>();
        ArrayList<String> fifteenArr = new ArrayList<String>();
        ArrayList<String> sixteenArr = new ArrayList<String>();
        ArrayList<String> seventeenArr= new ArrayList<String>();
        ArrayList<String> eighteenArr = new ArrayList<String>();
        ArrayList<String> nineteenArr = new ArrayList<String>();
        ArrayList<String> twentyArr = new ArrayList<String>();
        ArrayList<String> twentyoneArr = new ArrayList<String>();
        ArrayList<String> twentytwoArr = new ArrayList<String>();
        ArrayList<String> twentythreeArr = new ArrayList<String>();




        for(int i=0; i<keyName.length; i++) {
            String currEmployee = keyName[i];
            String currTime = keyTime[i];
            String currHour = currTime.substring(0, 2);

            if(currTime.equals("00:00")){
                twentythreeArr.add(currEmployee);
                continue;
            }
            if (currHour.equals("00") || currTime.equals("01:00")) {
                zeroArr.add(currEmployee);
            } else if (currHour.equals("01") || currTime.equals("02:00")) {
                oneArr.add(currEmployee);
            } else if (currHour.equals("02") || currTime.equals("03:00")) {
                twoArr.add(currEmployee);
            } else if (currHour.equals("03") || currTime.equals("04:00")) {
                threeArr.add(currEmployee);
            } else if (currHour.equals("04") || currTime.equals("05:00")) {
                fourArr.add(currEmployee);
            } else if (currHour.equals("05") || currTime.equals("06:00")) {
                fiveArr.add(currEmployee);
            } else if (currHour.equals("06") || currTime.equals("07:00")) {
                sixArr.add(currEmployee);
            } else if (currHour.equals("07") || currTime.equals("08:00")) {
                sevenArr.add(currEmployee);
            } else if (currHour.equals("08") || currTime.equals("09:00")) {
                eightArr.add(currEmployee);
            } else if (currHour.equals("09")) {
                nineArr.add(currEmployee);
            } else if (currHour.equals("10") || currTime.equals("11:00")) {
                tenArr.add(currEmployee);
            } else if (currHour.equals("11") || currTime.equals("12:00")) {
                elevenArr.add(currEmployee);
            } else if (currHour.equals("12") || currTime.equals("13:00")) {
                twelveArr.add(currEmployee);
            } else if (currHour.equals("13") || currTime.equals("14:00")) {
                thirteenArr.add(currEmployee);
            } else if (currHour.equals("14") || currTime.equals("15:00")) {
                fourteenArr.add(currEmployee);
            } else if (currHour.equals("15") || currTime.equals("16:00")) {
                fifteenArr.add(currEmployee);
            } else if (currHour.equals("16") || currTime.equals("17:00")) {
                sixteenArr.add(currEmployee);
            } else if (currHour.equals("17") || currTime.equals("18:00")) {
                seventeenArr.add(currEmployee);
            } else if (currHour.equals("18") || currTime.equals("19:00")) {
                eighteenArr.add(currEmployee);
            } else if (currHour.equals("19") || currTime.equals("20:00")) {
                nineteenArr.add(currEmployee);
            } else if (currHour.equals("20") || currTime.equals("21:00")) {
                twentyArr.add(currEmployee);
            } else if (currHour.equals("21") || currTime.equals("22:00")) {
                twentyoneArr.add(currEmployee);
            } else if (currHour.equals("22") || currTime.equals("23:00")) {
                twentytwoArr.add(currEmployee);
            } else if (currHour.equals("23") || currTime.equals("00:00")) {
                twentythreeArr.add(currEmployee);
            }
        }


        for(String llamo: tenArr){
            int occ = Collections.frequency(zeroArr,llamo);
            if(occ > 2){
                alertNames.add(llamo);

            }
        }

        System.out.println(Arrays.toString(tenArr.toArray()));
        System.out.println(alertNames);







        List<String> dum = new ArrayList<String>();
        return dum;





    }
}

class Tests{
    public static void main(String[] args) {
        String[] firstNames = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] firstTimes= {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        Solution sol = new Solution();
        sol.alertNames(firstNames,firstTimes);
    }
}