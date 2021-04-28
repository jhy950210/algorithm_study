package LEETCODE;

import java.util.Scanner;

public class leet_921 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		System.out.println(minAddToMakeValid(str));
	}

	public static int minAddToMakeValid(String S) {
		// 한쪽 괄호만 존재하는 경우
		if(!S.contains("(") || !S.contains(")")) {
			return S.length();
		}
		
		int count = 0; // 개수
		int result = 0; // 최종값
		
		for(int index = 0; index < S.length(); index++) {
			if(S.charAt(index) == '(') {
				count++;
				result++;
			} else {
				if(count == 0) {
					result++;
				} else {
					count--;
					result--;
				}
			}
		}
		return result;
    }
}
