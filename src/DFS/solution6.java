package DFS;

import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 섬의 개수 */
public class solution6 {
	public static int[][] map;
	public static final int[] dx = {-1,1,0,0,-1,1,-1,1};
	public static final int[] dy = {0,0,-1,1,1,1,-1,-1};
	static boolean[][] visited;
	static int count = 0;
	static int w,h;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("너비 : ");
		w = scan.nextInt();
		
		System.out.print("높이 : ");
		h = scan.nextInt();
		
		map = new int[h][w];
		visited = new boolean[h][w];
		
		for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
            	map[i][j] = scan.nextInt();
            }
		}
		
		for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
            	if(map[i][j] == 1 && !visited[i][j]) {
            		count++;
            		dfs(i,j);
            	}
            }
		}
		
		System.out.println(count);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<h && ny<w) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
	
}
