package January;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Second {
    /**
     * leetcode 1801
     * @param orders
     * @return
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        PriorityQueue<int[]> sellOrders = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

       //0:buy  1:sell
       //if buy, check lowest sell, if sell <= buy, match
       //if sell, check highest buy, if buy >= sell, match

        for(int[] order: orders){
            //buy
            if(order[2] == 0){
                //System.out.println("current: buy");
                //no sell
                if(sellOrders.size() == 0){
                    buyOrders.offer(order);
                    continue;
                }

                int[] lowestSell = sellOrders.peek();
                while(sellOrders.size() > 0 && lowestSell[0] <= order[0] && order[1] > 0){
                    if(lowestSell[1] > order[1]){
                        int[] sellOrder = {lowestSell[0], lowestSell[1] - order[1], 1};
                        sellOrders.poll();
                        sellOrders.offer(sellOrder);
                        order[1] = 0;
                        break;
                    }else if(lowestSell[1] == order[1]){
                        sellOrders.poll();
                        order[1] = 0;
                        break;
                    }else{
                        order[1] -= lowestSell[1];
                        sellOrders.poll();
                        if(sellOrders.size() == 0) break;
                        lowestSell = sellOrders.peek();
                    }

//                    System.out.println("lowest sell: "+lowestSell[0]);
//                    System.out.println("sell count: "+lowestSell[1]);
//                    System.out.println("buy price: "+order[0]);
//                    System.out.println("buy count: "+order[1]);
                }

                if(order[1] > 0) buyOrders.offer(order);
            }
            //sell
            else{
                //System.out.println("current: sell");
                //no buy
                if(buyOrders.size() == 0){
                    sellOrders.offer(order);
                    continue;
                }

                int[] highestBuy = buyOrders.peek();
                while(buyOrders.size() > 0 && highestBuy[0] >= order[0] && order[1] > 0){
                    if(highestBuy[1] > order[1]){
                        int[] buyOrder = {highestBuy[0], highestBuy[1] - order[1], 0};
                        buyOrders.poll();
                        buyOrders.offer(buyOrder);
                        order[1] = 0;
                        break;
                    }else if(highestBuy[1] == order[1]){
                        buyOrders.poll();
                        order[1] = 0;
                        break;
                    }else{
                        order[1] -= highestBuy[1];
                        buyOrders.poll();
                        if(buyOrders.size() == 0) break;
                        highestBuy = buyOrders.peek();
                    }

//                    System.out.println("highest buy: "+highestBuy[0]);
//                    System.out.println("buy count: "+highestBuy[1]);
//                    System.out.println("sell price: "+order[0]);
//                    System.out.println("sell count: "+order[1]);
                }

                if(order[1] > 0) sellOrders.offer(order);
            }
        }

        int mol = 1000000007;
        long res = 0;
        for(int[] order: buyOrders){
            res = (res + order[1]) % mol;
        }

        for(int[] order: sellOrders){
            res = (res + order[1]) % mol;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        Second second = new Second();
        /**
         * leetcode 1801
         */
        int[][] orders = {{10,5,0},{15,2,1},{25,1,1},{30,4,0}};
        System.out.println(second.getNumberOfBacklogOrders(orders));
    }
}
