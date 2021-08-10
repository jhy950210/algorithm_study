package src.PROGRAMMERS;

public class wordchange2 {
    boolean[] visited;
    int answer;

    public int solution(String begin, String target, String[] words) {
        answer = 51;
        visited = new boolean[words.length];

        worddfs(begin, target, 0, words);
        return answer;
    }

    public void worddfs(String now, String target, int count, String[] words){
        if(now.equals(target)){
            answer = answer > count ? count : answer;
            return;
        }

        for(int i=0; i<words.length; i++){
            if(!visited[i] && checkword(now, words[i])) {// 한글자만 차이나는지 비교 checkword
                visited[i] = true;
                worddfs(words[i], target, count+1, words);
                visited[i] = false;
            }
        }

    }

    public boolean checkword(String now, String next){
        int count = 0;

        for(int i=0; i<now.length(); i++){
            if(now.charAt(i) != next.charAt(i)){
                count++;
            }
            if(count > 1){
                return false;
            }
        }

        return true;
    }
}
