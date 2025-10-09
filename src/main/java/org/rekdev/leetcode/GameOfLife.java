package org.rekdev.leetcode;

public class GameOfLife {

  /**
   * 289. Game of Life
   * https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular
   * automaton devised by the British mathematician John Horton Conway in 1970."
   * </p>
   * <p>
   * The board is made up of an m x n grid of cells, where each cell has an initial state:<br/>
   * - live (represented by a 1)<br/>
   * - dead (represented by a 0).<br/>
   * </p>
   * <p>
   * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
   * following four rules (taken from the above Wikipedia article):<br/>
   * - Any live cell with fewer than two live neighbors dies as if caused by under-population.<br/>
   * - Any live cell with two or three live neighbors lives on to the next generation.<br/>
   * - Any live cell with more than three live neighbors dies, as if by over-population.<br/>
   * - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.<br/>
   * </p>
   * <p>
   * The next state of the board is determined by applying the above rules simultaneously to every
   * cell in the current state of the m x n grid board. In this process, births and deaths occur
   * simultaneously.
   * </p>
   * <p>
   * Given the current state of the board, update the board to reflect its next state.
   * </p>
   * <p>
   * Note that you do not need to return anything.
   * </p>
   * <p>
   * Example 1:<br/>
   * <pre>
   * 0, 1, 0   0, 0, 0
   * 0, 0, 1   1, 0, 1
   * 1, 1, 1   0, 1, 1
   * 0, 0, 0   0, 1, 0
   * </pre>
   * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]<br/>
   * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * <pre>
   * 1, 1   1, 1
   * 1, 0   1, 1
   * </pre>
   * Input: board = [[1,1],[1,0]]<br/>
   * Output: [[1,1],[1,1]]<br/>
   * </p>
   * <p>
   * Constraints<br/>
   * - m == board.length<br/>
   * - n == board[i].length<br/>
   * - 1 <= m, n <= 25<br/>
   * - board[i][j] is 0 or 1.<br/>
   * </p>
   * <p>
   * Follow-ups<br/>
   * - Could you solve it in-place? Remember that the board needs to be updated simultaneously:
   * You cannot update some cells first and then use their updated values to update other cells. <br/>
   * - In this question, we represent the board using a 2D array. In principle, the board is
   * infinite, which would cause problems when the active area encroaches upon the border of the
   * array (i.e., live cells reach the border). How would you address these problems?<br/>
   * </p>
   *
   * @param board Input board
   */
  public void gameOfLife(int[][] board) {
    class Pair {

      final int row;
      final int col;

      public Pair(int row, int col) {
        this.row = row;
        this.col = col;
      }
    }
    final Pair[] navigation = {
        new Pair(-1, -1),
        new Pair(-1, 0),
        new Pair(-1, 1),
        new Pair(0, -1),
        new Pair(0, 1),
        new Pair(1, -1),
        new Pair(1, 0),
        new Pair(1, 1)
    };

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        int liveNeighbors = 0;
        for (Pair p : navigation) {
          if (i + p.row >= 0
              && i + p.row < board.length
              && j + p.col >= 0
              && j + p.col < board[i].length) {
            // 1 is currently alive, 3 is 'marked for death'
            if (board[i + p.row][j + p.col] == 1 || board[i + p.row][j + p.col] == 3) {
              liveNeighbors++;
            }
          }
        }
        if (board[i][j] == 1) {
          if (liveNeighbors < 2 || liveNeighbors > 3) {
            board[i][j] = 3; // 3 is 'marked for death'
          }
        } else {
          if (liveNeighbors == 3) {
            board[i][j] = 2; // 2 is 'marked for life'
          }
        }
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 2) {
          board[i][j] = 1;
        } else if (board[i][j] == 3) {
          board[i][j] = 0;
        }
      }
    }
  }
}
