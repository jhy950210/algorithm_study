package src.baekjoon;

import java.util.Scanner;

public class bj_11403 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 정수

        int[][] graph = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                graph[i][j] = scan.nextInt();
            }
        }

        // i → k → j
        // k : 거쳐가는 노드
        for(int k=0; k<N; k++) {
            // i : 출발 노드
            for(int i=0; i<N; i++) {
                // j : 도착 노드
                for(int j=0; j<N; j++) {
                    if(graph[i][k] ==1 && graph[k][j] ==1) {
                        graph[i][j] =1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

}
