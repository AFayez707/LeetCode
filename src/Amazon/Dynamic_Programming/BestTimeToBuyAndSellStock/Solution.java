package Amazon.Dynamic_Programming.BestTimeToBuyAndSellStock;

// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Time: O(N)
// Space: O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for(int price : prices)
            if(price < minPrice)
                minPrice = price;
            else if(maxProfit < price - minPrice)
                maxProfit = price - minPrice;

        return maxProfit;
    }

//        public int maxProfit(int[] prices) {
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
//    }
}
