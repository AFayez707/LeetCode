package BestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minimumPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int price : prices) {
            if(price < minimumPrice) {
                minimumPrice = price;
            } else if(maxProfit < price - minimumPrice) {
                maxProfit = price - minimumPrice;
            }
        }

        return maxProfit;
//        int leftPointer = 0, rightPointer = 1;
//        int currentMax = 0;
//        while (rightPointer < prices.length) {
//            if(prices[rightPointer] - prices[leftPointer] > 0) {
//                if(prices[rightPointer] - prices[leftPointer] > currentMax) {
//                    currentMax = prices[rightPointer] - prices[leftPointer];
//                }
//            } else {
//                leftPointer = rightPointer;
//            }
//            rightPointer++;
//        }
//        return currentMax;
    }
}
