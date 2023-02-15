package January;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Nineteenth {
    /**
     * leetcode 2299
     * @param password
     * @return
     */
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;
        Set<Character> set = new HashSet<>();
        char[] chars = "!@#$%^&*()-+".toCharArray();
        for(char c: chars) set.add(c);

        boolean big = false;
        boolean small = false;
        boolean special = false;
        boolean digit = false;

        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(i > 0 && c == password.charAt(i-1)) return false;
            if(c >= 'A' && c <= 'Z') big = true;
            else if(c >= 'a' && c <= 'z') small = true;
            else if(c >= '0' && c <= '9') digit = true;
            else if(set.contains(c)) special = true;
        }

        return big && small && special && digit;
    }

    public static void main(String[] args) {

    }
}
