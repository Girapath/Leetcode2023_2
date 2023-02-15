package January;

public class Sixteenth {
    /**
     * leetcode 1813
     * @param sentence1
     * @param sentence2
     * @return
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        return areSentencesSimilar1(sentence1,sentence2) || areSentencesSimilar2(sentence1, sentence2);
    }

    public boolean areSentencesSimilar1(String sentence1, String sentence2) {
        String[] ss1 = sentence1.split(" ");
        String[] ss2 = sentence2.split(" ");

        String[] longer;
        String[] shorter;

        if(ss1.length > ss2.length){
            longer = ss1;
            shorter = ss2;
        }else{
            longer = ss2;
            shorter = ss1;
        }

        int[] ll = new int[longer.length];

        int llen = longer.length;
        int slen = shorter.length;

        int j = 0;
        for(int i = 0; i < slen; i++){
            String s = shorter[i];
            while(j < llen){
                if(s.equals(longer[j])){
                    ll[j++] = 1;
                    break;
                }
                j++;
            }
            if(j == llen) break;
        }
        int pre = 1;
        int cnt = 0;
        for(int i = 0; i < llen; i++){
            if(pre == 1 && ll[i] == 0){
                cnt++;
            }
            if(cnt > 1) return false;
            pre = ll[i];
        }

        int num = 0;
        for(int i = 0; i < llen; i++) num += ll[i];

        return num == slen;
    }

    public boolean areSentencesSimilar2(String sentence1, String sentence2) {
        String[] ss1 = sentence1.split(" ");
        String[] ss2 = sentence2.split(" ");

        String[] longer;
        String[] shorter;

        if(ss1.length > ss2.length){
            longer = ss1;
            shorter = ss2;
        }else{
            longer = ss2;
            shorter = ss1;
        }

        int[] ll = new int[longer.length];

        int llen = longer.length;
        int slen = shorter.length;

        int j = llen-1;
        for(int i = slen-1; i >= 0; i--){
            String s = shorter[i];
            while(j >= 0){
                if(s.equals(longer[j])){
                    ll[j--] = 1;
                    break;
                }
                j--;
            }
            if(j < 0) break;
        }
        int pre = 1;
        int cnt = 0;
        for(int i = 0; i < llen; i++){
            if(pre == 1 && ll[i] == 0){
                cnt++;
            }
            if(cnt > 1) return false;
            pre = ll[i];
        }

        int num = 0;
        for(int i = 0; i < llen; i++) num += ll[i];

        return num == slen;
    }

    public static void main(String[] args) {

    }
}
