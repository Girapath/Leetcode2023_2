package January;

public class Sixth {
    /**
     * leetcode 2180
     * @param num
     * @return
     */
    public int countEven(int num) {
        int cnt = 0;
        cnt = num/10*5-1;
        if(sum(num/10)%2 == 0){
            cnt += num%10/2+1;
        }else{
            cnt += (num%10+1)/2;
        }
        return cnt;
    }

    public int sum(int num){
        int cnt = 0;
        while(num > 0){
            cnt += num % 10;
            num /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
