package src.codingtest;

import java.util.*;

public class kkoenter {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        nums.add(31);
        nums.add(15);
        nums.add(7);
        nums.add(3);
        nums.add(2);

        List<Integer> integerList = cardinalitySort(nums);

        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }


    public static List<Integer> cardinalitySort(List<Integer> nums) {
        // Write your code here
        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            int count = 0;
            String s = Integer.toBinaryString(num);

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    count++;
                }
            }

            map.put(num, count);

        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> {
            if(map.get(o1).compareTo(map.get(o2)) == 0){
                return o1.compareTo(o2);
            }else{
                return map.get(o1).compareTo(map.get(o2));
            }
        });


        for (Integer integer : keySetList) {
            result.add(integer);
        }

        return result;
    }
}
