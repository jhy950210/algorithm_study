package src.JUMAL_ALGO;

import java.util.Scanner;
import java.util.Stack;

public class cote_5_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));

    }

    public static String solution(String str){
        String answer = "";
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(char a : str.toCharArray()){
            if(a == '('){
                stack.push(a);
            } else if(a == ')') {
                stack.pop();
            } else {
                if(stack.isEmpty()){
                    sb.append(a);
                }
            }
        }

        return sb.toString();
    }
}
