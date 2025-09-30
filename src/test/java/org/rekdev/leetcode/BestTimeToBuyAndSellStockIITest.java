package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
 */
public class BestTimeToBuyAndSellStockIITest {

  BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStock;

  @BeforeEach
  public void setup() {
    bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStockII();
  }

  @Test
  public void testExample1() {
    final int[] prices = {7, 1, 5, 3, 6, 4};
    final int actual = bestTimeToBuyAndSellStock.maxProfit(prices);
    assertThat(actual).isEqualTo(7);
  }

  @Test
  public void testExample2() {
    final int[] prices = {1, 2, 3, 4, 5};
    final int actual = bestTimeToBuyAndSellStock.maxProfit(prices);
    assertThat(actual).isEqualTo(4);
  }

  @Test
  public void testExample3() {
    final int[] prices = {7, 6, 4, 3, 1};
    final int actual = bestTimeToBuyAndSellStock.maxProfit(prices);
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void testQuickOuts() {
    final int actualWhenNull = bestTimeToBuyAndSellStock.maxProfit(null);
    assertThat(actualWhenNull).isEqualTo(0);
    final int actualWhenEmpty = bestTimeToBuyAndSellStock.maxProfit(new int[0]);
    assertThat(actualWhenEmpty).isEqualTo(0);
  }
}
