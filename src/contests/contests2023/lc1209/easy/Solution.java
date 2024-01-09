package contests.contests2023.lc1209.easy;

// Accepted after 2 minutes
// Trivial

class Solution {
    public int countTestedDevices(int[] batteryPercentages) {

        int numberOfDevicesTested = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                numberOfDevicesTested++;
                for (int j = i + 1; j < batteryPercentages.length; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);

                }
            }

        }
        System.out.println(numberOfDevicesTested);
        return numberOfDevicesTested;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countTestedDevices(new int[]{1,1,2,1,3});
        sol.countTestedDevices(new int[]{0,1,2});




    }
}
