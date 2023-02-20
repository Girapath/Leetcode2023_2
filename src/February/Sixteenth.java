package February;

import java.util.Arrays;
import java.util.PriorityQueue;

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


    public int quickSelect(int[] s, int l, int r, int k){
        //int num = 0;
        if(l < r){
            int pivotIndex = adjustArray(s, l, r);
            if(pivotIndex+1 > k) return quickSelect(s, l, pivotIndex-1, k);
            else if(pivotIndex+1 < k) return quickSelect(s, pivotIndex+1, r, k);
            else return s[pivotIndex];
        }
        return 0;
    }

    public void quickSort(int[] s, int l, int r){
        if(l < r){
            int pivotIndex = adjustArray(s, l, r);
            quickSort(s, l, pivotIndex-1);
            quickSort(s, pivotIndex+1, r);
        }
    }

    public int adjustArray(int[] s, int l, int r){
        int pivot = s[l];
        int ll = l;
        int rr = r;
        while(ll < rr){
            while(ll < rr && s[rr] >= pivot) rr--;
            if(ll < rr){
                s[ll] = s[rr];
                ll++;
            }

            while(ll < rr && s[ll] <= pivot) ll++;
            if(ll < rr){
                s[rr] = s[ll];
                rr--;
            }
        }

        s[ll] = pivot;

        return ll;
    }

    public void test(int a){
        a = a+1;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            if(pq.size() < k) pq.offer(num);
            else{
                if(num > pq.peek()){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] num = {7, 6, 5, 4, 3, 2};
        Sixteenth sixteenth = new Sixteenth();
        sixteenth.quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));

        System.out.println(sixteenth.quickSelect(num, 0, num.length - 1, 3));

        int a = 3;
        sixteenth.test(a);
        System.out.println(a);
    }
}
