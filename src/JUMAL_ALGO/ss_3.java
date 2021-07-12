package src.JUMAL_ALGO;

public class ss_3 {
    public static void main(String[] args) {
        System.out.println(solution(122));
    }

    public static int solution(int num){
        int res = -1;
        int count = 0;

        while(num >= 0){
            if(num % 5 == 0){
                res = count + num/5;
                break;
            }

            if(num == 0){
                res = count + 1;
            } else if (num < 3){
                res = -1;
            }

            count++;
            num -= 3;
        }

        return res;
    }
}
