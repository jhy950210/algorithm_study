package JUMAL_ALGO;

/* 셀프 넘버 */
public class solution7 {
    public static boolean[] check = new boolean[10001];

    public static void main(String[] args) {
        // 셀프 넘버 찾기
        for(int i=1; i<10001; i++){
            int checkNum = calculate(i);

            if(checkNum < 10001){
                check[checkNum] = true;
            }
        }

        // 결과 출력
        for(int i=1; i<10001; i++){
            if(!check[i]){
                System.out.println(i);
            }
        }
    }

    static int calculate(int number){
        int sum = number;

        while(number !=0){
            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }
}
