package Match;

import java.io.FileReader;
import java.util.*;

public class Fourteenth {
    int num;
    protected int sum;
    public int age;
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2+"c";
        String s4 = "a"+"b"+"c";
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);

        Integer[] a = {1, 3, 2, 7, 5};
        Arrays.sort(a, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        Arrays.sort(a, (o1, o2)->(o2-o1));
        System.out.println(Arrays.toString(a));

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 4, 5, 3, 9, 6);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 4);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        Scanner sc = new Scanner(System.in);

//        try(FileReader fr = new FileReader("")) {
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
