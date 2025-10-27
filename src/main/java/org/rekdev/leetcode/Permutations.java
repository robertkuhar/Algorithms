package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  /**
   * 46. Permutations (Medium)
   * https://leetcode.com/problems/permutations/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [1,2,3]<br/>
   * <pre>
   * Output: [
   *   [1, 2, 3],
   *   [1, 3, 2],
   *   [2, 1, 3],
   *   [2, 3, 1],
   *   [3, 1, 2],
   *   [3, 2, 1]
   * ]
   * </pre>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [0,1]<br/>
   * <pre>
   * Output: [
   *   [0, 1],
   *   [1, 0]
   * ]
   * </pre>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: nums = [1]<br/>
   * Output: [[1]]<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 6<br/>
   * - -10 <= nums[i] <= 10<br/>
   * - All the integers of nums are unique.<br/>
   * </p>
   * Insights:
   * - The number of the permutations is the factorial of the input len
   * - Recursion is used to fix one number and explore the others
   * - Gemini calls it "Backtracking"
   * - The best case is O(N + N!)
   * Generates all unique permutations of the given array of distinct integers.
   * Time Complexity: O(N * N!), where N is the length of nums.
   * Space Complexity: O(N * N!) to store the result, plus O(N) for the recursion stack.
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> currentPermutation = new ArrayList<>();
    // We use a boolean array to track which elements are already included
    boolean[] used = new boolean[nums.length];

    generatePermutations(nums, currentPermutation, used, results);
    return results;
  }

  private void generatePermutations(
      int[] nums,
      List<Integer> currentPermutation,
      boolean[] used,
      List<List<Integer>> results) {

    if (currentPermutation.size() == nums.length) {
      results.add(new ArrayList<>(currentPermutation));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        // These two are 'the move'
        currentPermutation.add(nums[i]);
        used[i] = true;
        generatePermutations(nums, currentPermutation, used, results);
        // These two are the actual backtrack; undo 'the move'
        used[i] = false;
        currentPermutation.remove(currentPermutation.size() - 1);
      }
    }
  }
}
