package src.LEETCODE;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class leet_733 {
    static boolean[][] visited;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];

        bfs(image, sr, sc, color);

        return image;
    }

    public static void bfs(int[][] image, int sr, int sc, int color) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sr,sc));
        int checkNumber = image[sr][sc];

        visited[sr][sc] = true;

        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            image[temp.x][temp.y] = color;

            for(int i=0; i<4; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];

                if(nextX >= 0 && nextY >=0 && nextX <= image.length-1 && nextY <= image[0].length-1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    if(checkNumber == image[nextX][nextY]){
                        queue.offer(new Point(nextX, nextY));
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill(image , sr, sc, color);
        for (int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.println(result[i][j]);
            }
        }

    }
}
