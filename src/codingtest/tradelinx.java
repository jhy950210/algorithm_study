package src.codingtest;

import java.util.ArrayList;
import java.util.List;

public class tradelinx {
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int N = 7;
        int[][] relation = {{1, 2}, {2, 5}, {2, 6}, {1, 3}, {1, 4}, {3, 7}};
        String[] dirname = {"root", "abcd", "cs", "hello", "etc", "hello", "solution"};
        int answer = longestPath(N, relation, dirname);

        System.out.println(answer);
    }

    /**
     * 1일 - [0,1]
     * 2일~5일 - [0,2]
     * 1. 6일 - [1,2]
     * 2. 7일 - [2,2]
     * 3. 8일 - [2,3]
     * 9일~12일 - [2,4]
     * 13일 - [3,4]
     * 14일 - [4,4]
     * 15일 - [4,5]
     */
    public static long[] solution(long n) {
        if (n == 1) return new long[]{0, 1};

        if (n % 7 == 0) {
            long minHoliday = 2 * n / 7;
            long maxHoliday = 2 * n / 7;
            return new long[]{minHoliday, maxHoliday};
        } else if (n % 7 == 1) {
            long minHoliday = 2 * n / 7;
            long maxHoliday = 2 * n / 7 + 1;
            return new long[]{minHoliday, maxHoliday};
        } else if (n % 7 == 6) {
            long minHoliday = 2 * (n + 1) / 7 - 1;
            long maxHoliday = 2 * (n + 1) / 7;
            return new long[]{minHoliday, maxHoliday};
        } else {
            long minHoliday = 2 * (n - 1) / 7;
            long maxHoliday = 2 * (n - 1) / 7 + 2;
            return new long[]{minHoliday, maxHoliday};
        }
    }

    /**
     * N개의 노드, relation은 연결된 노드의 배열, dirname은 디렉토리 이름
     * 연결된 디렉토리의 이름을 연결했을 때, 가장 긴 디렉토리 경로를 반환
     *
     * @param N
     * @param relation
     * @param dirname
     * @return
     */
    public static int longestPath(int N, int[][] relation, String[] dirname) {
        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < relation.length; i++) {
            graph.get(relation[i][0]-1).add(relation[i][1]);
        }

        // DFS 함수
        dfs(0, graph, dirname, 0);


        return answer-1;
    }

    private static void dfs(int nodeNum, List<List<Integer>> graph, String[] dirname, int maxLength){
        int nowLength = maxLength + dirname[nodeNum].length()+1;

        if(graph.get(nodeNum).isEmpty() || graph.get(nodeNum) == null){
            answer = Math.max(answer, nowLength);
        }

        for(int i=0; i<graph.get(nodeNum).size(); i++){
            dfs(graph.get(nodeNum).get(i)-1, graph, dirname, nowLength);
        }
    }
}
