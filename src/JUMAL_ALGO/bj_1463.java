package src.JUMAL_ALGO;

public class bj_1463 {
    public static void main(String[] args) {
        System.out.println(sol(10));
    }

    public static int sol(int n){
       if(n == 2 || n ==3){
           return 1;
       }

       if(n == 1){
           return 0;
       }

       int res = 10000000;

       if(n % 3 == 0){
           res = 1+ sol(n/3);
       }

       if(n % 2 == 0){
           res = Math.min(res, 1+sol(n/2));
       }

       if(n > 1){
           res = Math.min(res, 1+sol(n-1));
       }

       return res;
    }
}
