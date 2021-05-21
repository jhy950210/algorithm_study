package LEETCODE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class leet_815 {
	//static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] aa = {{1,2,7},{3,6,7}};
		int s = 1;
		int t =	6;
		
		System.out.println(numBusesToDestination(aa, s, t));
		
	}
	
	public static int numBusesToDestination(int[][] routes, int source, int target) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // key : 정류장 번호 / value : 버스 번호
		int count = 0;
		
		// 출발지 목적지 같은 경우
		if(source == target) { return 0; }
		
		// 정류장별 정차하는 버스 리스트 생성
		for(int i=0; i<routes.length; i++) {
			for(int j=0; j<routes[i].length; j++) {
				ArrayList<Integer> des = map.getOrDefault(routes[i][j], new ArrayList<>());
				des.add(i);
				map.put(routes[i][j], des);
			}
		}
		
		Queue<Integer> desQue = new LinkedList<Integer>(); // 정류장 큐
		HashSet<Integer> visited = new HashSet<>(); // 방문한 정류장 체크
		
		desQue.add(source);
		while(!desQue.isEmpty()) {
			int desSize = desQue.size();
			count++;
			
			for(int i=0; i<desSize; i++) {
				int now = desQue.poll();
				ArrayList<Integer> busList = map.get(now);
				
				for(int bus : busList) {
					// 탔던 버스 제외
					if(visited.contains(bus)) {
						continue;
					}
					visited.add(bus);
					
					for(int j=0; j<routes[bus].length; j++) {
						if(routes[bus][j] == target) {
							return count;
						} else {
							desQue.add(routes[bus][j]);
						}
					}
					
				}
			}
		}
		
        return -1;
    }
}
