package src.LEETCODE;

public class leet_200 {
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int answer = 0;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i,j,grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void dfs(int x, int y, char[][] grid) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx< grid.length && ny<grid[0].length) {
                if(grid[nx][ny] == '1' && !visited[nx][ny]) {
                    dfs(nx,ny,grid);
                }
            }
        }
    }
}
