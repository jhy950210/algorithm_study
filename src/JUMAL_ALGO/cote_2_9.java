package src.JUMAL_ALGO;

import java.util.Scanner;

public class cote_2_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] list = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                list[i][j] = in.nextInt();
            }
        }

        System.out.print(solution(n, list));

    }

    public static int solution(int n, int[][] list){
        int answer = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int rowSum = 0, colSum = 0;

            for(int j=0; j<n; j++){
                rowSum += list[i][j];
                colSum += list[j][i];
            }
            answer = Math.max(answer, rowSum);
            answer = Math.max(answer, colSum);
        }

        int rowSum = 0, colSum = 0;
        for(int i=0; i<n; i++){
            rowSum += list[i][i];
            colSum += list[i][n-i-1];

        }

        answer = Math.max(answer, rowSum);
        answer = Math.max(answer, colSum);


        return answer;
    }
}
