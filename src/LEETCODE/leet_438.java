package src.LEETCODE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leet_438 {
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String p = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		System.out.println(findAnagrams(s,p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> answer = new LinkedList<>();
		Map<Character, Integer> countCharP = new HashMap<>();
		for(int i=0; i<p.length(); i++){
			countCharP.put(p.charAt(i), countCharP.getOrDefault(p.charAt(i),0)+1);
		}

		int match = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (countCharP.containsKey(c)) {
				countCharP.put(c, countCharP.get(c) - 1);
				if (countCharP.get(c) == 0) {
					match++;
				}
			}
			if (i >= p.length()) {
				c = s.charAt(i - p.length());
				if (countCharP.containsKey(c)) {
					countCharP.put(c, countCharP.get(c) + 1);
					if (countCharP.get(c) == 1) {
						match--;
					}
				}
			}
			if (match == countCharP.size()) {
				answer.add(i - p.length() + 1);
			}
		}

		return answer;
	}
	
}
