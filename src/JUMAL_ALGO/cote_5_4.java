package src.JUMAL_ALGO;

import java.util.Scanner;
import java.util.Stack;

public class cote_5_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));

    }

    public static int solution(String str){
        Stack<Character> stk = new Stack<>();
        int answer = 0;

        for (char x : str.toCharArray()) {
            if(Character.isDigit(x)){
                stk.push(x);
            } else {
                int b = stk.pop() - '0';
                int a = stk.pop() - '0';

                char calculate = (char) (calculate(a, b, x) + '0');
                stk.push(calculate);
            }
        }
        answer = stk.pop() - '0';
        return answer;
    }

    public static int calculate(int a, int b, char c){
        if(c == '+'){
            return a+b;
        }
         else if(c == '-'){
            return a-b;
        }
         else if(c == '*'){
            return a*b;
        }
        else{
            return a/b;
        }
    }
}
