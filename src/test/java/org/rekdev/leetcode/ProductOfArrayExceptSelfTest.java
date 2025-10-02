package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150
 */
public class ProductOfArrayExceptSelfTest {

  ProductOfArrayExceptSelf productOfArrayExceptSelf;

  @BeforeEach
  public void setup() {
    productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
  }

  @Test
  public void testExample1() {
    int[] nums = new int[]{1, 2, 3, 4};
    int[] expected = new int[]{24, 12, 8, 6};
    int[] actual = productOfArrayExceptSelf.productExceptSelf(nums);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    int[] nums = new int[]{-1, 1, 0, -3, 3};
    int[] expected = new int[]{0, 0, 9, 0, 0};
    int[] actual = productOfArrayExceptSelf.productExceptSelf(nums);
    assertThat(actual).isEqualTo(expected);
  }
}
