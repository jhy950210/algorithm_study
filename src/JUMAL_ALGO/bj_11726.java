package src.JUMAL_ALGO;

public class bj_11726 {

    public static void main(String[] args) {
        System.out.println(sol(9));
    }

    public static int sol(int n){
        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        return sol(n-2) + sol(n-1);
    }
}
