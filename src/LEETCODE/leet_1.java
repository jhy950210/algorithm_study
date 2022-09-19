package src.LEETCODE;

public class leet_1 {
    public static int[] twoSum(int[] nums, int target) {
        int first = 0, second = 0;

        loop1 :
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    first = i;
                    second = j;
                    break loop1;
                }
            }
        }
        return new int[]{first,second};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(twoSum(nums, target));
    }
}
