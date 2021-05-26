package LEETCODE;

import java.util.HashSet;

public class leet_873 {
	
	public static void main(String[] args) {
		 int[] arr = {1,2,3,4,5,6,7,8};
		 System.out.println(lenLongestFibSubseq(arr));
	}

	public static int lenLongestFibSubseq(int[] arr) {
		HashSet<Integer> checkNum = new HashSet<Integer>(); // 숫자 있는지 체크
		int result = 2;
		
		for(int num : arr) {
			checkNum.add(num);
		}
		
		for(int i=0; i<arr.length-2; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int one = arr[i];
				int two = arr[j];
				int max = 2;
				
				while(checkNum.contains( one + two )) {
					int tmp = one;
					one = two;
					two = tmp + two;
					max++;
				}
				result = Math.max(max, result);
			}
		}
		
        return result > 2 ? result : 0;
    }
	
}
