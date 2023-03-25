package Match;

import java.util.*;

public class Nineteenth {
    public int[] evenOddBit(int n) {
        int even = 0;
        int old = 0;
        int num = 0;
        while(n != 0){
            int m = n % 2;
            if(m == 1 && num % 2 == 1) old++;
            if(m == 1 && num % 2 == 0) even++;
            n /= 2;
            num++;
        }

        return new int[]{even, old};
    }

    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        int[][] fxs = {{-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};

        int n = grid.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rows.put(grid[i][j], i);
                cols.put(grid[i][j], j);
            }
        }

        int m = n*n;
        for(int i = 1; i < m; i++){
            int pre_r = rows.get(i-1);
            int pre_c = cols.get(i-1);
            int cur_r = rows.get(i);
            int cur_c = cols.get(i);

            boolean flag = false;
            for(int[] fx: fxs){
                if(pre_r+fx[0] == cur_r && pre_c+fx[1] == cur_c){
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }

        return true;
    }

    Map<Integer, Integer> map;
    int res = 0;
    public int beautifulSubsets(int[] nums, int k) {
        map = new HashMap<>();
        for(int num: nums) map.put(num, 0);
        //for(int i = 0; i < nums.length; i++) map.put(nums[i], 0);

        for(int i = 0; i < nums.length; i++){
//            int m = nums[i];
//            System.out.println(m);
//            if(map.containsKey(m)) System.out.println("yes "+ m);
//            int n = map.get(m);
            map.put(nums[i], map.get(nums[i])+1);
            res++;
            dfs(nums, k, i+1);
            map.put(nums[i], map.get(nums[i])-1);
        }

        return res;
    }

    void dfs(int[] nums, int k, int idx){
        if(idx >= nums.length) return;
        //res++;

//        for(int i = idx; i < nums.length; i++){
//            int num = nums[i];
//            dfs(nums, k, )
//        }
        dfs(nums, k, idx+1);
        int m = nums[idx]-k;
        int n = nums[idx]+k;
        if((!map.containsKey(m) || map.get(m) == 0) && (!map.containsKey(n) || map.get(n) == 0)){
            map.put(nums[idx], map.get(nums[idx])+1);
            res++;
            dfs(nums, k, idx+1);
            map.put(nums[idx], map.get(nums[idx])-1);
        }
    }

    public int findSmallestInteger(int[] nums, int value) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            int mol = qiumol(num, value);
//            while(set.contains(mol)){
//                mol += value;
//            }
            if(map.containsKey(mol)) mol = map.get(mol)+value;
            list.add(mol);
            set.add(mol);
            map.put(mol%value, mol);
        }

        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != i) return i;
        }
        return list.size();
    }

    int qiumol(int num, int v){
        if(num >= 0) return num % v;
        int a = (-num)/v+1;
        return (num+a*v)%v;
    }

    public static void main(String[] args) {
        Nineteenth nineteenth = new Nineteenth();
        int[] nums = {2,4,6};
        int k = 2;
        System.out.println(nineteenth.beautifulSubsets(nums, k));
    }
}
