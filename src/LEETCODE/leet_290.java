package src.LEETCODE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet_290 {
	
	public static void main(String[] args) {
        String p = "abba";
        String s = "dog dog dog dog";
        System.out.println( wordPattern(p,s) );
	}

    public static boolean wordPattern(String pattern, String s) {
        String[] splitStr = s.split(" ");

        Map matchItem = new HashMap();
        Set checkItem = new HashSet();

        if(pattern.length() != splitStr.length){
            return false;
        }

        for(int i=0; i< splitStr.length; i++){
            if(checkItem.contains(splitStr[i])){
                if(matchItem.get(pattern.charAt(i)) == null || !matchItem.get(pattern.charAt(i)).equals(splitStr[i])){
                    return false;
                }
            } else {
                if(matchItem.get(pattern.charAt(i)) != null){
                    return false;
                }
                matchItem.put(pattern.charAt(i), splitStr[i]);
                checkItem.add(splitStr[i]);
            }

        }

        return true;
    }
}
