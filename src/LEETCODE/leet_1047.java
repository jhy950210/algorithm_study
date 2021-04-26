package LEETCODE;

import java.util.Scanner;

public class leet_1047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		System.out.println(removeDuplicates(str));
	}

	public static String removeDuplicates(String S) {
		
		for(int index=1; index < S.length(); index++) {
			if(S.charAt(index) == S.charAt(index - 1)) {
				S = S.substring(0, index-1) + S.substring(index+1);
				S = removeDuplicates(S);
				break;
			}
		}
		
		return S;
    }
}
