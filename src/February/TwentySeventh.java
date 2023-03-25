package February;

import Match.Fourteenth;

import java.util.*;

public class TwentySeventh {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i <= len2; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if(c1 == c2){
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]));
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
                }
            }
        }

        return dp[len1][len2];
    }

    int[] visit;
    Set<String> res;
    public String[] permutation(String s) {
        res = new HashSet<>();
        visit = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            visit[i] = 1;
            dfs(sb, s);
            visit[i] = 0;
        }
        String[] r = new String[res.size()];
        int i = 0;
        for(String ss: res){
            r[i++] = ss;
        }
        return r;
    }

    public void dfs(StringBuilder sb, String s){
        if(isok(visit)){
            res.add(sb.toString());
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(visit[i] == 0){
                sb.append(s.charAt(i));
                visit[i] = 1;
                dfs(sb, s);
                visit[i] = 0;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public boolean isok(int[] a){
        for(int n: a){
            if(n == 0) return false;
        }
        return true;
    }

    public int majorityElement(int[] nums) {
        int cnt = 1;
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == res) cnt++;
            else cnt--;

            if(cnt < 0){
                res = nums[i];
                cnt = 1;
            }
        }

        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int a: arr){
            pq.offer(a);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            int a = pq.poll();
            res[i] = a;
        }
        return res;
    }

    public static void main(String[] args) {
        Fourteenth fourteenth = new Fourteenth();
        int age = fourteenth.age;
//        int sum = fourteenth.sum;
//        int num = fourteenth.num;
    }
}
