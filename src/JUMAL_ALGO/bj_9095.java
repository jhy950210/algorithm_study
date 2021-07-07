package src.JUMAL_ALGO;

public class bj_9095 {

    public static void main(String[] args) {
        System.out.println(sol(4));
    }

    public static int sol(int num){
        if( num == 0 || num == 1 ){
            return 1;
        }

        int sum = 0;

        for(int i=1; i<=num && i<=3; i++){
            sum += sol(num-i);
        }

        return sum;
    }


}
