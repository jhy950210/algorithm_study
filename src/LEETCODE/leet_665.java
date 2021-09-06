package src.LEETCODE;

public class leet_665 {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
    }
    public static boolean checkPossibility(int[] nums) {
        int count = 0;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                count++;

                if(count == 2){
                    return false;
                }

                if(i-1<0 || nums[i-1] <= nums[i+1]){
                    nums[i] = nums[i+1];
                } else {
                    nums[i+1] = nums[i];
                }
            }

        }

        return true;
    }
}
