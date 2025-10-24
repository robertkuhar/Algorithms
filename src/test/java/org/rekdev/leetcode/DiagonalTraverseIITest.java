package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiagonalTraverseIITest {

  DiagonalTraverseII diagonalTraverseII;

  @BeforeEach
  public void setup() {
    diagonalTraverseII = new DiagonalTraverseII();
  }

  @Test
  public void testExample1() {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3),
        List.of(4, 5, 6),
        List.of(7, 8, 9)
    );
    final int[] expected = {1, 4, 2, 7, 5, 3, 8, 6, 9};
    final int[] actual = diagonalTraverseII.findDiagonalOrder(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3, 4, 5),
        List.of(6, 7),
        List.of(8),
        List.of(9, 10, 11),
        List.of(12, 13, 14, 15, 16)
    );
    final int[] expected = {1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16};
    final int[] actual = diagonalTraverseII.findDiagonalOrder(input);
    assertThat(actual).isEqualTo(expected);
  }
}
