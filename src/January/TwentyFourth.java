package January;

public class TwentyFourth {
    /**
     * leetcode 1828
     * @param points
     * @param queries
     * @return
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int cx = queries[i][0];
            int cy = queries[i][1];
            int r  = queries[i][2];

            int cnt = 0;
            for(int[] point: points){
                if((cx-point[0])*(cx-point[0]) + (cy-point[1])*(cy-point[1]) <= r*r) cnt++;
            }

            ans[i] = cnt;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
