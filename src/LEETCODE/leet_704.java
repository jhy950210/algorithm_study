package src.LEETCODE;

import java.util.Arrays;

public class leet_704 {
    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length -1;

        while( min <= max ){
            int mid = (min + max) / 2;

            if(nums[mid] > target){
                max = mid - 1;
            } else if(nums[mid] < target){
                min = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums , target));
    }
}
