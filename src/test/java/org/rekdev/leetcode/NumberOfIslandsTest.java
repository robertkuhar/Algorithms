package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class NumberOfIslandsTest {

  NumberOfIslands numberOfIslands;

  @BeforeEach
  void setUp() {
    numberOfIslands = new NumberOfIslands();
  }

  @Test
  public void testExample1() {
    char[][] grid = new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
    int actual =  numberOfIslands.numIslands(grid);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void testExample2() {
    char[][] grid = new char[][]{
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };
    int actual =  numberOfIslands.numIslands(grid);
    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void testNull() {
    assertThat(numberOfIslands.numIslands(null)).isEqualTo(0);
  }

  @Test
  public void testEmpty() {
    char[][] emptyGrid = new char[0][0];
    assertThat(numberOfIslands.numIslands(emptyGrid)).isEqualTo(0);
  }
}
