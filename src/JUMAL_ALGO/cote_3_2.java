package src.JUMAL_ALGO;

import java.util.*;

public class cote_3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];


        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] b = new int[m];

        for(int i=0; i<m; i++){
            b[i] = in.nextInt();
        }

        PriorityQueue queue = solution(a, b);

        while(!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }

    }

    public static PriorityQueue solution( int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i : arr1) {
            set.add(i);
        }

        for (int i : arr2) {
            if(set.contains(i)){
                que.add(i);
            }
        }

        return que;
    }
}
