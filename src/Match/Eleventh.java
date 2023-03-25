package Match;

import java.util.HashMap;
import java.util.Map;

public class Eleventh {
    /**
     *
     * @param array
     * @return
     */
    public String[] findLongestSubarray(String[] array) {
        String[] res;
        int resL = 0, resR = 0;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < array.length; i++){
            String s = array[i];
            if(isDigit(s)) sum--;
            else sum++;

            if(map.containsKey(sum)){
                if(i-map.get(sum) > max){
                    max = i-map.get(sum);
                    resL = map.get(sum)+1;
                    resR = i;
                }
            }else{
                map.put(sum, i);
            }
        }

        if(max == 0) return new String[0];
        res = new String[max];
        int idx = 0;
        for(int i = resL; i <= resR; i++){
            res[idx++] = array[i];
        }
        return res;
    }

    public boolean isDigit(String s){
        try {
            int a = Integer.parseInt(s);
        }
        catch (Exception e){
            return false;
        }


        return true;
    }

    public static void main(String[] args) {

    }
}
