package January;

import java.util.*;

public class eighth {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for(int num : nums){
            if(num < 0) neg++;
            if(num > 0) pos++;
        }
        return Math.max(pos, neg);
    }

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        long cnt = 0;
        for(int num: nums) pq.offer(num);

        for(int i = 0; i < k; i++){
            int mmax = pq.peek();
            cnt += mmax;
            pq.poll();
            pq.offer(mmax/3+(mmax % 3 == 0?0:1));
        }

        return cnt;
    }

    public boolean isItPossible(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];

        for(int i = 0; i < word1.length(); i++){
            char c = word1.charAt(i);
            w1[c-'a']++;
        }

        for(int i = 0; i < word2.length(); i++){
            char c = word2.charAt(i);
            w2[c-'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(w1[i] == 0) continue;
            w1[i]--;
            for(int j = 0; j < 26; j++){
                if(w2[j] == 0) continue;
                w2[j]--;
                w1[w2[j]-'a']++;
                w2[w1[i]-'a']++;

                if(calNum(w1) == calNum(w2)) return true;
                w2[j]++;
                w2[w1[i]-'a']--;
                w1[w2[j]-'a']--;
            }
            //还原
            w1[i]++;

        }

        return false;
    }

    public int calNum(int[] a){
        int cnt = 0;
        for(int num: a){
            if(num > 0) cnt++;
        }
        return cnt;
    }



    class Worker{
        public Worker(int lr, int pick, int rl, int put, int idx){
            this.leftToRighti = lr;
            this.pickOld = pick;
            this.rightToLefti = rl;
            this.putNew = put;
            this.idx = idx;
            this.lraddrl = lr+rl;
        }
        int idx = 0;
        int leftToRighti = 0;
        int pickOld = 0;
        int rightToLefti = 0;
        int putNew = 0;
        int prior = 0;
        int lraddrl = 0;
        int arriveRightTime = 0;
        int arriveLeftTime = 0;
    }
    int currentTime = 0;
    boolean qiao = false;
    int qiaomeiren = 0;
    public int findCrossingTime(int n, int k, int[][] time) {
        Worker[] workers = new Worker[time.length];
        for(int i = 0; i < time.length; i++){
            Worker worker = new Worker(time[i][0], time[i][1], time[i][2], time[i][3], i);
            workers[i] = worker;
        }
        Arrays.sort(workers, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                if(o1.lraddrl == o2.lraddrl) return o1.idx - o2.idx;
                else return o1.lraddrl - o2.lraddrl;
            }
        });
        for(int i = 0; i < workers.length; i++){
            workers[i].prior = i;
        }

        PriorityQueue<Worker> leftWorkers = new PriorityQueue<>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.prior - o2.prior;
            }
        });
        List<Worker> LeftPut = new LinkedList<>();
        for(Worker worker: workers) leftWorkers.offer(worker);
        PriorityQueue<Worker> rightWorkers = new PriorityQueue<>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.prior - o2.prior;
            }
        });
        List<Worker> rightPick = new LinkedList<>();

        while(n > 0){
            //桥上有人
            if(qiao) continue;
            //桥上没人
            if(rightWorkers.size() > 0){
                Worker guoqiao = rightWorkers.poll();
                qiao = true;
                qiaomeiren = currentTime+guoqiao.rightToLefti;
                n--; //搬了一个过来
                for(int i = 0; i < LeftPut.size(); i++){
                    Worker worker = LeftPut.get(i);
                    if(worker.arriveLeftTime+worker.putNew <= qiaomeiren){
                        leftWorkers.offer(worker);
                        LeftPut.remove(i);
                    }
                }

                for(int i = 0; i < rightPick.size(); i++){
                    Worker worker = rightPick.get(i);
                    if(worker.arriveRightTime+worker.pickOld <= qiaomeiren){
                        rightWorkers.offer(worker);
                        rightPick.remove(i);
                    }
                }
                //把过桥的加入左方
                LeftPut.add(guoqiao);
            }
        }

        return 0;
    }


    /**
     * leetcode 2185
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        int len = pref.length();
        for(String word: words){
            if(word.length() < len) continue;
            if(word.substring(0, len).equals(pref)) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
