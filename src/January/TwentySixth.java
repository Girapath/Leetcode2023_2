package January;

public class TwentySixth {
    /**
     * leetcode 1663
     * @param n
     * @param k
     * @return
     */
    public String getSmallestString(int n, int k) {
        int a_num = 0;
        for(int i = 1; i <= n; i++){
            if((n-i)*26+i >= k) a_num = i;
            else break;
        }

        int medium = k - a_num - (n-a_num-1)*26;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a_num; i++) sb.append('a');
        if(a_num < n) sb.append((char)('a'+(medium-1)));
        for(int i = 0; i < n-a_num-1; i++) sb.append('z');
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
