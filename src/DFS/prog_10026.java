package src.DFS;

public class prog_10026 {
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) {

    }

    public static void dfs(int x, int y, char[][] draw){
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<5 && ny<5) {
                if(draw[x][y] == draw[nx][ny] && !visited[nx][ny]){
                    dfs(nx,ny,draw);
                }
            }

        }
    }
}
