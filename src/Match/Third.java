package Match;

public class Third {
    public int findNthDigit(int n) {
        n++;
        if(n <= 10) return n-1;
        long[] weishu = new long[12];
        weishu[1] = 10;
        for(int i = 2; i <= 11; i++){
            weishu[i] = weishu[i-1]+(long)(i*(Math.pow(10, i)*0.9));
        }

        int a = 0;
        for(int i = 1; i <= 11; i++){
            if(n <= weishu[i]){
                a = i;
                break;
            }
        }

        int shengyu = (int)(n-weishu[a-1]);
        int mol = shengyu % a;
        int shang = shengyu / a;
        int num = (int)Math.pow(10, a-1)+(shang-1);
        if(mol != 0) num++;
        String s = String.valueOf(num);
        char c;
        if(mol == 0) c = s.charAt(s.length()-1);
        else c = s.charAt(mol-1);
        System.out.println(c);
        return Integer.valueOf(String.valueOf(c));
    }

    public static void main(String[] args) {
        Third third = new Third();
        System.out.println(third.findNthDigit(2147483647));

        Fourteenth fourteenth = new Fourteenth();
        int age = fourteenth.age;
        int sum = fourteenth.sum;
        int num = fourteenth.num;

    }
}
