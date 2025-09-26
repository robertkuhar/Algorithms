package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesFromSortedArrayIITest {

  private RemoveDuplicatesFromSortedArrayII removeDups;

  @BeforeEach
  void setUp() {
    removeDups = new RemoveDuplicatesFromSortedArrayII();
  }

  @Test
  public void testExample1() {
    final int[] nums = {1, 1, 1, 2, 2, 3};
    final int[] expectedNums = {1, 1, 2, 2, 3};
    final int expected = 5;
    final int actual = removeDups.removeDuplicates(nums);
    assertThat(actual).isEqualTo(expected);

    final int[] actualNums = Arrays.copyOf(nums, actual);
    assertThat(actualNums).containsExactlyInAnyOrder(expectedNums);
  }

  @Test
  public void testExample2() {
    final int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    final int[] expectedNums = {0, 0, 1, 1, 2, 3, 3};
    final int expected = 7;
    final int actual = removeDups.removeDuplicates(nums);
    assertThat(actual).isEqualTo(expected);

    final int[] actualNums = Arrays.copyOf(nums, actual);
    assertThat(actualNums).containsExactlyInAnyOrder(expectedNums);
  }
}
