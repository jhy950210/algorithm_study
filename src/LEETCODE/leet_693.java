package src.LEETCODE;

import java.util.List;

public class leet_693 {
    public static void main(String[] args) {

    }

    public static boolean hasAlternatingBits(int n) {
        String b = Integer.toBinaryString(n);
        char[] bChar = b.toCharArray();

        for(int i=0; i<bChar.length-1; i++){
            if(bChar[i] == bChar[i+1]){
                return false;
            }
        }
        return true;
    }
}
