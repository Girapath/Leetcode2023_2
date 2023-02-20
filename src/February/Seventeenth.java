package February;

import java.util.Stack;

public class Seventeenth {
    /**
     * leetcode 1139
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][4];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) dp[i][j][0] = 0;
                else if(j == 0) dp[i][j][0] = 1;
                else dp[i][j][0] = dp[i][j-1][0]+1;
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = grid[0].length-1; j >= 0; j--){
                if(grid[i][j] == 0) dp[i][j][1] = 0;
                else if(j == grid[0].length-1) dp[i][j][1] = 1;
                else dp[i][j][1] = dp[i][j+1][1]+1;
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) dp[i][j][2] = 0;
                else if(i == 0) dp[i][j][2] = 1;
                else dp[i][j][2] = dp[i-1][j][2]+1;
            }
        }

        for(int i = grid.length-1; i >= 0; i--){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) dp[i][j][3] = 0;
                else if(i == grid.length-1) dp[i][j][3] = 1;
                else dp[i][j][3] = dp[i+1][j][3]+1;
            }
        }

        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;
                int minLen = Math.min(dp[i][j][3], dp[i][j][1]);
                for(int k = res+1; k <= minLen; k++){
                    if(i+k-1 >= grid.length || j+k-1 >= grid[0].length) break;
                    if(grid[i+k-1][j+k-1] == 0) continue;
                    if(dp[i+k-1][j+k-1][0] >= k && dp[i+k-1][j+k-1][2] >= k) res = Math.max(res, k);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Integer a = -1024;
        Integer b = -1024;
        System.out.println(a.equals(b));
    }
}
