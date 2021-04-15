package DFS;

import java.util.Scanner;

/* 유기농 배추 */
public class solution4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("테스트 개수 : ");
		int test = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<test; i++) {
			int n1 = scan.nextInt(), n2 = scan.nextInt(), n3 = scan.nextInt();
			int[][] map = new int[n1][n2];
			
			for(int j=0; j<n3; j++) {
				int n4 = scan.nextInt(), n5 = scan.nextInt();
				map[n4][n5] = 1;
			}
			
			sb.append(dfs(map,0,0,0));
		}
		
		/*
		 * for(int i=0; i< map.length; i++) { for(int j=0; j<map[i].length; j++) {
		 * System.out.println(map[i][j]); } }
		 */
		
		System.out.println(sb);
	}
	
	public static int dfs(int[][] map, int x, int y, int count) {
		if(map[x][y] == 1) {
			count++;
			dfs(map,x+1,y,count);
			dfs(map,x,y+1,count);
			dfs(map,x-1,y,count);
			dfs(map,x,y-1,count);
		}
		return count;
	}

}
