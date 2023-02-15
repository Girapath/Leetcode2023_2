package January;

public class Fourth {
    /**
     * leetcode 1802
     * @param n
     * @param index
     * @param maxSum
     * @return
     */
    public int maxValue(int n, int index, int maxSum) {
        long l = 1;
        long r = maxSum - n + 2;

        while(l < r){
            long mid = l + (r-l)/2;
            int midSum = minSum(mid, index, n, maxSum);
            System.out.println("mid: "+mid+" midSum: "+midSum);
            if(midSum <= maxSum) l = mid+1;
            else r = mid;
        }

        return (int)l-1;
    }

    public int minSum(long num, int index, int n, int maxSum){
        long preCnt, postCnt = 0;
        //pre
        if(index < num){
            preCnt = leijia(num) - leijia(num-index-1);
        }else{
            preCnt = leijia(num) + index+1 - num;
        }

        //post
        long postNum = n - index - 1;
        if(postNum < num){
            postCnt = leijia(num-1) - leijia(num-1 - postNum);
        }else{
            postCnt = leijia(num-1) + postNum - (num-1);
        }

        if(preCnt+postCnt > maxSum) return maxSum+1;
        else return (int)(preCnt+postCnt);
        //return preCnt + postCnt;
    }

    public long leijia(long num){
        return (1+num)*num/2;
    }

    public static void main(String[] args) {
        Fourth fourth = new Fourth();
        /**
         * leetcode 1802
         */
        System.out.println(fourth.maxValue(3, 0, 815094800));
    }
}
