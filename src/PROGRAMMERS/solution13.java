package PROGRAMMERS;

import java.util.Collections;
import java.util.PriorityQueue;

/* 이중우선순위큐 */
public class solution13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ope1 = {"I 16","D 1"};
		String[] ope2 = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
				
		System.out.println(solution(ope1));
		System.out.println(solution(ope2));
		
	}
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
        	char exp = operations[i].charAt(0);
        	String numStr = operations[i].substring(2);
        	
        	if(exp == 'I') {
        		minQue.add(Integer.parseInt(numStr));
        		maxQue.add(Integer.parseInt(numStr));
        	} else {
        		if(minQue.isEmpty()) {
        			continue;
        		}
        		
        		if(numStr.equals("-1")) {
        			int num = minQue.poll();
        			maxQue.remove(num);
        		} else if(numStr.equals("1")){
        			int num = maxQue.poll();
        			minQue.remove(num);
        		} else {
        			continue;
        		}
        			
        	}
        }
        
        if(!minQue.isEmpty()) {
        	answer[0] = maxQue.poll();
        	answer[1] = minQue.poll();
        }
        
        return answer;
    }
	
}


