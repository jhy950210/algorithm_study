package src.JUMAL_ALGO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<count; i++){
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }
        System.out.println(sol(arr));
        br.close();
    }

    public static int sol(ArrayList<Integer> arr){
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i) == 0){
                arr.remove(i);
                arr.remove(i-1);
                i -= 2;
            }
        }

        for (Integer integer : arr) {
            sum += integer;
        }

        return sum;
    }
}
