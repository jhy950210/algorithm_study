package src.JUMAL_ALGO;

import java.util.HashMap;
import java.util.Scanner;

public class cote_4_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.next();
        String s2 = in.next();

        System.out.println(solution(s1,s2));

    }

    public static String solution(String str1, String str2){
        String answer = "YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<str1.length(); i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            map1.put(c1, map1.getOrDefault(c1,0)+1);
            map2.put(c2, map2.getOrDefault(c2,0)+1);
        }

        for (Character character : map1.keySet()) {
            if(map1.get(character) != map2.get(character)){
                answer = "NO";
                break;
            }
        }

        return answer;
    }
}
