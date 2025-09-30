package org.rekdev.leetcode;

public class BestTimeToBuyAndSellStockII {

  /**
   * 122. Best Time to Buy and Sell Stock II
   * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
   *
   * <p>
   * You are given an integer array prices where prices[i] is the price of a given stock on the ith
   * day.<br/>
   * <br/>
   * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share
   * of the stock at any time. However, you can sell and buy the stock multiple times on the same
   * day, ensuring you never hold than one share of the stock.<br/>
   * <br/>
   * Find and return the maximum profit you can achieve.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: prices = [7,1,5,3,6,4]<br/>
   * Output: 7<br/>
   * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.<br/>
   * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.<br/>
   * Total profit is 4 + 3 = 7.
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: prices = [1,2,3,4,5]<br/>
   * Output: 4<br/>
   * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.<br/>
   * Total profit is 4.
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: prices = [7,6,4,3,1]<br/>
   * Output: 0<br/>
   * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve
   * the maximum profit of 0.
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= prices.length <= 3 * 10^4<br/>
   * - 0 <= prices[i] <= 10^4<br/>
   * </p>
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int totalProfit = 0;
    int lowIx = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < prices[lowIx]) {
        lowIx = i;
      }
      if (prices[i] > prices[lowIx]) {
        totalProfit += prices[i] - prices[lowIx];
        lowIx = i;
      }
    }
    return totalProfit;
  }
}
