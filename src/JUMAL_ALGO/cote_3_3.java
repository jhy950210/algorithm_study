package src.JUMAL_ALGO;

import java.util.*;

public class cote_3_3 {
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

        for(int i=0; i<m; i++){
            answer += arr[i];
        }

        int sum = answer;
        for(int i=m; i<arr.length; i++){
            sum += arr[i] - arr[i-m];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
