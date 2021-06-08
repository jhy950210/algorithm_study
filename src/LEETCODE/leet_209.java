package LEETCODE;

public class leet_209 {
	
	public static void main(String[] args) {
		
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
		int sum = 0, len = 0;
		int min = Integer.MAX_VALUE;
		
		for(int num : nums) {
			sum += num;
		}
		
		if(sum < target) { return 0; }
		
		sum = 0;
		
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			len++;
			for(int j=i+1; j<nums.length; j++) {
				if(target > sum) { break; }
				
				sum += nums[j];
				len++;
			}
			min = Math.min(min, len);
			sum = 0;
		}
		
		
        return min;
    }
	
}
