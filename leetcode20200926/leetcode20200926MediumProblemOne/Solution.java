package leetcode20200926MediumProblemOne;

// Accepted after first attempt
// FIRST JAVA MEDIUM PROBLEM SOLVED!!!!!
// Not a hard problem, just a lot of variables to keep track of.
// I could probably have done this in any language. I took longer to understand the problem than to implement
// an answer.


class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int currentNumberOfWaiting = 0;
        int currentRevenue = 0;

        int maxRevenue = 0;
        int maxRevenueRotation = -1;

        int i = 0;
        while (currentNumberOfWaiting > 0 || i < customers.length) {
//            System.out.println(customers[i]);
            currentRevenue -= runningCost;
            if(i < customers.length){
                currentNumberOfWaiting += customers[i];
            }

            if (currentNumberOfWaiting > 4) {
                currentRevenue += 4*boardingCost;
                currentNumberOfWaiting -= 4;
            } else {
                currentRevenue += currentNumberOfWaiting * boardingCost;
                currentNumberOfWaiting = 0;
            }

//            System.out.printf("Current number of waiting AFTER rotation " + i + " is " + currentNumberOfWaiting);
//            System.out.printf(". Current revenue is " + currentRevenue);
//            System.out.println(" ");


            if(currentRevenue > maxRevenue){
                maxRevenue = currentRevenue;
                maxRevenueRotation = i;
            }

            i++;

        }

//        System.out.println("Optimal answer is " + maxRevenueRotation);

        int ans;
        if(maxRevenueRotation==-1){
            ans = -1;
        } else {
            ans = maxRevenueRotation + 1;
        }
        System.out.println(ans);
        return ans;


    }
}

class TestExamples{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] firstCustomers = {8,3};
        sol.minOperationsMaxProfit(firstCustomers,5,6);

        int[] secondCustomers = {10,9,6};
        sol.minOperationsMaxProfit(secondCustomers,6,4);

        int[] thirdCustomers = {3,4,0,5,1};
        sol.minOperationsMaxProfit(thirdCustomers,1,92);

        int[] fourthCustomers = {10,10,6,4,7};
        sol.minOperationsMaxProfit(fourthCustomers,3,8);
    }


}