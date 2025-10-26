package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 46. Permutations (Medium)
 * https://leetcode.com/problems/permutations/?envType=study-plan-v2&envId=top-interview-150
 */
public class PermutationsTest {

  Permutations permutations;

  @BeforeEach
  public void setup() {
    permutations = new Permutations();
  }

  @Test
  public void testExample1() {
    final int[] input = new int[]{1, 2, 3};
    final List<List<Integer>> expected = List.of(
        List.of(1, 2, 3),
        List.of(1, 3, 2),
        List.of(2, 1, 3),
        List.of(2, 3, 1),
        List.of(3, 1, 2),
        List.of(3, 2, 1)
    );
    List<List<Integer>> actual = permutations.permute(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    final int[] input = new int[]{0, 1};
    final List<List<Integer>> expected = List.of(
        List.of(0, 1),
        List.of(1, 0)
    );
    List<List<Integer>> actual = permutations.permute(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample3() {
    final int[] input = new int[]{1};
    final List<List<Integer>> expected = List.of(
        List.of(1)
    );
    List<List<Integer>> actual = permutations.permute(input);
    assertThat(actual).isEqualTo(expected);
  }
}
