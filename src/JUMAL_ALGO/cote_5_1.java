package src.JUMAL_ALGO;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class cote_5_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));

    }

    public static String solution(String str){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            } else {
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    return "NO";
                }

            }

        }

        if(!stack.isEmpty()){
            return "NO";
        }
        return answer;
    }
}
