public class Sixteenth {
    /**
     * leetcode 2341
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {
        int[] cnt = new int[101];
        for(int num: nums) cnt[num]++;

        int[] res = new int[2];
        for(int i = 0; i < cnt.length; i++){
            res[0] += cnt[i]/2;
            res[1] += cnt[i]%2;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
