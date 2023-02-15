package January;

public class Third {
    /**
     * leetcode 2042
     * @param s
     * @return
     */
    public boolean areNumbersAscending(String s) {
        String[] ss = s.split(" ");
        int pre = -1;

        for(String str: ss){
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
                int strValue = Integer.valueOf(str);
                if(strValue <= pre) return false;
                pre = strValue;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
