package January;

public class Thirteenth {
    /**
     * leetcode 2287
     * @param s
     * @param target
     * @return
     */
    public int rearrangeCharacters(String s, String target) {
        int[] ss = new int[26];
        int[] ts = new int[26];

        for(int i = 0; i < s.length(); i++){
            ss[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < target.length(); i++){
            ts[target.charAt(i) - 'a']++;
        }

        int res = 0x3f3f3f3f;
        for(int i = 0; i < 26; i++){
            if(ts[i] == 0) continue;
            res = Math.min(res, ss[i]/ts[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
