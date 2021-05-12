package PROGRAMMERS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class kakao_intern {
    public static String[][] place = new String[5][5];
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[5][5];
    static int pNum = -1;
    static int[] pNums = new int[5];
    static int count = 0;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        
        System.out.println("answer : " + solution2(places));

    }

    public static int solution1(String s) {
        int answer = 0;
        HashMap<Integer, String> number = new HashMap<>();
        number.put(0, "zero");
        number.put(1, "one");
        number.put(2, "two");
        number.put(3, "three");
        number.put(4, "four");
        number.put(5, "five");
        number.put(6, "six");
        number.put(7, "seven");
        number.put(8, "eight");
        number.put(9, "nine");

        for (Map.Entry<Integer, String> entry : number.entrySet()) {
            if (s.contains(entry.getValue())) {
                s = s.replaceAll(entry.getValue(), Integer.toString(entry.getKey()));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }

    public static int[] solution2(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            pNum = -1;

            for (int l = 0; l < pNums.length; l++) {
                pNums[l] = 0;
            }

            for (int j = 0; j < 5; j++) {
                String tmp = places[i][j];

                for (int k = 0; k < tmp.length(); k++) {
                    place[j][k] = tmp.substring(k, k + 1);
                }

            }

            for (int m = 0; m < 5; m++) {
                count++;
                pNum++;
                
                for (int n = 0; n < 5; n++) {
                    if (place[m][n].equals("P") && !visited[m][n]) {
                        dfs(m, n);
                    }
                }

                for(int a : que){
                    System.out.println(count);
                    System.out.println("a = " + a);
                    System.out.println("-------------------");

                    que.clear();
                }
            }



        }

        for(int ans : answer){
            System.out.println("ans = " + ans);
        }

        return answer;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                if (place[nx][ny].equals("O") && !visited[nx][ny]) {
                    pNums[pNum]++;
                    dfs(nx, ny);
                } else if (place[nx][ny].equals("X") && !visited[nx][ny]) {
                } else {
                    if(pNums[pNum] <= 2) {
                        que.add(pNum);
                    };
                }

            }
        }
        visited[x][y] = false;
    }

}


