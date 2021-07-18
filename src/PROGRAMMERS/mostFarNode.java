package src.PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class mostFarNode {
    public static void main(String[] args) {
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n = 6;

        System.out.println(solution(n, vertex));
    }

    public static int solution(int n, int[][] edge) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        visited[1] = true;
        for(int i=0; i< edge.length; i++){
            if(edge[i][0] == 1){
                que.add(edge[i][1]);
                visited[edge[i][1]] = true;
            }
            if(edge[i][1] == 1){
                que.add(edge[i][0]);
                visited[edge[i][0]] = true;
            }
        }

        int size = 0;

        while(!que.isEmpty()){
            size = que.size();

            for(int i=0; i<size; i++){
                int poll = que.poll();

                for(int j=0; j< edge.length; j++){
                    if(edge[j][0] == poll && !visited[edge[j][1]]){
                        que.add(edge[j][1]);
                        visited[edge[j][1]] = true;
                    }
                    if(edge[j][1] == poll && !visited[edge[j][0]]){
                        que.add(edge[j][0]);
                        visited[edge[j][0]] = true;
                    }
                }
            }
        }

        return size;
    }

}
