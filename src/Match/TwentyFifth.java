package Match;

public class TwentyFifth {
    /**
     * leetcode 1574
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = arr.length-1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= arr[i-1]) l = i;
            else break;
        }

        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] <= arr[i+1]) r = i;
            else break;
        }

        if(l >= r) return 0;

        int res = Math.min(arr.length-1-l, r);

        int j = r;
        for(int i = 0; i <= l; i++){
            int num = arr[i];
            while(j < arr.length && arr[j] < num) j++;
            if(j == arr.length) break;
            res = Math.min(res, j-i-1);
        }

        return res;
    }




    //O(n²)超时
//    public int findLengthOfShortestSubarray(int[] arr) {
//        int[][] dp = new int[arr.length][2];
//        dp[0][0] = 1;
//
//
//        for(int i = 1; i < arr.length; i++){
//            if(arr[i] >= arr[i-1]){
//                if(dp[i-1][0] > 0) dp[i][0] = dp[i-1][0]+1;
//                dp[i][1] = dp[i-1][1]+1;
//                int max_0 = 0;
//                for(int j = 0; j < i-1; j++){
//                    if(arr[j] > arr[i]) continue;
//                    max_0 = Math.max(max_0, dp[j][0]);
//                }
//                if(max_0 > 0) dp[i][1] = Math.max(max_0+1, dp[i][1]);
//            }else{
//                //dp[i][0] = 1;
//                int max_0 = 0;
//                for(int j = 0; j < i; j++){
//                    if(arr[j] > arr[i]) continue;
//                    max_0 = Math.max(max_0, dp[j][0]);
//                }
//                dp[i][1] = max_0+1;
//            }
//        }
//
//        int res = 0;
//        for(int i = 0; i < arr.length; i++){
//            res = Math.max(res, dp[i][0]);
//        }
//        res = Math.max(res, dp[arr.length-1][1]);
//        return arr.length - res;
//    }

    public static void main(String[] args) {

    }
}
