package src.JUMAL_ALGO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class cote_4_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int i : solution(n,m,a)) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    public static ArrayList<Integer> solution(int n, int m, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n-m+1; i++){
            HashSet<Integer> tmp = new HashSet<>();

            for(int j=i; j<i+m; j++){
                tmp.add(arr[j]);
            }

            answer.add(tmp.size());
        }
        return answer;
    }
}
