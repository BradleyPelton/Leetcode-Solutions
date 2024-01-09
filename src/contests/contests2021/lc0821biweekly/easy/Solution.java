package contests.contests2021.lc0821biweekly.easy;


// Accepted after 15 minutes

// I fumbled around with char converion again

// for some reason 'a' - '0'  is 49???? i though 'a' = '97'
// investigate

class Solution {
    public int minTimeToType(String word) {

        int currPos = 0;

        // a = '49'
        // z = '74'

//        Map<Character, Integer> charToVal = new HashMap<>();



        int totalTime = 0;
        for (char letter : word.toCharArray()) {

            int letterVal = letter - 97;
//            System.out.println(letter);
//            System.out.println(letterVal);

            int distanceGoingForward = ((letterVal - currPos) + 26) % 26;
            int distanceGoingBackward = ((currPos - letterVal) + 26) % 26;

            int trueDistance = Math.min(Math.abs(distanceGoingBackward), Math.abs(distanceGoingForward));
//            System.out.println("true distance is " + trueDistance);

            totalTime += trueDistance;  // INCREMENT FOR TRAVERSAL
            totalTime++;  // INCREMENT FOR "write" operation

            currPos = letterVal;
//            System.out.println("curr position is " + currPos);
        }

        System.out.println("final ans " + totalTime);
        return totalTime;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minTimeToType("abc");
        sol.minTimeToType("bza");
        sol.minTimeToType("zjpc");






    }
}