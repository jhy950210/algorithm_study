package src.LEETCODE;

public class leet_169 {
    public static void main(String[] args) {
        int[] nums = {2,1,2,3,2,1,2,1,2};

        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count=0, res = 0;
        for (int num: nums) {
            if (count==0){
                res = num;
            }

            if (num!=res) {
                count--;
            } else{
                count++;
            }

        }
        return res;
    }

}
