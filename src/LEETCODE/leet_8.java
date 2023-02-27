package src.LEETCODE;


public class leet_8 {
    public static int myAtoi(String s) {
        s = s.trim();

        if(s.length() == 0) return 0;

        char firstChar = s.charAt(0);
        int sign = 1;
        int len = s.length();
        int start = 0;

        if( firstChar == '-'){
            sign = -1;
            start++;
        } else if( firstChar == '+' ){
            sign = 1;
            start++;
        }

        long sum = 0;

        for(int i = start; i < len; i++){
            if(!Character.isDigit(s.charAt(i))){
                return (int) (sign * sum);
            }
            sum = (sum*10) + s.charAt(i) -'0';

            if(sign == 1 && sum > Integer.MAX_VALUE ){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && (-1*sum) < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

        return (int) (sign*sum);
    }

    public static void main(String[] args) {
        String s = "-91283472332";

        System.out.println(myAtoi(s));
    }
}
