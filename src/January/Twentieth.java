package January;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Twentieth {
    /**
     * leetcode 1817
     * @param logs
     * @param k
     * @return
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] log: logs){
            if(map.containsKey(log[0])){
                map.get(log[0]).add(log[1]);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(log[1]);
                map.put(log[0], set);
            }
        }

        for(int key: map.keySet()){
            res[map.get(key).size()]++;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
