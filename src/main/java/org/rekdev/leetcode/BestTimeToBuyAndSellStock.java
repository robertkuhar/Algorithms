package org.rekdev.leetcode;

public class BestTimeToBuyAndSellStock {

  /**
   * 122. Best Time to Buy and Sell Stock II
   * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
   *
   * <p>
   * You are given an array prices where prices[i] is the price of a given stock on the ith day.
   * </p>
   * <p>
   * You want to maximize your profit by choosing a single day to buy one stock and choosing a
   * different day in the future to sell that stock.
   * </p>
   * <p>
   * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
   * profit, return 0.
   * </p>
   *
   * <p>
   * Example 1:<br/>
   * Input: prices = [7,1,5,3,6,4]<br/>
   * Output: 5<br/>
   * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.<br/>
   * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before
   * you sell.
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: prices = [7,6,4,3,1]<br/>
   * Output: 0<br/>
   * Explanation: In this case, no transactions are done and the max profit = 0.
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= prices.length <= 10^5<br/>
   * - 0 <= prices[i] <= 10^4<br/>
   * </p>
   *
   * @param prices array of prices indexed by day
   * @return max profit to be achieved from this transaction; 0 if no profit
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int maxProfit = 0;
    int lowIx = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < prices[lowIx]) {
        lowIx = i;
      }
      if (prices[i] > prices[lowIx]) {
        maxProfit =  Math.max(maxProfit, prices[i] - prices[lowIx]);
      }
    }
    return maxProfit;
  }
}
