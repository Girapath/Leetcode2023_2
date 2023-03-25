package Match;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fourth {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if(s.length() < 2) return 1;
        int[] dp = new int[12];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= s.length(); i++){
            char c = s.charAt(i-1-1);
            char cc = s.charAt(i-1);
            if((c == '1') || (c == '2' && cc >= '0' && cc <= '5')) dp[i] = dp[i-1]+dp[i-2];
            else dp[i] = dp[i-1];
        }

        return dp[s.length()];
    }

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) dp[0][i] = grid[0][i] + dp[0][i-1];
        for(int i = 1; i < m; i++) dp[i][0] = grid[i][0] + dp[i-1][0];

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }

//    public int lengthOfLongestSubstring(String s) {
//        if(s.length() == 0) return 0;
//        int res = 0;
//        int l = -1;
//        int[] alpha = new int[26];
//        for(int i = 0; i < 26; i++) alpha[i] = -1;
//
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(alpha[c-'a'] != -1) l = Math.max(l, alpha[c-'a']);
//            res = Math.max(res, i-Math.max(alpha[c-'a'], l));
//            alpha[c-'a'] = i;
//        }
//        return res;
//    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = -1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.keySet().contains(c)) l = Math.max(l, map.get(c));
            map.put(c, i);
            res = Math.max(i-l, res);
        }

        return res;
    }
//
//    public int nthUglyNumber(int n) {
//
//    }


    class Student{
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return number == student.number && name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, number);
        }

        int number;

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Student student = (Student) o;
//            return number == student.number && Arrays.equals(name, student.name);
//        }
//
//        @Override
//        public int hashCode() {
//            int result = Objects.hash(number);
//            result = 31 * result + Arrays.hashCode(name);
//            return result;
//        }



        public Student(){

        }

    }

    public static void main(String[] args) {
        String a = null;
        String b = "a";
        System.out.println(Objects.equals(a, b));
    }
}
