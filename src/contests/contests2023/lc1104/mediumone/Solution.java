package contests.contests2023.lc1104.mediumone;

// Accepted after 10 minutes
// Graph theory problem but with not a graph theory solution
// trivial array solution


class Solution {
    public int findChampion(int n, int[][] edges) {

        int[] candidates = new int[n];

//        Map<Integer, List<Integer>> isBeterThanMap = new HashMap<>();

        for(int[] edge : edges) {
//            if (isBeterThanMap.containsKey(edge[0])) {
//                isBeterThanMap.get(edge[0]).add(edge[1]);
//            } else {
//                List<Integer> temp = new ArrayList<>();
//                temp.add(edge[1]);
//                isBeterThanMap.put(edge[0], temp);
//            }
            candidates[edge[1]] = -1;
        }

        int victor = -1;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != -1) {
                if (victor != -1) {
                    System.out.println("multiple victors");
                    return -1;
                } else {
                    victor = i;
                }
            }
        }
        System.out.println("victor = " + victor);
        return victor;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findChampion(3, new int[][]{{0,1},{1,2}});
        sol.findChampion(4, new int[][]{{0,2},{1,3},{1,2}});

    }
}
