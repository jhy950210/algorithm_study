package PROGRAMMERS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 문자열 압축 */
public class solution10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(solution("ababcdcdababcdcd"));
		
	}
	
	public static int solution(String s) {
		int answer = s.length();
		
		for(int i=1; i <= s.length()/2; i++) {
			String tmp = s.substring(0,i); // 첫 비교할 기준 문자열
			int cnt = 1;
			String result = "";
			String remain = "";
			
			for(int j=i; j < s.length(); j+=i) {
				int to = Math.min(j+i, s.length()); //끝 값이 문자열보다 길면 값 바꿔줌.
				remain = s.substring(j, to); // 남은 값
				
				if(tmp.equals(s.substring(j, to))) {
					cnt++;
				} else {
					if(cnt == 1) {
						result += tmp;
					} else {
						result += Integer.toString(cnt) + tmp;
					}
					
					tmp = s.substring(j, to); // 비교 기준을 바꿔줌
					cnt = 1; // cnt도 초기화
				}
				
			}
			
			//남은 값 처리
			if(cnt == 1) {
				result += remain;
			} else {
				result += Integer.toString(cnt) + remain;
			}
			
			//answer 갱신
			answer = Math.min(answer, result.length());
			
		}
		
        return answer;
    }
	
	 public static int solution2(String s) {
	        int answer = Integer.MAX_VALUE;
	        if(s.length() == 1) return 1;
	        // 문자열 기준 1~length 까지
	        for(int i=1; i<s.length() ; i++){
	            String now = ""; String comp = "";
	            String temp = "";
	            int cnt = 1;
	            
	            // j 기준 단위 0부터 length/i 단위까지
	            // 나누어 떨어지지않을때 끝까지 계산해주려면
	            for(int j= 0; j<=s.length()/i;j++){
	                int from = i*j; int to = i*(j+1);
	                // 값 넘을 시 보정
	                if(to > s.length()) to = s.length();

	                // 기준점 변경
	                now = comp;
	                comp = s.substring(from, to);

	                // 비교
	                if(now.equals(comp)) cnt++;
	                else{
	                    if(cnt>1) temp += String.valueOf(cnt);
	                    temp += now; 
	                    cnt = 1; // 개수 초기화
	                }
	            }
	            // 남은값 처리
	            if(cnt>1) temp += String.valueOf(cnt);
	            temp += comp; 
	            // 갱신
	            answer = Math.min(temp.length(), answer);
	        }
	        
	        return answer;
	    
	    }
}
