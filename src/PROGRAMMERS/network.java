package src.PROGRAMMERS;

public class network {
    static boolean[][] visited;

    public static void main(String[] args) {
        int n = 3;
        int[][] com = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(solution(3,com));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            if(!visited[i][i]){
                networkdfs(i,n,computers);
                answer++;
            }
        }

        return answer;
    }

    public static void networkdfs(int start, int n, int[][] computers){
        for(int i=0; i<n; i++){
            if(!visited[start][i] && computers[start][i] == 1){
                visited[start][i] = visited[i][start] = true;
                networkdfs(i, n, computers);
            }
        }
    }


}
