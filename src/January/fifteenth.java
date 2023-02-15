package January;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fifteenth {
    public int differenceOfSum(int[] nums) {
        int yuansu = 0;
        for(int num: nums){
            yuansu += num;
        }

        int shuwei = 0;
        for(int num: nums){
            shuwei += shuweihe(num);
        }

        return Math.abs(yuansu-shuwei);
    }

    public int shuweihe(int num){
        int cnt = 0;
        while(num > 0){
            cnt += num % 10;
            num /= 10;
        }
        return cnt;
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for(int[] query: queries){
            for(int i = query[0]; i <= query[2]; i++){
                for(int j = query[1]; j <= query[3]; j++){
                    mat[i][j]++;
                }
            }
        }

        return mat;
    }

    public long countGood(int[] nums, int k) {
        long res = 0;
        int left = 0;
        int right = 0;
        int haoCnt = 0;
        int L = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(right < nums.length){
            while(right < nums.length && haoCnt < k){
                haoCnt = haoCnt - equalNum(map.getOrDefault(nums[right], 0));
                map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
                haoCnt += equalNum(map.get(nums[right]));
                right++;
            }
            //System.out.println("right "+right);

            if(haoCnt >= k){
                while(left < right && haoCnt >= k){
                    haoCnt -= equalNum(map.get(nums[left]));
                    map.put(nums[left], map.get(nums[left])-1);
                    haoCnt += equalNum(map.get(nums[left]));
                    left++;
                }
                //System.out.println("left "+left);
                res += (left-L)*(nums.length-right+1);
                L = left;
                //System.out.println(res);
            }
        }

        return res;
    }

    public int equalNum(int num){
        return num*(num-1)/2;
    }


    List<List<Integer>> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public long maxOutput(int n, int[][] edges, int[] price) {
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());

        for(int[] edge: edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        long res = 0;

        for(int i = 0; i < n; i++){
            long[] dp = new long[n];
            dp[i] = price[i];
            bfs(i, price[i], dp, price);

            long min = 0x3f3f3f3f;
            long max = 0;
            for(int j = 0; j < n; j++){
                //if(j == i) continue;
                if(dp[j] > max){
                    max = dp[j];
                }
                if(dp[j] < min){
                    min = dp[j];
                }
            }

            res = Math.max(res, max-min);
        }

        return res;
    }

    public void bfs(int node, long cur_price, long[] dp, int[] price){
        List<Integer> neigh = list.get(node);
        for(int i = 0; i < neigh.size(); i++){
            if(dp[neigh.get(i)] != 0) continue;
            dp[neigh.get(i)] = cur_price + price[neigh.get(i)];
            bfs(neigh.get(i), dp[neigh.get(i)], dp, price);
        }
    }

    /**
     * leetcode 2293
     * @param nums
     * @return
     */
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while(n > 1){
            int[] newNums = new int[n/2];
            for(int i = 0; i < n/2; i++){
                if(i % 2 == 0){
                    newNums[i] = Math.min(nums[2*i], nums[2*i+1]);
                }else{
                    newNums[i] = Math.max(nums[2*i], nums[2*i+1]);
                }
            }
            nums = newNums;
            n /= 2;
        }

        return nums[0];
    }

    public static void main(String[] args) {
        fifteenth fif = new fifteenth();
//        System.out.println(fif.countGood(new int[]{3,1,4,3,2,2,4}, 2));
        int[][] edges = {{0,1},{1,2},{1,3},{3,4},{3,5}};
        int[] price = {9,8,7,6,10,5};
        fif.maxOutput(6, edges, price);
    }
}
