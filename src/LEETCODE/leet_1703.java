package LEETCODE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class leet_1703 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scan = new Scanner(System.in);
		int[] nums = {1, 0, 0, 1, 0, 1};
		int k = 2;

		System.out.println(minMoves(nums, k));
	}

	public static int minMoves(int[] nums, int k) {
		List<Integer> oneIndex = new ArrayList<>();

		// 1이 들어간 배열의 index를 list에 저장
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				oneIndex.add(i);
			}
		}

		final int median = oneIndex.get(getMedIndex(0, k));

		int moves = 0;
		for (int i = 0; i < k; ++i)
			moves += Math.abs(oneIndex.get(i) - median);

		int ans = moves;

		for (int i = 1; i <= oneIndex.size() - k; ++i) {
			final int oldMedianIndex = oneIndex.get(getMedIndex(i - 1, k));
			final int newMedianIndex = oneIndex.get(getMedIndex(i, k));

			if (k % 2 == 1)
				moves += newMedianIndex - oldMedianIndex;

			moves -= newMedianIndex - oneIndex.get(i - 1);
			moves += oneIndex.get(i + k - 1) - newMedianIndex;
			ans = Math.min(ans, moves);
		}

		return ans - nThSum((k - 1) / 2) - nThSum(k / 2);
	}

	// return median index of [i..i + k)
	private static int getMedIndex(int i, int k) {
		return (i + (i + k - 1)) / 2;
	}

	// return 1 + 2 + ... + n
	private static int nThSum(int n) {
		return n * (n + 1) / 2;
	}
}
