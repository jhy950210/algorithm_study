package PROGRAMMERS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 기능개발 */
public class solution11 {
    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] s = {1, 30, 5};

        for(int i : solution(p,s)){
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            int cnt = 0;

            while(true){
                progresses[i] += speeds[i];
                cnt++;

                if(progresses[i] >= 100){
                    que.add(cnt);
                    break;
                }
            }
        }

        int res = que.poll(); // 첫 기능 개발 기간
        int answerCnt = 1;

        while(!que.isEmpty()){
            if(res >= que.peek()){
                que.poll();
                answerCnt++;
                if(que.isEmpty()){
                    answerList.add(answerCnt);
                }
            } else {
                answerList.add(answerCnt);
                answerCnt = 0;
                res = que.peek();
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
