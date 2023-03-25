package Match;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwentySecond {


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = preorder.length;

        for(int i = 0; i < n; i++) map.put(inorder[i], i);

        TreeNode root = build(0, n-1, 0, n-1, preorder);
        return root;
    }

    public TreeNode build(int pl, int pr, int il, int ir, int[] preorder){
        TreeNode root = new TreeNode(preorder[pl], null, null);
        int idx = map.get(root.val);
        if(idx > il) root.left = build(pl+1, pl+1+(idx-1-il), il, idx-1, preorder);
        if(idx < ir) root.right = build(pr-(ir-idx-1), pr, idx+1, ir, preorder);
        return root;
    }


    int[] quick_sort(int[] nums){
        q_sort(nums, 0, nums.length-1);
        return nums;
    }

    void q_sort(int[] nums, int left, int right){
        if(left >= right) return;
        int pivotIdx = selectPivot(nums[left], nums, left, right);
        q_sort(nums, left, pivotIdx-1);
        q_sort(nums, pivotIdx+1, right);
    }

    int selectPivot(int pivot, int[] nums, int l, int r){
        //int ll = l, rr = r;
        while(l < r){
            while(l < r && nums[r] >= pivot) r--;
            if(l < r) nums[l] = nums[r];
            while(l < r && nums[l] <= pivot) l++;
            if(l < r) nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        TwentySecond twentySecond = new TwentySecond();
        int[] nums = {1,4,6,2,9,5,4};
        System.out.println(Arrays.toString(twentySecond.quick_sort(nums)));
    }
}
