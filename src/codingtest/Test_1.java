package src.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 로봇 청소기
public class Test_1
{
    static int[] dx = {-1, 0, 1, 0};  // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};  

    static int dir;

    static int[][] map;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        map = new int[N][N];
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int x = 0;
        int y = 0;
        dir = 0;
        map[x][y] = 1;
        int nextDir = 1; // 1: right, -1: left

        for(int i=0; i<N*N - 1; i++){
            int rlx = dx[(dir + nextDir) % 4] + x;
            int rly = dy[(dir + nextDir) % 4] + y;
            
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;

            if(map[rlx][rly] == 0) {      // go rlx
                map[rlx][rly] = map[x][y] + 1;
                x = rlx;
                y = rly;
                dir = (dir + nextDir) % 4;
                
            }
            else if(nx >= 0 && ny >= 0){
            	map[nx][ny] = map[x][y] + 1;
                x = nx;
                y = ny;
            }
            else {
            	nextDir += 2;
            	rlx = dx[(dir + nextDir) % 4] + x;
                rly = dy[(dir + nextDir) % 4] + y;
                map[rlx][rly] = map[x][y] + 1;
                x = rlx;
                y = rly;
                dir = (dir + nextDir) % 4;
            }
        }
        
        for(int k=0; k<N; k++) {
        	System.out.println(Arrays.toString(map[k]));
        }
        
        System.out.println(map[r][c]);
    }
}
