package src.LEETCODE;

import java.util.*;

public class leet_524 {
    public static void main(String[] args) {
         String s = "abpcplea";
         List<String> dictionary = Arrays.asList(new String[]{"ale","apple","monkey","plea"});

        System.out.println(findLongestWord(s,dictionary));
    }

    // dictionary에 있는 단어들 중에 s에서 문자를 지워서 나올 수 있는 제일 긴 단어를 반환
    // 만약 길이가 같은 단어가 있다면 사전적 정의로 정렬했을때 앞에 있는 단어를 반환
    // 없다면 빈 문자열을 반환환
   public static String findLongestWord(String s, List<String> dictionary) {
        ArrayList<Character> sList = new ArrayList<>();
        String result = "";

        for(int i=0; i<s.length(); i++){
            sList.add(s.charAt(i));
        }

        for(String str : dictionary){
            int nowIdx = 0; // dictionary index 조정
            int listIdx = 0; // sList index 조정

            while(sList.size() > listIdx){
                char checkChar = sList.get(listIdx);
                listIdx++;

                if(checkChar == str.charAt(nowIdx)){
                    nowIdx++;

                    if(nowIdx >= str.length()){
                        if(str.length() > result.length()){
                            result = str;
                        } else if(str.length() == result.length()){
                            // 사전적 정의 정렬
                            if(str.compareTo(result) < 0){
                                result = str;
                            }
                        }
                        break;
                    }
                }

            }
        }


        return result;
    }
}
