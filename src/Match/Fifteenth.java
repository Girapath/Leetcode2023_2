package Match;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fifteenth {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(10);
//        list.add(5.0);
        Class c = list.getClass();
        Method m = c.getMethod("add", Object.class);
        m.invoke(list, "ab");
        System.out.println(list);
        Object o = new Object();
    }
}
