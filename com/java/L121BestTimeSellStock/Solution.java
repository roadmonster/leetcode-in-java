package com.java.L121BestTimeSellStock;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sellStock(new int[]{7,1,5,3,6,4}));
    }

    public static int sellStock(int[]prices){
        if(prices.length < 2){
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
