package Match;

public class TwentyThird {
    public int minCost(int[] H, int[] W){
        int n = H.length;
        int h_max = 0;
        for(int h: H)
            if(h > h_max)
                h_max = h;

        int m = h_max+2;
        // dp[i][j]表示计算到第i个的高度为j的cost
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                dp[i][j] = -1;

        for(int i = 0; i < n; i++){
            //遍历当前第j列的可能高度
            for(int j = H[i]; j < m; j++){
                //遍历前一个dp[i-1]
                if(i == 0){
                    dp[i][j] = (j-H[i])*W[i];
                }else{
                    int min_pre_cost = 0x3f3f3f3f;
                    // 找到前一个dp[i-1]列的最小cost，并且不能与当前的高度j相同
                    for(int k = H[i-1]; k < m; k++){
                        if(k == j) continue;
                        if(dp[i-1][k] < min_pre_cost) min_pre_cost = dp[i-1][k];
                    }
                    dp[i][j] = min_pre_cost + (j-H[i])*W[i];
                }
            }
        }

        int res = 0x3f3f3f3f;
        //第n-1列的最小值即为最终结果
        for(int i = H[n-1]; i < m; i++)
            if(dp[n-1][i] < res)
                res = dp[n-1][i];

        return res;
    }

    public static void main(String[] args) {
        TwentyThird twentyThird = new TwentyThird();
        int[] H = {2, 2, 2, 3};
        int[] W = {1, 2, 3, 4};
        int cost = twentyThird.minCost(H, W);
        System.out.println(cost);
    }
}
