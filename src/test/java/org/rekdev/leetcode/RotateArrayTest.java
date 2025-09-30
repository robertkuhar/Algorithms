package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateArrayTest {

  RotateArray rotateArray;

  @BeforeEach
  public void setup() {
    rotateArray = new RotateArray();
  }

  @Test
  public void testExample1() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7};
    final int[] expectedNums = {5, 6, 7, 1, 2, 3, 4};
    rotateArray.rotate(nums, 3);
    assertThat(nums).containsExactly(expectedNums);
  }

  @Test
  public void testExample2() {
    final int[] nums = {-1, -100, 3, 99};
    final int[] expectedNums = {3, 99, -1, -100};
    rotateArray.rotate(nums, 2);
    assertThat(nums).containsExactly(expectedNums);
  }
}
