package DFS;

import java.util.Arrays;
import java.util.Scanner;

/* 단지번호 붙이기 - 백준 2667번 */
public class solution3 {
	static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int apartNum = 0;
	static int[] aparts;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		aparts = new int[N];
		
		for(int i=0; i<N; i++) {
			String str = scan.next();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    apartNum++;
                    dfs(i,j);
                }
            }
        }
		
		Arrays.sort(aparts);
		System.out.println(apartNum);
		
		for(int i=0; i<aparts.length; i++) {
			if(aparts[i] != 0) {
				System.out.println(aparts[i]);
			}
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		aparts[apartNum]++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
}
