package DFS;

import java.util.Scanner;

/* 바이러스 */
public class solution5 {
	static boolean[] visit;
	static boolean[][] graph;
	static int count = 0;
	static int N , M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("컴퓨터 수 입력");
		N = scan.nextInt();
		System.out.println("연결된 컴퓨터 수 입력");
		M = scan.nextInt();
		
		graph = new boolean[N][N];
		visit = new boolean[N];
		
		for(int i=0; i<M; i++) {
			int n1 = scan.nextInt(), n2 = scan.nextInt();
			
			graph[n1][n2] = graph[n2][n1] = true;
		}
		
		System.out.println(sol(1));
	}
	
	public static int sol(int start) {
		visit[start] = true;
		
		for(int i=0; i<M; i++) {
			if(graph[start][i] == true && visit[i] == false) {
				count++;
				sol(i);
			}
		}
		
		return count;
	}

}
