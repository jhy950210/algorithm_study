package src.LEETCODE;

public class leet_43 {
    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";

        int[] res = new int[num1.length() + num2.length() - 1]; // 총 자리수

        for(int i=0; i < num1.length(); i++){
            for(int j=0; j<num2.length(); j++){
                res[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        for(int i=res.length-1; i>0; i--){
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }
        
        String answer = "";

        for (int re : res) {
            answer += re;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
