package February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eighth {
    /**
     * leetcode 1233
     * @param folder
     * @return
     */
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        int[] isok = new int[folder.length];
        Arrays.sort(folder);

        for(int i = 0; i < folder.length; i++){
            String fa = folder[i];
            int len = fa.length();
            if(isok[i] == 0) res.add(fa);
            for(int j = i+1; j < folder.length; j++){
                if(folder[j].startsWith(fa)){
                    if(folder[j].charAt(len) == '/')
                        isok[j] = 1;
                }else{
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
