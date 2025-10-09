package org.rekdev.leetcode;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

  GameOfLife gameOfLife;

  @BeforeEach
  public void setUp() {
    gameOfLife = new GameOfLife();
  }

  @Test
  public void example1() {
    final int[][] board = new int[][]{
        {0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0}
    };
    final int[][] expected = new int[][]{
        {0, 0, 0},
        {1, 0, 1},
        {0, 1, 1},
        {0, 1, 0}
    };
    gameOfLife.gameOfLife(board);
    assertThat(board).isEqualTo(expected);
  }

  @Test
  public void example2() {
    final int[][] board = new int[][]{
        {1, 1},
        {1, 0}
    };
    final int[][] expected = new int[][]{
        {1, 1},
        {1, 1}
    };
    gameOfLife.gameOfLife(board);
    assertThat(board).isEqualTo(expected);
  }
}
