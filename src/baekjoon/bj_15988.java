package src.baekjoon;

public class bj_15988 {
    public long solution(int n){
        long[] dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }

        return dp[n];
    }
}
