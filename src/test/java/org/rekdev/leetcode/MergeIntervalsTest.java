package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MergeIntervalsTest {

  MergeIntervals merged;

  @BeforeEach
  void setUp() {
    merged = new MergeIntervals();
  }

  @Test
  void testExample1() {
    int[][] input = {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };
    int[][] expected = {
        {1, 6},
        {8, 10},
        {15, 18}
    };
    int[][] actual = merged.merge(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testExample2() {
    int[][] input = {
        {1, 4},
        {4, 5}
    };
    int[][] expected = {
        {1, 5}
    };
    int[][] actual = merged.merge(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testExample3() {
    int[][] input = {
        {4, 7},
        {1, 4}
    };
    int[][] expected = {
        {1, 7}
    };
    int[][] actual = merged.merge(input);
    assertThat(actual).isEqualTo(expected);
  }
}
