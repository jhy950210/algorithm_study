package src.JUMAL_ALGO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(sol(str));
        br.close();
    }

    public static String sol(String str){
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i=0; i<str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(arr[index] == -1){
                arr[index] = i;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int alpha : arr) {
            answer.append(alpha).append(" ");
        }
        return answer.toString().trim();
    }
}
