package src.JUMAL_ALGO;

import java.util.*;

public class ss_4 {
    public static void main(String[] args) {
        int[] num = {4,2,2,5,3};
        System.out.println(solution(3,num));
    }

    public static int[] solution(int N, int[] coffee_times){
        int[] res = new int[coffee_times.length];
        int[] cache = new int[N];
        int resIdx = 0;
        int tmp = N;

        while(true){
            for(int i=0; i<N; i++){
                coffee_times[i] -= 1;

                if(coffee_times[i] == 0){
                    if(resIdx < N){
                        res[resIdx++] = i+1;
                    } else{
                        res[resIdx++] = cache[i];
                    }


                    if(tmp < coffee_times.length){
                        coffee_times[i] = coffee_times[tmp++];
                        cache[i] = tmp;
                    }

                }
            }
            
            if(resIdx == coffee_times.length){
                break;
            }
        }

        return res;
    }
}
