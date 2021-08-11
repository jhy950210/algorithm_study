package src.JUMAL_ALGO;

import java.util.*;

public class cote_4_5 {
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
        int answer = -1;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    set.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }

        int count = 0;
        for (int num : set) {
            count++;
            if(count == m){
                return num;
            }
        }

        return answer;
    }
}
