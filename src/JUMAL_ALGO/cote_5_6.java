package src.JUMAL_ALGO;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class cote_5_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        System.out.println(solution(N,M));

    }

    public static int solution(int princes, int num){
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();

        for(int i=1; i<=princes; i++){
            que.add(i);
        }

        int count=0;
        while(que.size() > 1){
            Integer poll = que.poll();
            count++;

            if(count != num){
                que.add(poll);
            } else {
                count=0;
            }

        }

        answer = que.poll();
        return answer;
    }

}
