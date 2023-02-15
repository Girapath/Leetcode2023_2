package January;

public class Eleventh {
    /**
     * leetcode 2283
     * @param num
     * @return
     */
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        for(int i = 0; i < num.length(); i++){
            cnt[num.charAt(i)-'0']++;
        }

        for(int i = 0; i < num.length(); i++){
            if(cnt[i] != num.charAt(i)-'0') return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
