package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesFromSortedArrayTest {

  private RemoveDuplicatesFromSortedArray removeDups;

  @BeforeEach
  void setUp() {
    removeDups = new RemoveDuplicatesFromSortedArray();
  }

  @Test
  public void testExample1() {
    final int[] nums = {1, 1, 2};
    final int[] expectedNums = {1, 2};
    final int expected = 2;
    final int actual = removeDups.removeDuplicates(nums);
    assertThat(actual).isEqualTo(expected);

    final int[] actualNums = Arrays.copyOf(nums, actual);
    assertThat(actualNums).containsExactlyInAnyOrder(expectedNums);
  }

  @Test
  public void testExample2() {
    final int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    final int[] expectedNums = {0, 1, 2, 3, 4};
    final int expected = 5;
    final int actual = removeDups.removeDuplicates(nums);
    assertThat(actual).isEqualTo(expected);

    final int[] actualNums = Arrays.copyOf(nums, actual);
    assertThat(actualNums).containsExactlyInAnyOrder(expectedNums);
  }
}
