package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 215. Kth Largest Element in an Array (Medium)
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class KthLargestElemInArrayTest {

  KthLargestElemInArray kthLargestElemInArray;

  @BeforeEach
  public void setUp() {
    kthLargestElemInArray = new KthLargestElemInArray();
  }

  @Test
  public void testExample1() {
    int[] nums = new int[]{3, 2, 1, 5, 6, 4};
    int k = 2;
    int actual = kthLargestElemInArray.findKthLargest(nums, k);
    assertThat(actual).isEqualTo(5);
  }

  @Test
  public void testExample2() {
    int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    int actual = kthLargestElemInArray.findKthLargest(nums, k);
    assertThat(actual).isEqualTo(4);
  }

  @Test
  public void testEmptyArray() {
    assertThatThrownBy(() -> {
      kthLargestElemInArray.findKthLargest(new int[]{}, 1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testNullArray() {
    assertThatThrownBy(() -> {
      kthLargestElemInArray.findKthLargest(null, 1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testKLessThanOne() {
    assertThatThrownBy(() -> {
      kthLargestElemInArray.findKthLargest(new int[]{1, 2, 3}, -1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testKGreaterThanLengthOfArray() {
    assertThatThrownBy(() -> {
      kthLargestElemInArray.findKthLargest(new int[]{1, 2, 3}, 10);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
