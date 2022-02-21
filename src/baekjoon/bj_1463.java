package src.baekjoon;

import java.util.Scanner;

public class bj_1463 {

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 정수

        solution(N, 0);

        System.out.println("ans = " + ans);
    }

    public static void solution(int x, int count){
        if(x == 1) {
            ans = Math.min(ans, count);
            return;
        }

        if(x % 3 == 0){
            solution(x / 3, count+1);
        }

        if(x % 2 == 0){
            solution(x / 2, count+1);
        }

        solution(x-1, count+1);
    }
}
