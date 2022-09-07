package src.PROGRAMMERS;

import java.util.*;

public class kakao_sum_queue {

    public static void main(String[] args) {
        int[] q1 = {3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};

        System.out.println(solution(q1, q2));
        // result : 2
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0, totalSum = 0;

        for(int i=0; i<queue1.length; i++){
            totalSum += queue1[i] + queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        if(totalSum % 2 != 0) return -1;

        int count = 0;
        while(sum1 != sum2){
            count++;

            if(sum1 > sum2){
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.offer(poll);
            } else {
                int poll = q2.poll();
                sum1 += poll;
                sum2 -= poll;
                q1.offer(poll);
            }

            if( count > queue1.length * 3) return -1;
        }
        answer = count;

        return answer;
    }

}
