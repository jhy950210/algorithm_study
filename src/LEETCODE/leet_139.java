package src.LEETCODE;

import java.util.List;

public class leet_139 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of(new String[]{"leet", "code"});
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        for(int i=0; i<s.length(); i++){
            for(int j=0; j<i; j++){
                String str = s.substring(j, i+1);

                if(wordDict.contains(str) && (j ==0 || dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()-1];
    }

}
