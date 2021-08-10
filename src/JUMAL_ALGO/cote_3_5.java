package src.JUMAL_ALGO;

import java.util.Scanner;

public class cote_3_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution(n));

    }

    public static int solution(int n){
        int answer = 0;
        for(int i=1; i<n/2+1; i++){
            int sum = 0;

            for(int j=i; j<=n/2+1; j++){
                sum += j;
                if(sum > n){
                    break;
                }

                if(sum == n){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
