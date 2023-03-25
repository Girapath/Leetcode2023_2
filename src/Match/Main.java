package Match;

import java.util.*;

public class Main {
    //土地丈量
    public int tiandizhangliang(int rx, int ry, int[][] tudi){
        //int lx = 0, ly = 0;
        int res = 0;
        for(int[] t: tudi){
            int num = xiangjiao(0, rx, t[0], t[2]) * xiangjiao(0, ry, t[1], t[3]);
            //System.out.println(num);
            res += num;
        }

        return res;
    }

    public int xiangjiao(int f_start, int f_end, int s_start, int s_end){
        int min_start = Math.max(f_start, s_start);
        int min_end = Math.min(f_end, s_end);
        if(min_end - min_start > 0) return min_end -min_start;
        return 0;
    }

    //垦田计划
    public int kentianjihua_1(int m, int k, int[] tdss, int[] cost){
        TianDi[] tds = new TianDi[tdss.length];
        for(int i = 0; i < tdss.length; i++){
            TianDi td = new TianDi(i, tdss[i]);
            tds[i] = td;
        }

        PriorityQueue<TianDi> pq = new PriorityQueue<>((o1, o2)->(o2.val-o1.val));
        for(TianDi td: tds)
            pq.offer(td);

        while(true){
            TianDi td = pq.peek();
            //达到最小了
            if(td.val == k) break;
            //当前减1的cost
            int c = cost[td.idx];
            //资源不够了
            if(m < c) break;
            td.val--;
            pq.poll();
            pq.offer(td);
            m -= c;
        }

        return pq.peek().val;
    }

    public int kentianjihua_2(int m, int k, int[] tds, int[] cost){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tds.length; i++){
            int key = tds[i];
            int val = cost[i];
            map.put(key, map.getOrDefault(key, 0)+val);
        }

        Integer[] n_tds = new Integer[map.size()];
        int i = 0;
        for(int key: map.keySet()){
            n_tds[i] = key;
            i++;
        }

        Arrays.sort(n_tds, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Deque<Integer> new_tds = new LinkedList<>();
        Deque<Integer> new_cost = new LinkedList<>();
        for(int v: n_tds){
            new_tds.addLast(v);
            new_cost.addLast(map.get(v));
        }

        while(true){
            int cur_days = new_tds.pollFirst();
            int next_days = (new_tds.peekFirst()==null)?k:new_tds.peekFirst();
            int cur_cost = new_cost.pollFirst();

            if(cur_days <= k) return k;
            int decrease_days = cur_days - Math.max(k, next_days);
            int shang = m / cur_cost;
            //代价够
            if(shang >= decrease_days){
                if(k >= next_days) return k;
                int next_cost = new_cost.pollFirst();
                next_cost += cur_cost;
                new_cost.addFirst(next_cost);
                m = m - decrease_days * cur_cost;
            }else{
                return cur_days-shang;
            }
        }

    }

    public static void main(String[] args) {
        Main mm = new Main();
        Scanner in = new Scanner(System.in);

        //田地丈量
//        int rx, ry, n;
//        n = in.nextInt();
//        rx = in.nextInt();
//        ry = in.nextInt();
//        int[][] tudi = new int[n][4];
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < 4; j++)
//                tudi[i][j] = in.nextInt();
//        }
//
//        int res = mm.tiandizhangliang(rx, ry, tudi);
//        System.out.println(res);

        //垦田计划
        int n, m, k;
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        int[] tds = new int[n];
        int[] cost = new int[n];

        for(int i = 0; i < n; i++){
            tds[i] = in.nextInt();
            cost[i] = in.nextInt();
        }

        int res = mm.kentianjihua_2(m, k, tds, cost);
        System.out.println(res);
    }
}

class TianDi{
    int idx;
    int val;
    public TianDi(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}
