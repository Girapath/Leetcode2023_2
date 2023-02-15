package January;

public class TwentySeventh {
    /**
     * leetcode 2309
     * @param s
     * @return
     */
    public String greatestLetter(String s) {
        int[] big = new int[26];
        int[] small = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') small[c-'a']++;
            else big[c-'A']++;
        }

        for(int i = 25; i >= 0; i--){
            if(big[i] > 0 && small[i] > 0){
                char res = (char)('A'+i);
                return res+"";
            }
        }

        return "";
    }

    public static void main(String[] args) {

    }
}
