package org.rekdev.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 373. Find K Pairs with Smallest Sums (Medium)
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindKPairsSmallestSumTest {

  FindKPairsSmallestSum findKPairsSmallestSum;

  @BeforeEach
  public void setup() {
    findKPairsSmallestSum = new FindKPairsSmallestSum();
  }

  @Test
  public void testExample1() {
    final List<List<Integer>> expected = List.of(
        List.of(1, 2),
        List.of(1, 4),
        List.of(1, 6)
    );
    final List<List<Integer>> actual = findKPairsSmallestSum.kSmallestPairs(
        new int[]{1, 7, 11},
        new int[]{2, 4, 6},
        3);
    assertEquals(expected, actual);
  }

  @Test
  public void testExample2() {
    final List<List<Integer>> expected = List.of(
        List.of(1, 1),
        List.of(1, 1)
    );
    final List<List<Integer>> actual = findKPairsSmallestSum.kSmallestPairs(
        new int[]{1, 1, 2},
        new int[]{1, 2, 3},
        2);
    assertEquals(expected, actual);
  }

}
