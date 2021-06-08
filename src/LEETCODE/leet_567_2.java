package LEETCODE;

import java.util.Arrays;

public class leet_567_2 {
	
	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
	}
	
	public static boolean checkInclusion(String s1, String s2) {
		int[] s1arr = new int[26];
		int[] s2arr = new int[26];
		
		for(int i=0; i<s1.length(); i++) {
			s1arr[s1.charAt(i) - 'a']++;
		}
		
		for(int j=0; j<s2.length(); j++) {
			s2arr[s2.charAt(j) - 'a']++;
			if(j>=s1.length()) {
				s2arr[s2.charAt(j-s1.length()) - 'a']--;
			}
			
			if(Arrays.equals(s1arr, s2arr)) { 
				return true;
			}
		}
		return false;
    }

}
