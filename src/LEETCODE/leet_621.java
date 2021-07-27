package src.LEETCODE;

import java.util.*;

public class leet_621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        System.out.println(leastInterval(tasks,n));
    }
    public static int leastInterval(char[] tasks, int n) {
        // 1. greedy
        // 2. 중복 체크

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<tasks.length; i++){
            map.put(tasks[i],map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)-> b-a);

        que.addAll(map.values());

        int res = 0;
        while(!que.isEmpty()){
            List<Integer> checkRemain = new ArrayList<>();
            int time = 0;

            for(int i=0; i< n+1; i++){
                if(!que.isEmpty()){
                    checkRemain.add(que.poll());
                    time++;
                }

            }

            for(int remain : checkRemain){
                if(--remain > 0){
                    que.add(remain);
                }
            }

            res += que.isEmpty() ? time : n+1;
        }

        return res;
    }

}
