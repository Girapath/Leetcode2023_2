package January;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twelveth {
    /**
     * leetcode 1807
     * @param s
     * @param knowledge
     * @return
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list: knowledge){
            map.put(list.get(0), list.get(1));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                StringBuilder ssb = new StringBuilder();
                while(i < s.length() && s.charAt(++i) != ')'){
                    ssb.append(s.charAt(i));
                }
                sb.append(map.getOrDefault(ssb.toString(), "?"));
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
