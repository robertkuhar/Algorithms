package org.rekdev.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {

  /**
   * 45. Jump Game II
   * https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given a 0-indexed array of integers nums of length n. You are initially positioned at
   * index 0.
   * </p>
   * <p>
   * Each element nums[i] represents the maximum length of a forward jump from index i. In other
   * words, if you are at index i, you can jump to any index (i + j) where:<br/>
   * - 0 <= j <= nums[i]<br/>
   * - and i + j < n<br/>
   * <br/>
   * Return the minimum number of jumps to reach index n - 1. The test cases are generated such
   * that you can reach index n - 1.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [2,3,1,1,4]<br/>
   * Output: 2<br/>
   * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index
   * 0 to 1, then 3 steps to the last index.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [2,3,0,1,4]<br/>
   * Output: 2<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 10^4<br/>
   * - 0 <= nums[i] <= 1000<br/>
   * - It's guaranteed that you can reach nums[n - 1].<br/>
   * </p>
   * @param nums - array representing max length of a forward jump from any index in the array
   * @return minimum number of jumps to last index in nums
   */
  public int jump(int[] nums) {
    int lastIndex = nums.length - 1;
    int jumps = 0;
    int currentJumpEndIndex = 0;
    int farthestIndex = 0;
    for (int i = 0; i < lastIndex; i++) {
      farthestIndex = Math.max(farthestIndex, i + nums[i]);
      if (i == currentJumpEndIndex) {
        jumps++;
        currentJumpEndIndex = farthestIndex;
        if (farthestIndex >= lastIndex) {
          return jumps;
        }
      }
    }
    return jumps;
  }
}
