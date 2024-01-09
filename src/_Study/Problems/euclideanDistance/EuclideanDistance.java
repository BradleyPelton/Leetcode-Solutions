package _Study.Problems.euclideanDistance;

public class EuclideanDistance {
    // Math.hypot prevents overflow
    private double euclideanDistance(int[] coord1, int[] coord2) {
        return Math.hypot(coord1[0] - coord2[0], coord1[1] - coord2[1]);
    }

//    private double euclideanDistance(int[] coord1, int[] coord2) {
//        return Math.sqrt(Math.pow(coord1[0] - coord2[0], 2) + Math.pow(coord1[1] - coord2[1], 2));
//    }
}
