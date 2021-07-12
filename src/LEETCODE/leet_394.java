package src.LEETCODE;

public class leet_394 {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {

        if(s.indexOf('[') == -1){
            return s;
        }

        int frontIdx = s.lastIndexOf('[');
        int backIdx = -1;
        int tmp = frontIdx - 1;

        while(true){
            if(tmp >= 0 && Character.isDigit(s.charAt(tmp)) ){
                tmp--;
            } else {
                tmp++;
                break;
            }
        }

        int count = Integer.parseInt(s.substring(tmp,frontIdx));

        StringBuilder sb = new StringBuilder();

        for(int i=frontIdx; i<s.length(); i++){
            if(s.charAt(i) == ']'){
                backIdx = i;
                break;
            }
        }

        sb.append(s.substring(0,tmp));
        for(int i=0;i<count; i++){
            sb.append(s.substring(frontIdx+1,backIdx));
        }
        sb.append(s.substring(backIdx+1));

        s = decodeString(sb.toString());

        return s;
    }
}
