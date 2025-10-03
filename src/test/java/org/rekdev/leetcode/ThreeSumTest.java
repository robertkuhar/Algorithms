package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class ThreeSumTest {

  ThreeSum threeSum;

  @BeforeEach
  public void setup() {
    threeSum = new ThreeSum();
  }

  @Test
  public void example1() {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> expected = List.of(
        List.of(-1, -1, 2),
        List.of(-1, 0, 1)
    );
    List<List<Integer>> actual = threeSum.threeSum(nums);
  }

  @Test
  public void example2() {
    int[] nums = new int[]{0, 1, 1};
    List<List<Integer>> expected = new ArrayList<>();
    List<List<Integer>> actual = threeSum.threeSum(nums);
  }

  @Test
  public void example3() {
    int[] nums = new int[]{0, 0, 0};
    List<List<Integer>> expected = List.of(
        List.of(0, 0, 0)
    );
    List<List<Integer>> actual = threeSum.threeSum(nums);
  }
}
