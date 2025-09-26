package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 27. Remove Element
 */
public class RemoveElementTest {

  private RemoveElement removeElement;

  @BeforeEach
  void setUp() {
    removeElement = new RemoveElement();
  }

  @Test
  public void testExample1() {
    final int[] nums = {3, 2, 2, 3};
    final int[] expectedNums = {2, 2};
    final int expected = 2;
    final int actual = removeElement.removeElement(nums, 3);
    assertThat(actual).isEqualTo(expected);

    final int[] actualNums = Arrays.copyOf(nums, actual);
    assertThat(actualNums).containsExactlyInAnyOrder(expectedNums);
  }

  @Test
  public void testExample2() {
    final int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    final int[] expectedNums = {0, 0, 1, 3, 4};
    final int expected = 5;
    final int actual = removeElement.removeElement(nums, 2);
    assertThat(actual).isEqualTo(expected);

    final int[] actualNums = Arrays.copyOf(nums, actual);
    assertThat(actualNums).containsExactlyInAnyOrder(expectedNums);
  }
}
