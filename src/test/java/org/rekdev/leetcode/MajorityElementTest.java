package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 169. Majority Element<br/>
 * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MajorityElementTest {

  public MajorityElement majorityElement;

  @BeforeEach
  public void setup() {
    majorityElement = new MajorityElement();
  }

  @Test
  public void testExample1() {
    final int[] nums = {3, 2, 3};
    final int expected = 3;
    final int actual = majorityElement.majorityElement(nums);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    final int[] nums = {2, 2, 1, 1, 1, 2, 2};
    final int expected = 2;
    final int actual = majorityElement.majorityElement(nums);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample1_viaMap() {
    final int[] nums = {3, 2, 3};
    final int expected = 3;
    final int actual = majorityElement.majorityElementViaMap(nums);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2_viaMap() {
    final int[] nums = {2, 2, 1, 1, 1, 2, 2};
    final int expected = 2;
    final int actual = majorityElement.majorityElementViaMap(nums);
    assertThat(actual).isEqualTo(expected);
  }
}
