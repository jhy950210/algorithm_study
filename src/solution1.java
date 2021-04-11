import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,5,3,2,1};
		int[] b = {2,4,4,5,1};
		int[][] aa = { {1, 0, 0}, 
						{1, 1, 0}, 
						{1, 1, 0}, 
						{1, 0, 1}, 
						{1, 1, 0}, 
						{0, 1, 1} };
		int r = 2;
		System.out.println(solution(aa,r));
	}

	public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        HashMap<Integer, Integer> checkCardValue = new HashMap<>();
        HashMap<Integer, Integer> checkWantValue = new HashMap<>();
        
        // 갖고 있는 상품권의 번호의 개수 확인
        for(int key : gift_cards) checkCardValue.put(key, checkCardValue.getOrDefault(key, 0) + 1);
        System.out.println(checkCardValue);
        
        // 원하는 상품 번호 개수 확인
        for(int key : wants) checkWantValue.put(key, checkWantValue.getOrDefault(key, 0) + 1);
        System.out.println(checkWantValue);
        
        // 가지고 있는 상품권과 원하는 상품권의 개수 차이를 보면 된다.
        for(int key : checkWantValue.keySet()) {
        	int myItem = checkCardValue.getOrDefault(key, 0);
        	int wantItem = checkWantValue.get(key);
        	
        	if( myItem < wantItem ) {
        		answer += wantItem - myItem;
        	}
        }
        return answer;
    }
	
	public static int solution(int[][] needs, int r) {
        int answer = 0;
        HashMap<Integer, Integer> checkValue = new HashMap<>();
        
        // 가장 많이 겹치는 부품 탐색
        for(int i=0; i < needs.length; i++) {
        	for(int j=0; j < needs[i].length; j++) {
        		if(needs[i][j] == 1) {
        			checkValue.put(j, checkValue.getOrDefault(j, 0) + 1);
        		}
        	}
        }
        
        // 내림차순으로 정렬
        List<Integer> keySet = new ArrayList<>(checkValue.keySet());
        keySet.sort((o1,o2) -> checkValue.get(o2) - checkValue.get(o1));
        
        // list에 check할 값을 (r 크기에 맞게) 담음
        List<Integer> checkSet = new LinkedList<>();
        int cnt = 0;
        
        for(int key : keySet ) {
        	if(cnt == r ) break;
        	
        	checkSet.add(key);
        	cnt++;
        }
        
        // list에 있는 부품들로 완제품 만들수 있는 개수 찾기
        int rowAnswer = 0;
        
        for(int i=0; i < needs.length; i++) {
        	for(int j=0; j < needs[i].length; j++) {
        		if(needs[i][j] == 1) {
        			if(checkSet.contains(j)) {
        				rowAnswer++;
        			} else {
        				rowAnswer = 0;
        				break;
        			}
        		}
            }
        	if(rowAnswer != 0) {
        		answer += 1;
        	}
        }
        
        return answer;
    }
}
