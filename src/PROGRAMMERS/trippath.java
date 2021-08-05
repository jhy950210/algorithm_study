package src.PROGRAMMERS;

import java.util.*;

public class trippath {
    String[] answer;
    boolean[] visited;
    List<String> answers = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        visited = new boolean[tickets.length];

        tripdfs(0,"ICN", "ICN", tickets);
        Collections.sort(answers);
        answer = answers.get(0).split(" ");

        return answer;
    }

    public void tripdfs(int count, String present, String answer, String[][] ticktes) {
        if(count == ticktes.length) {            //모든 공항을 들렸다면
            answers.add(answer);                //answers에 추가
            return;
        }

        for(int i = 0; i < ticktes.length; i++) {
            if(!visited[i] && ticktes[i][0].equals(present)) {        //present와 같고 들리지 않은 공항을 찾고
                visited[i] = true;                                    //해당 공항을 들린걸로 만듬.
                tripdfs(count+1, ticktes[i][1],answer+" "+ticktes[i][1] , ticktes);    //카운트 +1 도착 공항을 present로 넣어주고 answer에 도착공항을 추가해준다.
                visited[i] = false;
            }
        }
        return;
    }

}
