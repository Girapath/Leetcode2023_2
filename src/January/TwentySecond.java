package January;

import java.util.*;

public class TwentySecond {
    public int alternateDigitSum(int n) {
        int res = 0;
        int cheng = 1;
        int cnt = 0;
        while(n > 0){
            res += cheng * (n%10);
            n/=10;
            cnt++;
            cheng *= -1;
        }

        if(cnt % 2 == 0) res = -res;
        return res;
    }


    public int[][] sortTheStudents(int[][] score, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] sc: score){
            map.put(sc[k], sc);
        }

        int[] sc = new int[score.length];
        for(int i = 0; i < score.length; i++){
            sc[i] = score[i][k];
        }

        Arrays.sort(sc);
        int len = score.length;
        int[][] res = new int[score.length][score[0].length];

        for(int i = 0; i < score.length; i++){
            int[] tmp = map.get(sc[len-1-i]);
            res[i] = tmp;
        }

        return res;
    }

    public boolean makeStringsEqual(String s, String target) {
        int[] ss = new int[2];
        int[] tt = new int[2];

        for(int i = 0; i < s.length(); i++){
            ss[s.charAt(i)-'0']++;
        }

        for(int i = 0; i < target.length(); i++){
            tt[target.charAt(i)-'0']++;
        }

        if(ss[1] > 0){
            return tt[1] > 0;
        }else{
            return tt[1] == 0;
        }
    }

//    Set<Integer> single;
//    Set<Integer> henduo;
//    public int minCost(int[] nums, int k) {
//        single = new HashSet<>();
//        henduo = new HashSet<>();
//        for(int num: nums){
//            if(single.contains(num)) henduo.add(num);
//            single.add(num);
//        }
//
//        for(int num: henduo){
//            single.remove(num);
//        }
//
//        if(k >= nums.length) return k+nums.length-single.size();
//
//        int r = 0;
//        for(int i = 0; i < nums.length; i++){
//            Set<Integer> all = new HashSet<>();
//            Set<Integer> reward = new HashSet<>();
//            while(r < nums.length && r-i < k){
//                all.add(nums[r]);
//                r++;
//            }
//        }
//    }

    public int minCost(int[] nums, int k) {
        int res = 0x3f3f3f3f;
        for(int i = 0; i < nums.length; i++){
            res = Math.min(res, cost(nums, 0, i, k)+cost(nums, i+1, nums.length-1, k));
        }

        return res;
    }

    public int cost(int[] nums, int l, int r, int k){
        if(l > r) return 0;
        return 0;
    }

    public static void main(String[] args) {

    }
}
