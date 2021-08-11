package src.JUMAL_ALGO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class cote_4_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.next();
        String s2 = in.next();

        System.out.println(solution(s1, s2));
    }

    public static int solution(String str1, String str2){
        int answer = 0;
        HashMap<Character, Integer> check = new HashMap<>();

        for(int i=0; i<str2.length(); i++){
            check.put(str2.charAt(i), check.getOrDefault(str2.charAt(i),0)+1);
        }

        for(int i=0; i<str1.length()-str2.length()+1; i++){
            int count = 1;
            String tmp = str1.substring(i, i + str2.length());
            HashMap<Character, Integer> tmpMap = new HashMap<>();

            for(int j=0; j<tmp.length(); j++){
                tmpMap.put(tmp.charAt(j), tmpMap.getOrDefault(tmp.charAt(j),0)+1);
            }

            if(tmpMap.keySet().equals(check.keySet())){
                for (Character character : check.keySet()) {
                    if(!check.get(character).equals(tmpMap.get(character))){
                        count = 0;
                        break;
                    }
                }
            } else {
                count = 0;
            }

            answer += count;
        }

        return answer;
    }
}
