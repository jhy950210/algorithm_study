package src.LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class leet_218 {

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        int start = buildings[0][0];

        return new LinkedList<>();
    }
}
