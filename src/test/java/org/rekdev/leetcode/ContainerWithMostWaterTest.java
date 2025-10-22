package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContainerWithMostWaterTest {

  ContainerWithMostWater containerWithMostWater;

  @BeforeEach
  public void setup() {
    containerWithMostWater = new ContainerWithMostWater();
  }

  @Test
  public void testExample1() {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int actual = containerWithMostWater.maxArea(height);
    assertThat(actual).isEqualTo(49);
  }

  @Test
  public void testExample2() {
    int[] height = {1, 1};
    int actual = containerWithMostWater.maxArea(height);
    assertThat(actual).isEqualTo(1);
  }

}
