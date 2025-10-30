package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpiralMatrixTest {

  SpiralMatrix spiralMatrix;

  @BeforeEach
  public void setup() {
    spiralMatrix = new SpiralMatrix();
  }

  @Test
  public void testExample1() {
    final int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    final List<Integer> expected = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
    final List<Integer> actual = spiralMatrix.spiralOrder(matrix);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    final int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    final List<Integer> expected = List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
    final List<Integer> actual = spiralMatrix.spiralOrder(matrix);
    assertThat(actual).isEqualTo(expected);
  }
}
