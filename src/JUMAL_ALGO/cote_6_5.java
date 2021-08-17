package src.JUMAL_ALGO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class cote_6_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        for(int x : solution(n, a)){
            System.out.print(x + " ");
        }

    }

    public static ArrayList<Integer> solution(int n, int[] a){
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.copyOf(a, n)
        Arrays.sort(a);

        for(int i=0; i<n; i++){
            if(tmp[i] != a[i]){
                answer.add(i+1);
            }

            if(answer.size() == 2){
                break;
            }
        }

        return answer;
    }
}
