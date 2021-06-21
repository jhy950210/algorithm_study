package src.LEETCODE;

public class leet_55 {
    public static void main(String[] args) {
        int[] nums = {3,0,8,2,0,0,1};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxHeight = 0;

        for(int i=0; i<nums.length; i++){
            if(i > maxHeight){
                return false;
            }
            maxHeight = Math.max(i + nums[i], maxHeight);
        }

        return maxHeight >= nums.length-1;

    }


}
