package src.PROGRAMMERS;

import java.util.*;

public class diskcontroller {
    public static void main(String[] args) {
        int[][] j = {{0, 3}, {1, 9}, {2, 6}};
        int[][] j1 = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
        int[][] j2 = {{0, 10}, {2, 12}, {9, 19}, {15, 17}};
        int[][] j3 = {{0, 3}, {1, 9}, {2, 6}};
        int[][] j4 = {{0, 1}};
        int[][] j5 = {{1000, 1000}};
        int[][] j6 = {{0, 1}, {0, 1}, {0, 1}};
        int[][] j7 = {{0, 1}, {0, 1}, {0, 1}, {0, 1}};
        int[][] j8 = {{0, 1}, {1000, 1000}};
        int[][] j9 = {{100, 100}, {1000, 1000}};
        int[][] j10 = {{10, 10}, {30, 10}, {50, 2}, {51, 2}};
        int[][] j11 = {{0, 3}, {1, 9}, {2, 6}, {30, 3}};
        int[][] j12 = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};

        System.out.println(solution(j12));
    }


    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] <= o2[0]){
                    return -1;
                }
                return 1;
            }
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return -1;
                }
                return 1;
            }
        });

        int time = 0;
        int index = 0;
        float answer = 0;

        while(true){
            while(index < jobs.length && jobs[index][0] <= time){
                queue.offer(jobs[index]);
                index ++;
            }
            if(queue.size() == 0){
                time = jobs[index][0];
                continue;
            }

            int[] job = queue.poll();
            time += job[1];
            answer += time - job[0];

            if(index == jobs.length && queue.isEmpty()){
                break;
            }
        }

        answer /= jobs.length;
        return (int)answer;
    }
}
