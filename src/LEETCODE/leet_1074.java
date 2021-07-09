package src.LEETCODE;

import java.util.*;

public class leet_1074 {
    public static void main(String[] args) {

    }

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        HashSet<List> cache = new HashSet<>();

        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                int sum = 0;
                ArrayList<int[][]> matrixList = new ArrayList();

                que.add(matrix[i][j]);
                matrixList.add(new int[i][j]);

                while(!que.isEmpty()){
                    //int queSize = que.size();
                    int poll = que.poll();

                    sum += poll;

                    if(sum == target && !cache.contains(matrixList)){
                        cache.add(matrixList);
                        count++;
                    }

                    for(int k=0; k<4; j++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx>=0 && ny>=0 && nx<rowSize && ny<colSize) {
                            matrixList.add(new int[nx][ny]);
                            que.add(matrix[nx][ny]);
                        }

                    }
                }
            }
        }

        return count;
    }

}
