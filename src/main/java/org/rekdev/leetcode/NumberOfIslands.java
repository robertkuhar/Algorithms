package org.rekdev.leetcode;

public class NumberOfIslands {

  /**
   * 200. Number of Islands
   * https://leetcode.com/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return
   * the number of islands.
   * </p>
   * <p>
   * An island is surrounded by water and is formed by connecting adjacent lands horizontally or
   * vertically. You may assume all four edges of the grid are all surrounded by water.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: grid = [<br/>
   *   [ "1", "1", "1", "1", "0" ],<br/>
   *   [ "1", "1", "0", "1", "0" ],<br/>
   *   [ "1", "1", "0", "0", "0" ],<br/>
   *   [ "0", "0", "0", "0", "0" ]<br/>
   * ]<br/>
   * Output: 1
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: grid = [<br/>
   *   [ "1", "1", "0", "0", "0"],<br/>
   *   [ "1", "1", "0", "0", "0"],<br/>
   *   [ "0", "0", "1", "0", "0"],<br/>
   *   [ "0", "0", "0", "1", "1"]<br/>
   * ]<br/>
   * Output: 3
   * </p>
   * <p>
   * Constraints:<br/>
   * - m == grid.length<br/>
   * - n == grid[i].length<br/>
   * - 1 <= m, n <= 300<br/>
   * - grid[i][j] is '0' or '1'.<br/>
   * </p>
   *
   * @param grid 2D binary grid which represents a map of '1's (land) and '0's (water)
   * @return return the number of islands.
   */
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int nIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        // If the cell is land...
        if (grid[i][j] == '1') {
          nIslands++;
          traverse(grid, i, j);
        }
      }
    }
    return nIslands;
  }

  private void traverse(char[][] grid, int r, int c) {
    // get out if the cell is out of bounds
    if (r < 0
        || r >= grid.length
        || c < 0
        || c >= grid[0].length) {
      return;
    }
    // get out if the cell is water
    if (grid[r][c] == '0') {
      return;
    }
    // make the cell water
    grid[r][c] = '0';
    traverse(grid, r - 1, c);
    traverse(grid, r + 1, c);
    traverse(grid, r, c - 1);
    traverse(grid, r, c + 1);
  }
}
