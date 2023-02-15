package February;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Fourth {
    /**
     * leetcode 1798
     * @param coins
     * @return
     */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int l = 0, r = 1;

        for(int coin: coins){
            int newl = l+coin;
            int newr = r+coin;
            if(newl <= r){
                r = newr;
            }else{
                break;
            }
        }

        return r;
    }

    //TLE
//    public int getMaximumConsecutive(int[] coins) {
//        Arrays.sort(coins);
//
//        int minNum = 1;
//        Set<Integer> set = new HashSet<>();
//        set.add(0);
//
//        for(int coin: coins){
//            if(coin == 1) minNum++;
//            else break;
//        }
//
//        for(int i = 1; i < minNum; i++) set.add(i);
//
//        for(int coin: coins){
//            if(coin == 1) continue;
//            if(coin > minNum) break;
//
//            Set<Integer> tmp = new HashSet<>();
//            for(int num: set){
//                tmp.add(num+coin);
//            }
//
//            for(int num: tmp){
//                set.add(num);
//            }
//
//            while(true){
//                if(set.contains(minNum)) minNum++;
//                else break;
//            }
//        }
//
//        return minNum;
//    }

    // TLE
//    public int getMaximumConsecutive(int[] coins) {
//        Set<Integer> set = new HashSet<>();
//        set.add(0);
//
//        for(int coin: coins){
//            Set<Integer> tmp = new HashSet<>();
//            for(int num: set){
//                tmp.add(num+coin);
//            }
//
//            for(int num: tmp){
//                set.add(num);
//            }
//        }
//
//        int res = 0;
//        for(int i = 0; ; i++){
//            if(set.contains(i)) res++;
//            else break;
//        }
//
//        return res;
//    }

    /**
     * leetcode 330
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        long l = 0;
        long r = 1;
        int res = 0;

        for(int num: nums){
            if(r > n || num > n) break;
            long newL = num;
            long newR = r+num;
            if(newL <= r) r = newR;
            else{
                while(newL > r){
                    res++;
                    r += r;
                }
                r += num;
            }
        }

        while(r <= n){
            res++;
            r += r;
        }
        return res;
    }

    public static void main(String[] args) {
        Fourth fourth = new Fourth();
        /**
         * leetcode 1798
         */
        System.out.println(fourth.getMaximumConsecutive(new int[]{1, 3}));
    }
}
