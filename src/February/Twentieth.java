package February;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Twentieth {
    /**
     * leetcode 剑指offer55-I
     * @param root
     * @return
     */

    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root == null) return 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while(list.size() > 0){
            List<TreeNode> level = new ArrayList<>();
            for(TreeNode treeNode: list){
                if(treeNode.left != null) level.add(treeNode.left);
                if(treeNode.right != null) level.add(treeNode.right);
            }
            list = level;
            res++;
        }
        return res;
    }


//    int res = 0;
//    public int maxDepth(TreeNode root) {
//        dfs(root, 0);
//        return res;
//    }

//    public void dfs(TreeNode node, int num){
//        if(node == null){
//            res = Math.max(res, num);
//            return;
//        }
//        else{
//            num++;
//            dfs(node.left, num);
//            dfs(node.right, num);
//        }
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * leetcode 剑指offer55-II
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(dfs(root)) return false;
        return true;
    }

    public int depth(TreeNode node){
        if(node == null) return 0;
        return Math.max(depth(node.left), depth(node.right))+1;
    }

    public boolean dfs(TreeNode node){
        if(node.left != null) dfs(node.left);
        if(Math.abs(depth(node.left) - depth(node.right)) > 1) return true;
        if(node.right != null) dfs(node.right);
        return false;
    }

    int len;
    char[][] b;
    int[][] visit;
    boolean flag = false;
    int maxR, maxC;
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        len = word.length();
        b = board;
        maxC = board[0].length;
        maxR = board.length;
        visit = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1) return true;
                    visit[i][j] = 1;
                    dfs(word, 1, i, j);
                    visit[i][j] = 0;
                }
            }
        }

        return flag;
    }

    public void dfs(String word, int idx, int r, int c){
        if(idx == word.length()){
            flag = true;
            return;
        }
        int[][] fxs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] fx: fxs){
            int newR = r+fx[0];
            int newC = c+fx[1];
            if(newR < 0 || newR >= maxR || newC < 0 || newC >= maxC || visit[newR][newC] == 1 || b[newR][newC] != word.charAt(idx)) continue;
            visit[newR][newC] = 1;
            dfs(word, idx+1, newR, newC);
            visit[newR][newC] = 0;
        }
    }

    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        if(n % 3 == 1){
            int res = 1;
            int num3 = n/3-1;
            for(int i = 0; i < num3; i++) res *= 3;
            return res*4;
        }else if(n % 3 == 2){
            int res = 2;
            int num3 = n/3;
            for(int i = 0; i < num3; i++) res *= 3;
            return res;
        }else{
            int res = 1;
            int num3 = n/3;
            for(int i = 0; i < num3; i++) res *= 3;
            return res;
        }
    }
}
