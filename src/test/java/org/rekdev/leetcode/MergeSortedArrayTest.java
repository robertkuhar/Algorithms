package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 88. Merge Sorted Arrays
 */
public class MergeSortedArrayTest {

  private void executeTest(
      MergeSortedArray merger,
      int[] nums1,
      int m,
      int[] nums2,
      int n,
      int[] expected,
      String label) {

    merger.merge(nums1, m, nums2, n);

    assertThat(nums1)
        .as(String.format("label: %s", label))
        .containsExactly(expected);
  }

  @Test
  public void testExample1() {
    final int[] nums1 = {1, 2, 3, 0, 0, 0};
    final int[] nums2 = {2, 5, 6};
    final int[] expected = {1, 2, 2, 3, 5, 6};
    executeTest(
        new MergeSortedArray(),
        nums1,
        3,
        nums2,
        3,
        expected,
        "testExample1");
  }

  @Test
  public void testExample2() {
    final int[] nums1 = {1};
    final int[] nums2 = new int[0];
    final int[] expected = {1};
    executeTest(
        new MergeSortedArray(),
        nums1,
        1,
        nums2,
        0,
        expected,
        "testExample2");
  }

  @Test
  public void testExample3() {
    final int[] nums1 = {0};
    final int[] nums2 = {1};
    final int[] expected = {1};
    executeTest(
        new MergeSortedArray(),
        nums1,
        0,
        nums2,
        1,
        expected,
        "testExample3");
  }

  @Test
  public void testExample4() {
    final int[] nums1 = {1, 2, 7, 0, 0, 0};
    final int[] nums2 = {2, 5, 6};
    final int[] expected = {1, 2, 2, 5, 6, 7};
    executeTest(
        new MergeSortedArray(),
        nums1,
        3,
        nums2,
        3,
        expected,
        "testExample4");
  }

  @Test
  public void testExample5() {
    final int[] nums1 = {2, 0};
    final int[] nums2 = {1};
    final int[] expected = {1, 2};
    executeTest(
        new MergeSortedArray(),
        nums1,
        1,
        nums2,
        1,
        expected,
        "testExample5");
  }
}
