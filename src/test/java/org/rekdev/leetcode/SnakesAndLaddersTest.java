package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 909. Snakes and Ladders
 * https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SnakesAndLaddersTest {

  SnakesAndLadders snakesAndLadders;

  @BeforeEach
  void setUp() {
    snakesAndLadders = new SnakesAndLadders();
  }

  @Test
  void testExample1() {
    int[][] board = new int[][]{
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 35, -1, -1, 13, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 15, -1, -1, -1, -1}
    };
    int actual = snakesAndLadders.snakesAndLadders(board);
    assertThat(actual).isEqualTo(4);
  }

  @Test
  void testExample2() {
    int[][] board = new int[][]{
        {-1, -1},
        {-1, 3},
    };
    int actual = snakesAndLadders.snakesAndLadders(board);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void testUnreachable() {
    int[][] board = new int[][]{
        {1, -1, -1}, // Row 0 (7, 8, 9). Snake at 7 back to 1.
        {1, 1, 1},    // Row 1 (6, 5, 4). All snake to 1.
        {1, 1, 1}     // Row 2 (1, 2, 3). All snake to 1.
    };
    int actual = snakesAndLadders.snakesAndLadders(board);
    assertThat(actual).isEqualTo(-1);
  }
}
