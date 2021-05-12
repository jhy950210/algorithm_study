package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/* 더 맵게 */
public class solution12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sco = {1, 2, 3, 9, 10, 12};
		int k = 7;
		
		System.out.println(solution(sco, k));
		
	}
	
	 public static int solution(int[] scoville, int K) {
	        int answer = 0;
	        int sum = scoville.length -1;
			int result;
	        
			Arrays.sort(scoville);
			while(scoville[0] < K ) {
				if(sum == answer) {
					answer = -1;
					break;
					
				}
				result = scoville[0] + (scoville[1]*2);
				scoville = Arrays.copyOfRange(scoville, 2, scoville.length);
				scoville = Arrays.copyOf(scoville, scoville.length+1);
				scoville[scoville.length-1] = result;
				Arrays.sort(scoville);
				answer++;
			}
			
	        return answer;
	    }
	 
	 public static int solution2(int[] scoville, int K) {
		 int answer = 0;
		 PriorityQueue<Integer> que = new PriorityQueue<>();
		 int sum = scoville.length -1;
		 
		 for(int scoNum : scoville) {
			 que.add(scoNum);
		 }
		 
		 while(que.peek() < K) {
			 if(sum == answer) {
				 answer = -1;
				 break;
			 }
			 
			 int a = que.poll();
			 int b = que.poll();
			 
			 int result = a + (b*2);
			 
			 que.add(result);
			 answer++;
		 }
		 
		 return answer;
		 
	 }

}
