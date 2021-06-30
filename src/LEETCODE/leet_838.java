package src.LEETCODE;

public class leet_838 {
    public static void main(String[] args) {

    }

    public static String pushDominoes(String dominoes) {
        char[] dominoChar = dominoes.toCharArray();
        String result = "";
        boolean isForce = false;

        for(int i=0; i<dominoChar.length; i++){
            if(dominoChar[i] == 'L'){
                result += "L";
                isForce = false;
            }
            if(dominoChar[i] == 'R'){
                result += "R";
                isForce = true;
            }
            if(dominoChar[i] == '.'){
                if(isForce && dominoChar[i+1] == 'L'){
                    result += ".";
                } else if(isForce){
                    result += "R";
                } else if(!isForce && dominoChar[i+1] == 'L'){
                    result += "L";
                }
            }
        }

        return "";
    }
}
