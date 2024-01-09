package contests.contests2021.lc1120.mediumone;

// Accepted second try

// Sloppy, forget to refill currentCapacity
// Pretty easy problem for a medium. Accepted after 13 minutes

class Solution {
    public int wateringPlants(int[] plants, int capacity) {

        int numberOfSteps = 1;
        int currentCapacity = capacity - plants[0];
        for (int i = 1; i < plants.length; i++) {
            int waterNeededForNextPlant = plants[i];
            if (currentCapacity >= waterNeededForNextPlant) {
                numberOfSteps++;
                currentCapacity -= waterNeededForNextPlant;
            } else {
                numberOfSteps += (2 * i) + 1;
                currentCapacity = capacity - waterNeededForNextPlant;
            }
        }


        System.out.println("final ans = " + numberOfSteps);
        return numberOfSteps;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.wateringPlants(new int[]{2,2,3,3}, 5);
        sol.wateringPlants(new int[]{1,1,1,4,2,3}, 4);
        sol.wateringPlants(new int[]{7,7,7,7,7,7,7}, 8);

        sol.wateringPlants(new int[]{3,2,4,2,1}, 6);  // expected 17

    }
}
