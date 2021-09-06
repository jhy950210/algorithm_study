package src.JUMAL_ALGO;

public class bj_1149 {
    static int N;
    static int arr[][];
    static int dp[][];

    private int solve() {
        // 0 : 빨강, 1 : 파랑, 2 : 초록
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        dp[1][3] = arr[1][3];

        for(int i=2; i<=N; i++) {
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + arr[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][3];
        }
        int result = Integer.MAX_VALUE;

        for(int i=1; i<=3; i++)
            result = Math.min(result, dp[N][i]);

        return result;
    }
}
