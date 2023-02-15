package January;

public class TwentyThird {
    /**
     * leetcode 2303
     * @param brackets
     * @param income
     * @return
     */
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int pre = 0;
        for(int i = 0; i < brackets.length; i++){
            if(income > brackets[i][0]){
                res += (double) (brackets[i][0] - pre)*brackets[i][1] / 100.0;
                pre = brackets[i][0];
            }else{
                res += (double) (income - pre)*brackets[i][1] / 100.0;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
