package src.PROGRAMMERS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class immigration {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};

		System.out.println(solution(n, times));
		// 28
	}

	public static long solution(int n, int[] times) {
		long answer = 0;

		Arrays.sort(times);
		long min = 0;
		long max = (long) n * times[times.length - 1];

		while(min < max){
			long mid = (min + max) / 2;
			long sum = 0;

			for(int i=0; i<times.length; i++){
				sum += mid / times[i];
			}

			if(sum < n){
				min = mid + 1;
			} else {
				max = mid - 1;
			}

			answer = mid;
		}

		return answer;
	}

}
