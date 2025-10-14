package org.rekdev.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SnakesAndLadders {

  /**
   * 909. Snakes and Ladders
   * https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150
   *
   * <p>
   * You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a
   * Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and
   * alternating direction each row.
   * <p>
   * You start on square 1 of the board. In each move, starting from square curr, do the following:<br/>
   * - Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n^2)].<br/>
   * -- This choice simulates the result of a standard 6-sided die roll: i.e., there are always at
   * most 6 destinations, regardless of the size of the board.<br/>
   * - If next has a snake or ladder, you must move to the destination of that snake or ladder.
   * Otherwise, you move to next.<br/>
   * </p>
   * <p>
   * The game ends when you reach the square n2.
   * </p>
   * <p>
   * A board square on row r and column c has a snake or ladder if board[r][c] != -1. The
   * destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting
   * points of any snake or ladder.
   * </p>
   * <p>
   * Note that you only take a snake or ladder at most once per dice roll. If the destination to a
   * snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake
   * or ladder.
   * </p>
   * <p>
   * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination
   * square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
   * </p>
   * <p>
   * Return the least number of dice rolls required to reach the square n2. If it is not possible to
   * reach the square, return -1.
   * </p>
   * <p>
   * Example 1:<br/>
   * <pre>
   *     0  1  2  3  4  5
   * 0 |36|35|34|33|32|31|
   * 1 |25|26|27|28|29|30|
   * 2 |24|23|22|21|20|19|
   * 3 |13|14|15|16|17|18|
   * 4 |12|11|10| 9| 8| 7|
   * 5 | 1| 2| 3| 4| 5| 6|
   * </pre>
   * Input: board = [<br/>
   * <pre>
   *  [ -1, -1, -1, -1, -1, -1],
   *  [ -1, -1, -1, -1, -1, -1],
   *  [ -1, -1, -1, -1, -1, -1],
   *  [ -1, 35, -1, -1, 13, -1],
   *  [ -1, -1, -1, -1, -1, -1],
   *  [ -1, 15, -1, -1, -1, -1]
   * </pre>
   * ]<br/>
   * Output: 4<br/>
   * Explanation:<br/>
   * - In the beginning, you start at square 1 (at row 5, column 0).<br/>
   * - You decide to move to square 2 and must take the ladder to square 15.<br/>
   * - You then decide to move to square 17 and must take the snake to square 13.<br/>
   * - You then decide to move to square 14 and must take the ladder to square 35.<br/>
   * - You then decide to move to square 36, ending the game.<br/>
   * - This is the lowest possible number of moves to reach the last square, so return 4.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: board = [[-1,-1],[-1,3]]<br/>
   * Output: 1<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - n == board.length == board[i].length<br/>
   * - 2 <= n <= 20<br/>
   * - board[i][j] is either -1 or in the range [1, n^2].<br/>
   * - The squares labeled 1 and n^2 are not the starting points of any snake or ladder.<br/>
   * </p>
   *
   * Gemini did this. I can't claim it. I only mostly understand what its doing here. Its core is
   * BFS. It gets the return value by accumulating "moves" in an array. There is also a visited
   * array coming along. Shocking that leetcode calls this "Medium".
   *
   * @param board n x n integer matrix board
   * @return the lowest number of moves to reach the last square
   */
  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    int n2 = n * n; // The destination square label

    // BFS uses a Queue to track squares to visit and a visited array (or Set)
    // to prevent cycles and re-visiting squares unnecessarily.
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n2 + 1];

    // Start at square 1. The value stored in the queue is the square label.
    // We'll use the 'visited' array to store the minimum number of moves to reach that square.
    // Let's use 'visited' as a simple boolean array and track moves separately.

    // We can use a different array to store min moves to keep it cleaner.
    // Using -1 for unvisited, 0 for start.
    int[] moves = new int[n2 + 1];
    for (int i = 1; i <= n2; i++) {
      moves[i] = -1;
    }

    queue.offer(1); // Start square
    moves[1] = 0;   // 0 moves to reach the starting square

    // --- BFS Traversal ---
    while (!queue.isEmpty()) {
      int curr = queue.poll();

      // If we reached the end, return the moves count
      if (curr == n2) {
        return moves[n2];
      }

      // Iterate over all 6 possible die rolls
      for (int dieRoll = 1; dieRoll <= 6; dieRoll++) {
        int next = curr + dieRoll;

        // Stop if the roll goes past the end square
        if (next > n2) {
          break;
        }

        // 1. Convert the potential destination label (next) to board coordinates (r, c)
        int[] coords = getCoords(next, n);
        int r = coords[0];
        int c = coords[1];

        // 2. Check for snake or ladder at the board position
        int finalDest = next;
        if (board[r][c] != -1) {
          // We must take the snake/ladder
          finalDest = board[r][c];
        }

        // 3. Check if the final destination has not been reached yet
        if (moves[finalDest] == -1) {
          // Mark as visited by setting the minimum moves
          moves[finalDest] = moves[curr] + 1;

          // Add to queue for the next level of exploration
          queue.offer(finalDest);
        }
      }
    }

    // If the queue empties and we haven't reached n2, it's impossible.
    return -1;
  }

  /**
   * Translates a 1-based square label into 0-based row (r) and column (c) indices
   * based on the Boustrophedon (zig-zag, bottom-left start) pattern.
   */
  private int[] getCoords(int label, int n) {
    // Calculate the row (distance from the bottom)
    // (label - 1) is 0-indexed position. Dividing by n gives us the row number from the bottom.
    int rowFromBottom = (label - 1) / n;

    // Convert to 0-indexed row from the top
    int r = n - 1 - rowFromBottom;

    // Calculate the 0-indexed column within the row
    int colOffset = (label - 1) % n;

    // Determine if the current row moves left-to-right or right-to-left

    // If rowFromBottom is even (0, 2, 4, ...), the movement is Left-to-Right.
    if (rowFromBottom % 2 == 0) {
      // Left-to-Right: column index is just the offset
      return new int[]{r, colOffset};
    } else {
      // Right-to-Left: column index must be counted from the right
      return new int[]{r, n - 1 - colOffset};
    }
  }
}
