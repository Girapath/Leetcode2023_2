package February;

import java.util.*;

public class Seventh {
    /**
     * leetcode 1604
     * @param keyName
     * @param keyTime
     * @return
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < keyName.length; i++){
            String key =  keyName[i];
            if(map.containsKey(key)){
                map.get(key).add(Str2Int(keyTime[i]));
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(Str2Int(keyTime[i]));
                map.put(key, list);
            }
        }

        for(String s: map.keySet()){
            if(isok(map.get(s))){
                res.add(s);
            }
        }

        Collections.sort(res);
        return res;
    }

    public int Str2Int(String s){
        int hour = Integer.parseInt(s.substring(0, 2));
        int min  = Integer.parseInt(s.substring(3, 5));
        return  hour*60+min;
    }

    public boolean isok(List<Integer> list){
        Collections.sort(list);
        for(int i = 0 ; i < list.size()-2; i++){
            if(list.get(i) + 60 >= list.get(i+2)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
