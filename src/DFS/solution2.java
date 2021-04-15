package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* DFS와 BFS - 백준 1260번 */
public class solution2 {
	static boolean[][] map;
	static boolean[] visited;
	static int n,m,v;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
		
		map = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i< m; i++) {
			int x = scan.nextInt(), y = scan.nextInt();
			
			map[x][y] = map[y][x] = true;
		}
		
		dfs(v);
		
		visited = new boolean[n+1];
		System.out.println();
		
		bfs(v);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for(int i=1; i<=n; i++) {
			if(map[start][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		visited[start] = true;
		System.out.print(start + " ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=1; i<=n; i++) {
				if(map[temp][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
		
	}

}
