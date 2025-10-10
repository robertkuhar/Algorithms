package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinimumNumberOfArrowsTest {

  MinimumNumberOfArrows min;

  @BeforeEach
  public void setup() {
    min = new MinimumNumberOfArrows();
  }

  @Test
  public void testExample1() {
    final int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    int actual = min.findMinArrowShots(points);
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testExample2() {
    final int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
    int actual = min.findMinArrowShots(points);
    assertThat(actual).isEqualTo(4);
  }

  @Test
  public void testExample3() {
    final int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    int actual = min.findMinArrowShots(points);
    assertThat(actual).isEqualTo(2);
  }
}
