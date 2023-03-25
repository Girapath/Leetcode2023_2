package February;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwentyFirst {
    class CQueue {
        Deque<Integer> deque1;
        Deque<Integer> deque2;

        public CQueue() {
            deque1 = new ArrayDeque<>();
            deque2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            deque1.push(value);
        }

        public int deleteHead() {
            if(deque2.size() > 0) return deque2.pop();
            else{
                while(!deque1.isEmpty()){
                    int v = deque1.pop();
                    deque2.push(v);
                }
                if(deque2.size() == 0) return -1;
                return deque2.pop();
            }
        }
    }

    /**
     * 剑指offer 10-I
     * @param n
     * @return
     */
    int MOL = (int)1e9+7;
    public int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) dp[i] = (dp[i-1]+dp[i-2])%MOL;
        return dp[n];
    }

//    int MOL = (int)1e9+7;
//    public int fib(int n) {
//        if(n == 0) return 0;
//        if(n == 1) return 1;
//        return (fib(n-1)%MOL + fib(n-2)%MOL)%MOL;
//    }

    public int numWays(int n) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n+1];
        int MOL = (int)1e9+7;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOL;
        }

        return dp[n];
    }


    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            while(l < r && nums[l] % 2 == 1) l++;
            while(l < r && nums[r] % 2 == 0) r--;
            if(l >= r) break;
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }


}
