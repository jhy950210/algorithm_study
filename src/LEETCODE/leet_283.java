package other;

public class leet_283 {
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
	}
	
    public static void moveZeroes(int[] nums) {
        if(nums.length == 0) { return; }
        int idx = 0;
        
        for( int num : nums ) {
        	if(num != 0) {
        		nums[idx++] = num;
        	}
        }
        
        for(int i=idx; i < nums.length; i++) {
        	nums[i] = 0;
        }
        
    }
	
}
