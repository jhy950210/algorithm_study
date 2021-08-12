package src.JUMAL_ALGO;

import java.util.Scanner;
import java.util.Stack;

public class cote_5_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));

    }

    public static int solution(String str){
        Stack<Character> stk = new Stack<>();
        int answer = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stk.push('(');
            } else {
                stk.pop();
                if(str.charAt(i-1) == '('){
                    answer += stk.size();
                } else {
                    answer++;
                }

            }
        }

        return answer;
    }

}
