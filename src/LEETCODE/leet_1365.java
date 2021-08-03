package src.LEETCODE;

import java.util.*;

public class leet_1365 {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        System.out.println(smallerNumbersThanCurrent(nums));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] res = new int[nums.length];


        for (int i=0; i<nums.length; i++) {
            map.put(i, nums[i]);
        }
        Arrays.sort(nums);

        for (int num : nums) {
             list.add(num);
        }

        for(int i=0; i< res.length; i++){
            res[i] = list.indexOf(map.get(i));
        }

        return res;
    }
}
