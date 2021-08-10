package src.JUMAL_ALGO;

import java.util.Scanner;

public class cote_2_10 {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};

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
        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                int tmp = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (list[i][j] <= list[nx][ny]) {
                            tmp = 0;
                            break;
                        } else {
                            tmp = 1;
                        }
                    }
                }

                answer += tmp;
            }
        }
        return answer;
    }
}
