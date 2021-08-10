package src.JUMAL_ALGO;

import java.util.Scanner;

public class cote_3_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        System.out.println(solution(n,m,a));

    }

    public static int solution(int n, int m, int[] arr){
        int answer = 0;

        for(int i=0; i<n; i++){
            int sum = 0;

            for(int j=i; j<n; j++){
                sum += arr[j];

                if(sum > m){
                    break;

                }
                if(sum == m){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
