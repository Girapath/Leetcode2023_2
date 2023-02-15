package February;

public class Fifteenth {
    /**
     * leetcode 1124
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        int[] leijia = new int[hours.length];
        leijia[0] = (hours[0] > 8) ? 1: -1;
        for(int i = 1; i < hours.length; i++){
            if(hours[i] > 8) leijia[i] = leijia[i-1]+1;
            else leijia[i] = leijia[i-1]-1;
        }

        if(leijia[hours.length-1] > 0) return hours.length;

        for(int i = leijia.length-1; i >= 1; i--){
            if(leijia[i-1] > 0) return i;
            for(int j = 0; j+i < leijia.length; j++){
                if(leijia[j+i] - leijia[j] > 0){
                    return i;
                }
            }
        }
        return 0;
    }

//    public int longestWPI(int[] hours) {
//        int res = 0;
//        for(int i = 0; i < hours.length; i++){
//            int cnt = 0;
//            if(hours[i] > 8) cnt++;
//            else cnt--;
//            if(cnt > 0) res = Math.max(res, cnt);
//            for(int j = i+1; j < hours.length; j++){
//                if(hours[j] > 8) cnt++;
//                else cnt--;
//
//                if(cnt > 0){
//                    res = Math.max(j-i+1, res);
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Fifteenth fifteenth = new Fifteenth();
    }
}
