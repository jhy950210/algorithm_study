package src.JUMAL_ALGO;

import java.util.Scanner;

public class cote_3_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        System.out.println(solution(n, m, a));

    }

    public static int solution(int n, int m, int[] arr){
        int answer = 0;

        for(int i=0; i<n-m; i++){
            int max = 0;
            int change = m;

            for(int j=i; j<n; j++){
                if(arr[j] == 1){
                    max++;
                } else {
                    if(change > 0){
                        max++;
                        change--;
                    }else{
                        break;
                    }
                }
            }

            answer = Math.max(answer, max);
        }

        return answer;
    }
}
