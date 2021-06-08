package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class leet_567 {
	static List<String> checkList = new ArrayList<String>();
	
	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
	}
	
	public static boolean checkInclusion(String s1, String s2) {
		char[] arr = new char[s1.length()];
		
		if(s1.length() > s2.length()) { return false; }
		
		for(int i=0; i<s1.length(); i++) {
			arr[i] = s1.charAt(i);
		}
		
		per(arr, 0, s1.length());
		
		for(String str : checkList) {
			if(s2.contains(str)) {
				return true;
			}
		}
		
		return false;
    }
	
	public static void per(char[] arr, int depth, int r){
		if(depth == r) {
			String str = "";
			for(char chr : arr) {
				str += chr;
			}
			checkList.add(str);
		}
		for(int i=depth; i<arr.length; i++) {
			swap(arr, i, depth);
			per(arr, depth+1, r);
			swap(arr, i, depth);
		}
	}
	
	public static void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
