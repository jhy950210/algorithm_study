package src.LEETCODE;

public class leet_838 {
    public static void main(String[] args) {

    }

    public static String pushDominoes1(String dominoes) {
        String tmp = dominoes;

        while(true){
            String now = tmp;

            if(now.indexOf("R.L") != -1){
                now = now.replace("R.L","S");
            }
            if(now.indexOf(".L") != -1){
                now = now.replace(".L","LL");
            }
            if(tmp.indexOf("R.") != -1){
                now = now.replace("R.","RR");
            }
            if(now.equals(tmp)) break;

            tmp = now;
        }


        return tmp.replace("S","R.L");
    }

    public static String pushDominoes2(String S) {
        char[] A = S.toCharArray();
        int N = A.length;
        int[] forces = new int[N];

        // Populate forces going from left to right
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R') force = N;
            else if (A[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        // Populate forces going from right to left
        force = 0;
        for (int i = N-1; i >= 0; --i) {
            if (A[i] == 'L') force = N;
            else if (A[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f: forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }
}
