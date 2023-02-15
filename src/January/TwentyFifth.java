package January;

import java.util.*;

public class TwentyFifth {
    /**
     * leetcode 1632
     * @param matrix
     * @return
     */
    public int[][] matrixRankTransform(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];

        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                Node n = new Node(i, j, matrix[i][j]);
                nodes.add(n);
            }
        }

        Collections.sort(nodes);

        for(int i = 0; i < nodes.size(); i++){
            Node n = nodes.get(i);
            int r = n.r;
            int c = n.c;
            int v = n.v;
            //row
            int maxr_rk = 0;
            int maxr_v = -1000000010;
            for(int j = 0; j < matrix[0].length; j++){
                if(j == c) continue;
                if(res[r][j] > maxr_rk){
                    maxr_rk = res[r][j];
                    maxr_v = matrix[r][j];
                }
            }

            boolean flag = false;
            //col
            for(int j = 0; j < matrix.length; j++){
                if(j == r) continue;
                if(res[j][c] > maxr_rk){
                    maxr_rk = res[j][c];
                    maxr_v = matrix[j][c];
                }else if(maxr_rk > 0 && res[j][c] == maxr_rk){
                    if(maxr_v != matrix[j][c]) flag = true;
                    maxr_v = Math.min(maxr_v, matrix[j][c]);
                }
            }


            if(!flag && maxr_v == v) res[r][c] = maxr_rk;
            else res[r][c] = maxr_rk+1;

//            int j = i;
//            while(j >= 0 && nodes.get(j).v == v){
//                Node node = nodes.get(j);
//                if(res[r][c] > res[node.r][node.c]) res[node.r][node.c] = res[r][c];
//                j--;
//            }
            //同一行或同一列的才修改
            int rk = res[r][c];
            Queue<Node> q = new ArrayDeque<>();
            q.offer(n);
            while(q.size() > 0){
                Node node = q.poll();
                int rr = node.r;
                int cc = node.c;
                int vv = node.v;
                for(int m = 0; m < matrix[0].length; m++){
                    if(matrix[rr][m] == vv && res[rr][m] < rk){
                        res[rr][m] = rk;
                        Node tmp = new Node(rr, m, vv);
                        q.offer(tmp);
                    }
                }
                for(int m = 0; m < matrix.length; m++){
                    if(matrix[m][cc] == vv && res[m][cc] < rk){
                        res[m][cc] = rk;
                        Node tmp = new Node(m, cc, vv);
                        q.offer(tmp);
                    }
                }
            }
        }

        return res;
    }

//    public int[][] matrixRankTransform(int[][] matrix) {
//        int[][] res = new int[matrix.length][matrix[0].length];
//
//        List<Node> nodes = new ArrayList<>();
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                Node n = new Node(i, j, matrix[i][j]);
//                nodes.add(n);
//            }
//        }
//
//        Collections.sort(nodes);
//
//        for(int i = 0; i < nodes.size(); i++){
//            Node n = nodes.get(i);
//            int r = n.r;
//            int c = n.c;
//            int v = n.v;
//            //row
//            int maxr_rk = 0;
//            int maxr_v = -1000000010;
//            for(int j = 0; j < matrix[0].length; j++){
//                if(j == c) continue;
//                if(res[r][j] > 0 && v >= matrix[r][j]){
//                    maxr_rk = Math.max(maxr_rk, res[r][j]);
//                    maxr_v = Math.max(maxr_v, matrix[r][j]);
//                }
//            }
//
//            //col
//            if(maxr_v == v){
//                res[r][c] = maxr_rk;
//                continue;
//            }else{
//                for(int j = 0; j < matrix.length; j++){
//                    if(j == r) continue;
//                    if(res[j][c] > 0 && v >= matrix[j][c]){
//                        maxr_rk = Math.max(maxr_rk, res[j][c]);
//                        maxr_v = Math.max(maxr_v, matrix[j][c]);
//                    }
//                }
//            }
//
//            if(maxr_v == v) res[r][c] = maxr_rk;
//            else res[r][c] = maxr_rk+1;
//        }
//
//        return res;
//    }


    class Node implements Comparable<Node>{
        int r;
        int c;
        int v;
        public Node(int i, int j, int num){
            this.r = i;
            this.c = j;
            this.v = num;
        }

        @Override
        public int compareTo(Node o1){
            return this.v - o1.v;
        }
    }

    public static void main(String[] args) {

    }
}
