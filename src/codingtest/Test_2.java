package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 12345 -> 21 21 28
// 연료 탱크 설계
public class Test_2 {
	
	static boolean[][][] visited;
	static int N, minSize;
	static int[] answer;
	
	static void dfs(int x, int y, int z) {
		visited[x][y][z] = true;
		
		if(x * y * z >= N) {
			if(minSize > x*y * 2 + y*z * 2 + z*x * 2) {
				minSize = x*y * 2 + y*z * 2 + z*x * 2;
				answer[0] = x;
				answer[1] = y;
				answer[2] = z;
			}
			else if(minSize == x*y * 2 + y*z * 2 + z*x * 2) {
				if(answer[0] < x) ;
				else if(answer[0] == x) {
					if(answer[1] < y) ;
					else if(answer[1] == y) {
						if(answer[2] < z) ;
						else {
							answer[0] = x;
							answer[1] = y;
							answer[2] = z;
						}
					}
					else {
						answer[0] = x;
						answer[1] = y;
						answer[2] = z;
					}
				}
				else {
					answer[0] = x;
					answer[1] = y;
					answer[2] = z;
				}
			}
		}
		
		if(x >= 50 || y >= 50 || z >= 50) return;
		
		if(!visited[x + 1][y][z]) dfs(x + 1, y, z);
		if(!visited[x][y + 1][z]) dfs(x, y + 1, z);
		if(!visited[x][y][z + 1]) dfs(x, y, z + 1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[51][51][51];
		minSize = Integer.MAX_VALUE;
		answer = new int[3];
		
		dfs(0, 0, 0);
		
		System.out.println(Arrays.toString(answer));
	}
}
