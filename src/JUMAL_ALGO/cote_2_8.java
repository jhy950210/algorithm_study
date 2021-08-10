package src.JUMAL_ALGO;

import java.util.ArrayList;
import java.util.Scanner;

public class cote_2_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];

        for(int i=0; i<n; i++){
            list[i] = in.nextInt();
        }

        for (int i : solution(n, list)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, int[] list){
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            int count = 1;

            for(int j=0; j<n; j++){
                if(list[j] > list[i]){
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
