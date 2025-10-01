package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 274. H-Index
 * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HIndexTest {

  HIndex hIndex;

  @BeforeEach
  public void setup() {
    hIndex = new HIndex();
  }

  @Test
  public void testExample1() {
    int[] citations = {3, 0, 6, 1, 5};
    int actual = hIndex.hIndex(citations);
    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void testExample2() {
    int[] citations = {1, 3, 1};
    int actual = hIndex.hIndex(citations);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void testEmptyCitations() {
    int[] citations = {};
    int actual = hIndex.hIndex(citations);
    assertThat(actual).isEqualTo(0);
  }
}
