import java.util.ArrayList;
import java.util.Arrays;

// MY FIRST JAVA SOLUTION ACCEPTED!!!
// Glorious day! Now all I need to do is return to my previous glory with python



class Solution {
    public static int numSpecial(int[][] mat) {

        ArrayList<Integer> goodRows = new ArrayList<Integer>();

        // GOOD ROWS
        for(int i=0; i < mat.length; i++){
            int rowSum = 0;
            for (int j=0; j < mat[i].length; j++){
//                System.out.println(mat[i][j]);
                if(mat[i][j] == 1){
                    rowSum++;
                }
            }
//            System.out.println("row sum for " + i + " is " + rowSum);
            if(rowSum == 1){
//                System.out.println("found a good row " + i);
                goodRows.add(i);
            }
        }

        int ans = 0;

        ArrayList<Integer> goodColumns = new ArrayList<Integer>();


        // GOOD COLUMNS
        for(int j=0; j< mat[0].length; j++){
            int columnSum = 0;
            for(int k=0; k< mat.length; k++){
//                System.out.println(mat[k][j]);
                columnSum += mat[k][j];
            }
            if(columnSum==1){
//                System.out.println("found a good column " + j);
                goodColumns.add(j);
            }
        }

        for(int e: goodRows){
            for (int r: goodColumns){
                if(mat[e][r]==1){
                    ans++;
                }
            }}

        System.out.println("final answer is " + ans);
        return ans;

    }


    public static void main(String[] args) {
//        int[][] firstExample = {{1,0,0},{0,0,1},{1,0,0}};
//        int v = numSpecial(firstExample);
//        System.out.println(v);
//        int[][] lastExample = {{0,0,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
//        int c = numSpecial(lastExample);
//        System.out.println(c);
        int[][] otherExample = int[[0,0,0,1],[1,0,0,0],[0,1,1,0],[0,0,0,0]]
    }
}
