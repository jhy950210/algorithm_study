package src.LEETCODE;

public class leet_48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int s = 0, e = matrix.length - 1;

        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[i].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }


}
