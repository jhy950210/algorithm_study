package src.LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class leet_93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        doRestore("", s, 0);
        return res;
    }

    private void doRestore(String path, String s, int k){
        if(k==4 || s.isEmpty()){
            if(k==4 && s.isEmpty()){
                res.add(path.substring(1));
            }
            return;
        }

        for(int i=1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++){
            String part = s.substring(0,i);
            if(Integer.parseInt(part) <= 255){
                doRestore(path + "." + part, s.substring(i), k+1);
            }
        }
    }
}
