package LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class leet_994 {
	public static final int[] dx = {-1,1,0,0};
	public static final int[] dy = {0,0,-1,1};
	static int count = 0;
	static int totalOrange = 0;
	static int time = 0;
	static int tmp = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid1 = {{2,1,1},{0,1,1},{1,0,1}};
		int[][] grid2 = {{0,2}};
		int[][] grid3 = {{2,1,1},{1,1,0},{0,1,1}};
		
		//System.out.println(orangesRotting(grid1));
		System.out.println(orangesRotting(grid3));
	}

	public static int orangesRotting(int[][] grid) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == 2) {
					que.add(new int[] {i,j});
					totalOrange++;
				} else { 
					if(grid[i][j] == 1) {
						totalOrange++;
					}
				}
				
			}
		}
		
		count = que.size();
		// 오렌지가 없는 경우 
		if(totalOrange == 0) {
			return 0;
		}
		
		while(!que.isEmpty()) {
			int repSize = que.size(); // 사이즈가 고정되어야..
			
			if(totalOrange == count) {
				return time;
			}
			
			time++;
			
			for(int rep=0; rep<repSize; rep++) { // 한 번에 여러 개의 오렌지가 감염을 시작할 수 있기 떄문
				int[] peek = que.peek();
				int x = peek[0];
				int y = peek[1];
				
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length) {
						if(grid[nx][ny] == 1) {
							grid[nx][ny] = 2;
							que.add(new int[] {nx,ny});
							count++;
						}
					}
					
				}
				
				que.poll();
			}
			
		}
		
        return -1;
    }

	
}
