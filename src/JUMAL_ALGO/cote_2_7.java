package src.JUMAL_ALGO;

import java.util.Scanner;

public class cote_2_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];

        for(int i=0; i<n; i++){
            list[i] = in.nextInt();
        }

        System.out.println(solution(n, list));
    }

    public static int solution(int n, int[] list){
        int count = 0;
        int answer = 0;

        for(int i=0; i<n; i++){
            if(list[i] == 1){
                count++;
                answer += count;
            } else {
                count = 0;
            }
        }

        return answer;
    }
}
