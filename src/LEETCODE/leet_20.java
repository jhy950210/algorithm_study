package src.LEETCODE;

import java.util.HashMap;
import java.util.Stack;

public class leet_20 {
    public static boolean isValid(String s) {
        //HashMap<Character, Integer> countChar = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if( c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if( c == ')'){
                if(stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            } else if( c == '}'){
                if(stack.isEmpty() || stack.peek() != '{') return false;
                else stack.pop();
            } else if( c == ']'){
                if(stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            }
        }

        if( !stack.isEmpty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }
}
