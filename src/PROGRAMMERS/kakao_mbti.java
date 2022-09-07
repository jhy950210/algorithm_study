package src.PROGRAMMERS;

import java.util.*;

public class kakao_mbti {

    public static void main(String[] args) {
        String[] sur = {"TR", "RT", "TR"};
        int[] cho = {7, 1, 3};

        System.out.println(solution(sur, cho));
        // "TCMA"
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        Set<String> types = new HashSet<>(Arrays.asList("RT", "CF", "JM", "AN"));
        Map<String, Integer> sumScore = new HashMap<>();

        for(int i=0; i< choices.length; i++){
            String item = survey[i];
            int checked = choices[i];
            int score = Choice.getScore(checked);

            if( !types.contains(item) ){
                StringBuffer tmpItem = new StringBuffer(item);
                String reverseItem = tmpItem.reverse().toString();
                System.out.println(reverseItem);

                sumScore.put(reverseItem, sumScore.getOrDefault(reverseItem, 0) - score);
            } else {
                System.out.println(item);
                sumScore.put(item, sumScore.getOrDefault(item, 0) + score);
            }

        }

        for(String key: types){
            if(sumScore.getOrDefault(key, 0) <= 0){
                answer += key.charAt(0);
            } else {
                answer += key.charAt(1);
            }
        }

        return answer;
    }

    public enum Choice{
        highAgree(7,3),
        midAgree(6,2),
        lowAgree(5,1),
        medium(4,0),
        lowDisagree(3,-1),
        midDisagree(2,-2),
        highDisagree(1,-3);

        private int value;
        private int score;

        Choice(int value, int score){
            this.value = value;
            this.score = score;
        }

        static int getScore(int value){
            return Arrays.stream(values())
                    .filter(v -> value == v.value)
                    .findFirst()
                    .map(v -> v.score).get();
        }
    }
}
