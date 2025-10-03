package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  /**
   * 15. 3Sum
   * https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that...<br/>
   * - i != j, i != k, and j != k<br/>
   * - and nums[i] + nums[j] + nums[k] == 0.<br/>
   * <br/>
   * Notice that the solution set must not contain duplicate triplets.<br/>
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [-1,0,1,2,-1,-4]<br/>
   * Output: [[-1,-1,2],[-1,0,1]]<br/>
   * Explanation:<br/>
   * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.<br/>
   * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.<br/>
   * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.<br/>
   * The distinct triplets are [-1,0,1] and [-1,-1,2].<br/>
   * <br/>
   * Notice that the order of the output and the order of the triplets does not matter.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [0,1,1]<br/>
   * Output: []<br/>
   * Explanation: The only possible triplet does not sum up to 0.<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: nums = [0,0,0]<br/>
   * Output: [[0,0,0]]<br/>
   * Explanation: The only possible triplet sums up to 0.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 3 <= nums.length <= 3000<br/>
   * - -10^5 <= nums[i] <= 10^5<br/>
   * </p>
   *
   * @param nums integer array nums
   * @return distinct triplets summing to 0 from input nums
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    final Set<List<Integer>> uniqueTriples = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      int targetSum = 0 - nums[i];
      int leftIx = i + 1;
      int rightIx = nums.length - 1;
      while (leftIx < rightIx) {
        if (nums[leftIx] + nums[rightIx] == targetSum) {
          List<Integer> triple = new ArrayList<>(List.of(nums[i], nums[leftIx], nums[rightIx]));
          Collections.sort(triple);
          uniqueTriples.add(triple);
          leftIx++;
          rightIx--;
        } else if (nums[leftIx] + nums[rightIx] < targetSum) {
          leftIx++;
        } else {
          rightIx--;
        }
      }
    }
    return new ArrayList<>(uniqueTriples);
  }
}
