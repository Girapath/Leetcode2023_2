package Match;

public class Tenth {
    /**
     * leetcode 1590
     * @param nums
     * @param p
     * @return
     */
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num: nums){
            sum = (sum+num) % p;
        }
        if(sum == 0) return 0;

        int[] visit = new int[nums.length];
        long[] add = new long[nums.length];
        for(int i = 0; i < nums.length; i++){
            add[i] = nums[i];
            if(nums[i] % p == sum) return 1;
            if(nums[i] % p == 0) visit[i] = 1;
        }

        for(int i = 1; i < nums.length-1; i++){
            for(int j = 0; j < nums.length-i; j++){
                if(visit[j] == 1) continue;
                add[j] = (add[j]+nums[j+i]) % p;
                if(add[j] == sum) return i+1;
                if(add[j] == 0) visit[j] = 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
