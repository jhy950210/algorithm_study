package src.JUMAL_ALGO;

import java.util.*;

public class cote_4_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();

        System.out.println(solution(n, s));

    }

    public static char solution(int n, String str){
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char voted = str.charAt(i);

            map.put(voted, map.getOrDefault(voted, 0)+1);
        }

        int max = 0;
        for (Character character : map.keySet()) {
            if(map.get(character) > max){
                max = map.get(character);
                answer = character;
            }

        }
        return answer;
    }
}
