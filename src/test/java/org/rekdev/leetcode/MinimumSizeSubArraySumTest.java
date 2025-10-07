package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinimumSizeSubArraySumTest {

  MinimumSizeSubArraySum minimumSizeSubArraySum;

  @BeforeEach
  public void setup() {
    minimumSizeSubArraySum = new MinimumSizeSubArraySum();
  }

  @Test
  public void testExample1() {
    final int[] nums = new int[]{2, 3, 1, 2, 4, 3};
    final int actual = minimumSizeSubArraySum.minSubArrayLen(7, nums);
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testExample2() {
    final int[] nums = new int[]{1, 4, 4};
    final int actual = minimumSizeSubArraySum.minSubArrayLen(2, nums);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void testExample3() {
    final int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
    final int actual = minimumSizeSubArraySum.minSubArrayLen(11, nums);
    assertThat(actual).isEqualTo(0);
  }
}
