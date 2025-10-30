package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  /**
   * 54. Spiral Matrix (Medium)
   * https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an m x n matrix, return all elements of the matrix in spiral order.
   * </p>
   * <p>
   * Example 1:<br/>
   * <img src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" alt="Example 1 image"/>
   * <pre>
   * Input: matrix = [
   *   [1,2,3],
   *   [4,5,6],
   *   [7,8,9]
   * ]
   * Output: [1,2,3,6,9,8,7,4,5]
   * </pre>
   * </p>
   * <p>
   * Example 2:<br/>
   * <img src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" alt="Example 2 image"/>
   * <pre>
   * Input: matrix = [
   *   [1,2,3,4],
   *   [5,6,7,8],
   *   [9,10,11,12]
   * ]
   * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
   * </pre>
   * </p>
   * <p>
   * Constraints:<br/>
   * - m == matrix.length<br/>
   * - n == matrix[i].length<br/>
   * - 1 <= m, n <= 10<br/>
   * - -100 <= matrix[i][j] <= 100<br/>
   * </p>
   *
   * @param matrix
   * @return
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    final int m = matrix.length;
    final int n = matrix[0].length;
    final List<Integer> spiralOrder = new ArrayList<>();
    int top = 0;
    int bottom = m - 1;
    int left = 0;
    int right = n - 1;
    while (top <= bottom && left <= right) {
      // Going RIGHT...
      for (int i = left; i <= right; i++) {
        spiralOrder.add(matrix[top][i]);
      }
      top++; // shrink the top boundary
      // Going DOWN...
      if (top <= bottom) {
        for (int i = top; i <= bottom; i++) {
          spiralOrder.add(matrix[i][right]);
        }
        right--; // shrink the right boundary
      }
      // Going LEFT...
      if (top <= bottom && left <= right) {
        for (int i = right; i >= left; i--) {
          spiralOrder.add(matrix[bottom][i]);
        }
        bottom--; // shrink the bottom boundary
      }
      // Going UP...
      if (top <= bottom && left <= right) {
        for (int i = bottom; i >= top; i--) {
          spiralOrder.add(matrix[i][left]);
        }
        left++;
      }
    }
    return spiralOrder;
  }
}
