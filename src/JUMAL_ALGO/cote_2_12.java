package src.JUMAL_ALGO;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class cote_2_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] list = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                list[i][j] = in.nextInt();
            }
        }

        System.out.print(solution(n, m, list));

    }

    public static int solution(int n, int m, int[][] list){
        int answer = 0;


        for(int i=0; i<n; i++){
            int num = list[0][i];
            Set<Integer> set = new HashSet<>();

            for(int x=i+1; x<n; x++){
                set.add(list[0][x]);
            }

            for(int j=1; j<m; j++){
                for(int k=0; k<n; k++) {
                    if(list[j][k] != num){
                        set.remove(list[j][k]);
                    } else{
                        break;
                    }
                }
            }
            answer += set.size();
        }

        return answer;
    }
}
