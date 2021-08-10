package src.JUMAL_ALGO;

import java.util.*;

public class cote_3_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];


        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] b = new int[m];

        for(int i=0; i<m; i++){
            b[i] = in.nextInt();
        }
        for (int i : solution(a,b)) {
            System.out.print(i + " ");
        }

    }

    public static int[] solution( int[] arr1, int[] arr2){
        int[] answer = new int[arr1.length + arr2.length];

        System.arraycopy(arr1,0,answer,0,arr1.length);
        System.arraycopy(arr2,0,answer,arr1.length,arr2.length);
        Arrays.sort(answer);

        return answer;
    }
}
