package February;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class eighteenth {
    /**
     * leetcode 剑指offer 53-1
     * @param nums
     * @param target
     * @return
     */
//    public int search(int[] nums, int target) {
//        int res = 0;
//        for(int num: nums){
//            if(num == target) res++;
//            if(num > target) break;
//        }
//        return res;
//    }

    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int l = searchMin(nums, target);
        int r = searchMax(nums, target);
        return r-l-1;
    }

    public int searchMin(int[] nums, int target){
        if(nums[0] >= target) return -1;
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = l+((r-l+1)>>1);
            //int mid2 = (r+l+1)>>1;
            if(nums[mid] >= target) r = mid-1;
            else l = mid;
        }
        return r;
    }

    public int searchMax(int[] nums, int target){
        if(nums[nums.length-1] <= target) return nums.length;
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = l+((r-l)>>1);
            if(nums[mid] > target) r = mid;
            else l = mid+1;
        }
        return l;
    }

    /**
     * leetcode 剑指offer-3
     * @param root
     * @param k
     * @return
     */
    int res = 0;
    public int kthLargest(TreeNode root, int k) {
        int num = 0;
        dfs(root, num, k);
        return res;
    }

    public void dfs(TreeNode node, int num, int k){
        if(node == null) return;
        dfs(node.right, num, k);
        num++;
        if(num == k) res = node.val;
        dfs(node.left, num, k);
    }

//    List<Integer> list = new ArrayList<>();
//    public int kthLargest(TreeNode root, int k) {
//        dfs(root);
//        return list.get(k-1);
//    }
//
//    public void dfs(TreeNode node){
//        if(node == null) return;
//        dfs(node.right);
//        list.add(node.val);
//        dfs(node.left);
//    }


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    public static void main(String[] args) {
        eighteenth e = new eighteenth();
        System.out.println(1+2>>1);
        //System.out.println(e.search(new int[]{5, 7, 7, 8, 8, 10}, 8));

    }
}
