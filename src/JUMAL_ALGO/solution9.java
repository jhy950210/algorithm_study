package JUMAL_ALGO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 캠핑 */
public class solution9 {
    static int L, P, V;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            L = Integer.parseInt(st.nextToken()); // 가능한 기간
            P = Integer.parseInt(st.nextToken()); // 총 캠핑기간
            V = Integer.parseInt(st.nextToken()); // 휴가기간

            if(L == 0 && P == 0 && V == 0) {
                break;
            }

            int remain = V % P > L ? L : V % P;
            int sum = L * (V / P) + remain;
            count++;

            sb.append("Case " + count + ": " + sum + "\n");

        }

        System.out.println(sb.toString());

    }
}
