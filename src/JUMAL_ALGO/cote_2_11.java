package src.JUMAL_ALGO;

import java.util.*;

public class cote_2_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] list = new int[n][5];

        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                list[i][j] = in.nextInt();
            }
        }

        System.out.print(solution(n, list));

    }

    public static int solution(int n, int[][] list){
        int stuNum = -1; //학생 번호
        int max = -1; //같은 반이 된 최대 횟수
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < 5; k++) {
                    if (list[i][k] == list[j][k]) {
                        count++; break; //핵심
                    }
                }
            }
            if (count > max) {
                max = count; stuNum = i + 1;
            }
        }
        return stuNum;

    }
}
