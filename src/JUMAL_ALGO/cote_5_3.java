package src.JUMAL_ALGO;

import java.util.Scanner;
import java.util.Stack;

public class cote_5_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] a = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                a[i][j] = in.nextInt();
            }
        }

        int M = in.nextInt();
        int[] b = new int[M];

        for(int i=0; i<M; i++){
            b[i] = in.nextInt();
        }

        System.out.println(solution(N,M,a,b));

    }

    public static int solution(int N, int M, int[][] board, int[] moves){
        Stack<Integer> stk = new Stack<>();
        int count = 0;

        for (int move : moves) {
            for(int i=0; i<N; i++){
                int doll = board[i][move-1];
                board[i][move-1] = 0;

                if(doll != 0){
                    if(!stk.isEmpty() && stk.peek() == doll){
                        stk.pop();
                        count += 2;
                        break;
                    } else {
                        stk.push(doll);
                        break;
                    }

                }
            }


        }
        return count;
    }
}
