package src.LEETCODE;

import java.util.*;

public class leet_752 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println(openLock(deadends,target));
    }

    public static int openLock(String[] deadends, String target) {
        Queue<String> que = new LinkedList<>();
        HashSet<String> checkList = new HashSet<>(Arrays.asList(deadends));

        que.add("0000");
        int count = -1;

        while(!que.isEmpty()){
            count++;
            int size = que.size();

            for(int i=0; i<size; i++){
                String poll = que.poll();

                if(poll.equals(target)){
                    return count;
                }

                if(checkList.contains(poll)){
                    continue;
                }

                checkList.add(poll);
                que.addAll(successors(poll));

            }
        }

        return -1;
    }

    public static List<String> successors(String str){
        List<String> res = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1));
        }

        return res;
    }
}
