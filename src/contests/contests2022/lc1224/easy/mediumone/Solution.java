package contests.contests2022.lc1224.easy.mediumone;

class Solution {
    public int takeCharacters(String s, int k) {
        // Greedy algorithm
        int numberOfARemoved = 0;
        int numberOfBRemoved = 0;
        int numberOfCRemoved = 0;
        int numberOfSteps = 0;

        while(numberOfARemoved < k || numberOfBRemoved < k || numberOfCRemoved < k) {
            if (numberOfARemoved < k && s.charAt(0) == 'a') {
                numberOfARemoved++;
                numberOfSteps++;
                s = s.substring(1);
                continue;
            }
            if (numberOfBRemoved < k && s.charAt(0) == 'b') {
                numberOfBRemoved++;
                numberOfSteps++;
                s = s.substring(1);
                continue;
            }
            if (numberOfCRemoved < k && s.charAt(0) == 'c') {
                numberOfCRemoved++;
                numberOfSteps++;
                s = s.substring(1);
                continue;
            }

            if (numberOfARemoved < k && s.charAt(s.length() - 1) == 'a') {
                numberOfARemoved++;
                numberOfSteps++;
                s = s.substring(0, s.length() - 2);
                continue;
            }
            if (numberOfBRemoved < k && s.charAt(s.length() - 1) == 'b') {
                numberOfBRemoved++;
                numberOfSteps++;
                s = s.substring(0, s.length() - 2);
                continue;
            }
            if (numberOfCRemoved < k && s.charAt(s.length() - 1) == 'c') {
                numberOfCRemoved++;
                numberOfSteps++;
                s = s.substring(0, s.length() - 2);
                continue;
            }
            break;
        }

        System.out.println(s);


        // One or Two of the letters is now finished
        int leftIndexA;
        int rightIndexA;
        if (numberOfARemoved < k) {
            leftIndexA = s.indexOf('a');
            rightIndexA = s.indexOf('a');
        }

        return numberOfSteps;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.takeCharacters("aabaaaacaabc", 2);
//        sol.takeCharacters("a", 1);
    }

}
