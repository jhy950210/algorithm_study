package src.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordchange {
    int answer = 51;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.asList(words);
        visited = new boolean[words.length];

        if(!wordList.contains(target)){
            return 0;
        }

        worddfs(target,begin,0,words);

        return answer;
    }

    public void worddfs(String target, String now, int count, String[] words){
        if(target.equals(now)){
            answer = answer > count ? count: answer;
            return;
        }

        for(int i=0; i<words.length; i++){
            if(!visited[i] && check(now, words[i])){
                visited[i] = true;
                worddfs(target, words[i], count+1, words);
                visited[i] = false;
            }
        }
    }

    public boolean check(String now, String next){
        int count = 0;
        for(int i=0; i<now.length(); i++){
            if(now.charAt(i) != next.charAt(i)){
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}
