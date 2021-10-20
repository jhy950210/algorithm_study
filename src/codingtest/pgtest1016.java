package src.codingtest;

import java.util.*;

public class pgtest1016 {
    public static void main(String[] args) {
        String[] s = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String n = "cow";

        int leave = 4;
        String day ="FRI";
        int[] holidays = {6, 21, 23, 27, 28};

        System.out.println(solution2(leave,day,holidays));
    }

    public static String solution1(String[] registered_list, String new_id) {

        List<String> registeredList = Arrays.asList(registered_list);

        if(!registeredList.contains(new_id)){
            return new_id;
        }

        String S = "";
        String N = "";
        boolean isString = true;

        for(int i=0; i< new_id.length(); i++){
            char c = new_id.charAt(i);

            if(Character.isDigit(c)){
                isString = false;
                S = new_id.substring(0,i);
                N = new_id.substring(i);
                break;
            }
        }

        if(isString){
            S = new_id;
            N = "0";
        }
        int tmpInt = Integer.parseInt(N);

        while(true){

            tmpInt++;
            String toString = Integer.toString(tmpInt);

            String res = S + toString;

            if(!registeredList.contains(res)){
                return res;
            }
        }

    }

    public static int solution2(int leave, String day, int[] holidays) {
        Set<Integer> holidaySet = new HashSet<>();

        if("MON".equals(day)){
            for(int i=6; i<=30; i=i+7){
                holidaySet.add(i);
            }
            for(int i=7; i<=30; i=i+7){
                holidaySet.add(i);
            }
        }
        if("TUE".equals(day)){
            for(int i=5; i<=30; i=i+7){
                holidaySet.add(i);
            }
            for(int i=6; i<=30; i=i+7){
                holidaySet.add(i);
            }
        }
        if("WED".equals(day)){
            for(int i=4; i<=30; i=i+7){
                holidaySet.add(i);
            }
            for(int i=5; i<=30; i=i+7){
                holidaySet.add(i);
            }
        }
        if("THU".equals(day)){
            for(int i=3; i<=30; i=i+7){
                holidaySet.add(i);
            }
            for(int i=4; i<=30; i=i+7){
                holidaySet.add(i);
            }
        }
        if("FRI".equals(day)){
            for(int i=2; i<=30; i=i+7){
                holidaySet.add(i);
            }
            for(int i=3; i<=30; i=i+7){
                holidaySet.add(i);
            }
        }
        if("SAT".equals(day)){
            for(int i=1; i<=30; i=i+7){
                holidaySet.add(i);
            }
            for(int i=2; i<=30; i=i+7){
                holidaySet.add(i);
            }
        }
        if("SUN".equals(day)){
            for(int i=1; i<=30; i=i+7){
                holidaySet.add(i);
            }
            for(int i=7; i<=30; i=i+7){
                holidaySet.add(i);
            }
        }

        for (int holiday : holidays) {
            holidaySet.add(holiday);
        }
        int max = 0;

        for(int i=1; i<=29; i++){
            int tmp = dfs(i, leave, holidaySet);
            max = max > tmp ? max : tmp;
        }

        return max;
    }

    public static int dfs(int idx, int leave, Set holidaySet){
        int count = 0;

        for(int i=idx; i<=30; i++) {
            if (holidaySet.contains(i)) {
                count++;
            } else if (leave > 0) {
                leave--;
                count++;
            } else {
                return count;
            }
        }

        return count;
    }
}
