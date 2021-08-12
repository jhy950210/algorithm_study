package src.JUMAL_ALGO;

import java.util.*;

public class cote_5_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] a = new int[N];
        for(int i=0; i<N; i++){
            a[i] = in.nextInt();
        }

        System.out.println(solution(N,M,a));

    }

    public static int solution(int N, int M, int[] arr) {
        int answer = 0;
        Queue<Person> que = new LinkedList<>();

        for(int i=0; i<N; i++){
            que.add(new Person(i, arr[i]));
        }

        while(!que.isEmpty()){
            Person poll = que.poll();

            for (Person person : que) {
                if(poll.priority < person.priority){
                    que.add(poll);
                    poll = null;
                    break;
                }
            }

            if(poll!=null){
                answer++;
                if(poll.idx == M){
                    return answer;
                }
            }

        }

        return answer;
    }

    static class Person{
        int idx;
        int priority;

        Person(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }

}
