package January;

import java.util.HashMap;
import java.util.Map;

public class Seventeenth {
    /**
     * leetcode 1814
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        int mol = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            int key = num - rev(num);
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        long res = 0;
        for(int key: map.keySet()){
            long val = map.get(key);
            long cnt = (val*(val-1)/2) % mol;
            res = (res + cnt) % mol;
            // long cnt = 0;
            // for(int i = 1; i < val; i++){
            //     cnt = (cnt+i)%mol;
            // }
            // res = (res+cnt)%mol;
        }
        return (int)res;
    }

    public int rev(int num){
        int res = 0;
        while(num > 0){
            res = res*10+num%10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
