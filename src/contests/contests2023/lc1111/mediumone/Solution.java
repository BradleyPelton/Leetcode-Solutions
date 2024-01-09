package contests.contests2023.lc1111.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Accepted after 20 mintes
// First two answer Wrong answer
// Careless edge case handling. Missing a break.

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {

        Map<String, List<Integer>> accessTimesMap = new HashMap<>();

        for (List<String> accessTime : access_times) {
            String person = accessTime.get(0);
            String time = accessTime.get(1);
            if (!accessTimesMap.containsKey(person)) {
                accessTimesMap.put(person, new ArrayList<>());
            }
            accessTimesMap.get(person).add(timeConverter(time));
        }

        List<String> highAccessUsers = new ArrayList<>();
        for (String person : accessTimesMap.keySet()) {
            List<Integer> userTimes = accessTimesMap.get(person);
            Collections.sort(userTimes);
            for (int i = 2; i < userTimes.size(); i++) {
                if (userTimes.get(i) - userTimes.get(i - 2) < 100) {
                    highAccessUsers.add(person);
                    break;
                }
            }
        }

        System.out.println(highAccessUsers);
        return highAccessUsers;

    }

    private int timeConverter(String time) {
        if (time.startsWith("0")) {
            time = time.substring(1);
        }
        return Integer.parseInt(time);
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] inputOne = {{"a","0549"},{"b","0457"},{"a","0532"},{"a","0621"},{"b","0540"}};
        String[][] inputTwo = {{"d","0002"},{"c","0808"},{"c","0829"},{"e","0215"},{"d","1508"},{"d","1444"},{"d","1410"},{"c","0809"}};
        String[][] inputThree = {{"cd","1025"},{"ab","1025"},{"cd","1046"},{"cd","1055"},{"ab","1124"},{"ab","1120"}};
        String[][] inputFour = {{"wjmqm","0442"},{"wjmqm","0504"},{"r","0525"},{"va","0436"},{"r","0440"},{"va","0505"},{"va","0509"},{"r","0515"},{"r","0414"}};
        String[][] inputFive = {{"dz","0719"},{"dz","0726"},{"dz","0716"},{"dz","0716"}};

        List<List<String>> inputOneAsList = Arrays.stream(inputOne).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> inputTwoAsList = new ArrayList<>();
        List<List<String>> inputThreeAsList = new ArrayList<>();
        List<List<String>> inputFourAsList = new ArrayList<>();
        List<List<String>> inputFiveAsList = new ArrayList<>();

        for (String[] arr : inputTwo) {
            inputTwoAsList.add(Arrays.asList(arr));
        }
        for (String[] arr : inputThree) {
            inputThreeAsList.add(Arrays.asList(arr));
        }
        for (String[] arr : inputFour) {
            inputFourAsList.add(Arrays.asList(arr));
        }
        for (String[] arr : inputFive) {
            inputFiveAsList.add(Arrays.asList(arr));
        }
        sol.findHighAccessEmployees(inputOneAsList);
        sol.findHighAccessEmployees(inputTwoAsList);
        sol.findHighAccessEmployees(inputThreeAsList);
        sol.findHighAccessEmployees(inputFourAsList);  //expected ["va","r"]
        sol.findHighAccessEmployees(inputFiveAsList);  //expected [["dz"]]



    }
}
