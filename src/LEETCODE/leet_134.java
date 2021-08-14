package src.LEETCODE;

public class leet_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainGas = 0;
        for(int i=0; i<gas.length; i++){
            remainGas += gas[i] - cost[i];
        }

        if(remainGas<0){
            return -1;
        }

        int res = 0;
        int totalGas = 0;
        for(int i=0; i<gas.length; i++){
            remainGas = gas[i] - cost[i];

            if(totalGas + remainGas < 0){
                res = i+1;
                totalGas = 0;
            }
            else {
                totalGas += remainGas;
            }
        }

        return res;
    }
}
