package org.rekdev.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 128. Longest Consecutive Sequence (Medium)
 * https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestConsecutiveSequenceTest {

  LongestConsecutiveSequence longestConsecutiveSequence;

  @BeforeEach
  public void setup() {
    longestConsecutiveSequence = new LongestConsecutiveSequence();
  }

  @Test
  public void testExample1() {
    final int[] nums = new int[]{100, 4, 200, 1, 3, 2};
    final int actual = longestConsecutiveSequence.longestConsecutive(nums);
    assertEquals(4, actual);
  }

  @Test
  public void testExample2() {
    final int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    final int actual = longestConsecutiveSequence.longestConsecutive(nums);
    assertEquals(9, actual);
  }

  @Test
  public void testExample3() {
    final int[] nums = new int[]{1, 0, 1, 2};
    final int actual = longestConsecutiveSequence.longestConsecutive(nums);
    assertEquals(3, actual);
  }

  @Test
  public void testEdgecase() {
    final int[] nums = new int[0];
    final int actual = longestConsecutiveSequence.longestConsecutive(nums);
    assertEquals(0, actual);
  }
}
