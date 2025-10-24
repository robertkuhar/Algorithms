package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverseII {

  /**
   * 1424. Diagonal Traverse II (Medium)
   * https://leetcode.com/problems/diagonal-traverse-ii/description/
   * <p>
   * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the
   * below images.
   * </p>
   * <p>
   * Example 1:<br/>
   * <img src="https://assets.leetcode.com/uploads/2020/04/08/sample_1_1784.png" alt="Input"/>
   * <pre>
   * Input: nums = [
   *   [1, 2, 3],
   *   [4, 5, 6],
   *   [7, 8, 9]
   * ]
   * Output: [1, 4, 2, 7, 5, 3, 8, 6, 9]
   * </pre>
   * </p>
   * Example 2:<br/>
   * <img src="https://assets.leetcode.com/uploads/2020/04/08/sample_2_1784.png" alt="Input"/>
   * <pre>
   * Input: nums = [
   *   [1, 2, 3, 4, 5],
   *   [6, 7],
   *   [8],
   *   [9, 10, 11],
   *   [12, 13, 14, 15, 16]
   * ]
   * Output: [1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16]
   * </pre>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 10^5<br/>
   * - 1 <= nums[i].length <= 10^5<br/>
   * - 1 <= sum(nums[i].length) <= 10^5<br/>
   * - 1 <= nums[i][j] <= 10^5<br/>
   * </p>
   *
   * Insight: Group the elements by diagonal using the sum of the row + col
   * Diagonal 0 is [ (0,0) ]
   * Diagonal 1 is [ (1,0), (0,1) ]
   * Diagonal 2 is [ (2,0), (1,1), (0,2) ]
   * Diagonal 3 is [ (2,1), (1,2) ]
   * Diagonal 4 is [ (2,2) ]
   *
   * @param nums
   * @return
   */
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    final List<Integer> diagonalOrderList = new ArrayList<>();
    final Map<Integer, List<Integer>> valuesByDiagonal = new HashMap<>();
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.get(i).size(); j++) {
        int diagonal = i + j;
        valuesByDiagonal
            .computeIfAbsent(diagonal, k -> new ArrayList<>())
            .add(nums.get(i).get(j));
      }
    }
    List<Integer> keys = new ArrayList<>(valuesByDiagonal.keySet());
    Collections.sort(keys);
    for (int i : keys) {
      List<Integer> values = valuesByDiagonal.get(i);
      Collections.reverse(values);
      diagonalOrderList.addAll(values);
    }
    return diagonalOrderList.stream().mapToInt(Integer::intValue).toArray();
  }
}
