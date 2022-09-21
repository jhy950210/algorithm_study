package src.LEETCODE;

public class leet_53 {
	
	public static void main(String[] args) {
		
	}


	public static int maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
	
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i] > nums[i] ? sum + nums[i] : nums[i]; // 다음 숫자와 더했는데 다음 숫자보다 작다면 시작 위치를 바꿈
			max = Math.max(sum, max);
		}
		
		
        return max;
    }
	
}
