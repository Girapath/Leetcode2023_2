package January;

import java.util.Arrays;

public class Nineth {
    /**
     * leetcode 1806
     * @param n
     * @return
     */
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] flags = new int[n];
        for(int i = 0; i < n; i++){
            perm[i] = i;
            flags[i] = i;
        }

        int[] arr = new int[n];
        int cnt = 0;
        while(!Arrays.equals(flags, arr)){
            for(int i = 0; i < n; i++){
                if(i % 2 == 0) arr[i] = perm[i/2];
                else arr[i] = perm[n/2+(i-1)/2];
            }
            for(int i = 0; i < n; i++) perm[i] = arr[i];
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
