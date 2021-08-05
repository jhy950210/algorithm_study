package src.PROGRAMMERS;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class trippath {
    static int length;
    static String[] answer;
    static boolean[] visited;
    static List<String> path = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        length = tickets.length;
        visited = new boolean[tickets.length];

        path.add("ICN");
        tripdfs("ICN", 1, tickets);

        return answer;
    }

    public static void tripdfs(String start, int count, String[][] tickets){
        if(count == length+1){
            for(int i=0; i< count; i++){
                answer[i] = path.get(i);
            }
            return;
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        for(int i=0; i<length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                pq.add(tickets[i][1]);
            }
        }

        for(int i=0; i<length; i++){
            if(!visited[i] && tickets[i][0].equals(start) && tickets[i][1].equals(pq.peek()) ){
                visited[i] = true;
                break;
            }
        }

        path.add(pq.peek());
        tripdfs(pq.poll(), count+1, tickets);
    }
}
