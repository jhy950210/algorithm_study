package src.LEETCODE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet_1207 {
    public static void main(String[] args) {

    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            int num = map.getOrDefault(arr[i],0);
            map.put(arr[i], num+1);
        }

        for(int key : map.keySet()){
            if(set.contains(map.get(key))){
                return false;
            }
            set.add(map.get(key));
        }

        return true;
    }
}
