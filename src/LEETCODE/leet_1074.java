package src.LEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leet_1074 {
    public static void main(String[] args) {

    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        int sum = 0;

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        //int[] cache = new int[size+1];

        que.add(matrix[0][0]);

        while(!que.isEmpty()){
            int queSize = que.size();
            int poll = que.poll();

            for(int i=0; i<queSize; i++){
                sum += poll;

                if(sum == target){
                    count++;
                }

                if(int r < rowSize && int c < colSize){

                }
            }
        }

        return 0;
    }
}
