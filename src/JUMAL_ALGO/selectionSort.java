package JUMAL_ALGO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/* 선택정렬 */
public class selectionSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 1, 7, 0};
		
		sort(nums);
		for(int num : nums) {
			System.out.println(num);
		}
	}
	
	public static void sort(int[] nums) {
		for(int i=0; i < nums.length-1; i++) {
			for(int j=i+1; j <nums.length; j++) {
				if(nums[j] < nums[i]) {
					swap(nums, i, j);
				}
			}
		}
	}
	
	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
